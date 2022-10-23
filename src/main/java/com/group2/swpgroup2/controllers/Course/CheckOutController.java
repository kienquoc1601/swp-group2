package com.group2.swpgroup2.controllers.Course;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.group2.swpgroup2.models.Course;
import com.group2.swpgroup2.models.Student;
import com.group2.swpgroup2.repositories.CourseRepository;
import com.group2.swpgroup2.repositories.StudentRepository;

@Controller
public class CheckOutController {

    @Autowired
    private StudentRepository studentRepo;

    @Autowired
    private CourseRepository courseRepo;

    @GetMapping("/checkout")
    public String CheckOutGet(HttpServletRequest request, HttpServletResponse response,
            @CookieValue(value = "username", defaultValue = "") String username,
            @CookieValue(value = "courseCartCookie", defaultValue = "") String courseCartCookie,
            Model model) {
        System.out.println("================== getmapping checkout =======================");

        // 1. chuyển chuỗi courseCartCookie thành mảng các id course
        String[] coursesInCartArray = courseCartCookie.split("_");
        // 2. tạo một list các course từ mảng các id course
        List<Course> coursesInCart = new ArrayList<>();
        for (String courseId : coursesInCartArray) {
            if (!courseId.equals("")) {
                coursesInCart.add(courseRepo.findById(Integer.parseInt(courseId)));
            }
        }
        // 3. sắp xếp lại list các course theo thứ tự tăng dần của price
        for (int i = 0; i < coursesInCart.size() - 1; i++) {
            for (int j = i + 1; j < coursesInCart.size(); j++) {
                if (coursesInCart.get(i).getPrice() > coursesInCart.get(j).getPrice()) {
                    Course temp = coursesInCart.get(i);
                    coursesInCart.set(i, coursesInCart.get(j));
                    coursesInCart.set(j, temp);
                }
            }
        }

        // 4. add list course vào model
        model.addAttribute("coursesInCart", coursesInCart);
        // 5. tính tổng tiền
        int totalPrice = 0;
        for (Course course : coursesInCart) {
            totalPrice += course.getPrice();
        }
        // total price - 20% discount
        totalPrice = (int) (totalPrice * 0.8);
        model.addAttribute("totalPrice", totalPrice);
        // 6. model size of cart
        model.addAttribute("sizeOfCart", coursesInCart.size());

        // 7. lấy thông tin học sinh bằng username
        Student student = studentRepo.findByUsername(username);
        // split first name and last name of student full name
        String[] studentName = student.getFullname().split(" ");
        model.addAttribute("studentFirstName", studentName[0]);
        model.addAttribute("studentLastName", studentName[1]);

        return "Cart/checkout";
    }

    @PostMapping("/checkout")
    public String CheckOutPost(HttpServletRequest request, HttpServletResponse response,
            @CookieValue(value = "username", defaultValue = "") String username,
            @CookieValue(value = "courseCartCookie", defaultValue = "") String courseCartCookie,
            Model model) {
        System.out.println("================== postmapping checkout =======================");

        // 1. chuyển chuỗi courseCartCookie thành mảng các id course
        String[] coursesInCartArray = courseCartCookie.split("_");
        // 2. tạo một list các course từ mảng các id course
        List<Course> coursesInCart = new ArrayList<>();
        for (String courseId : coursesInCartArray) {
            if (!courseId.equals("")) {
                coursesInCart.add(courseRepo.findById(Integer.parseInt(courseId)));
            }
        }
        // 3. lấy thông tin học sinh bằng username
        Student student = studentRepo.findByUsername(username);
        // 4. in ra những course id mà học sinh đã mua
        List<Integer> courseIdsBought = courseRepo.findByStudentId(student.getStudentID());
        System.out.println("course bought: " + courseIdsBought);
        // 5. kiểm tra xem những course trong cart đã được mua chưa, nếu chưa thì thêm vào
        // list course mà học sinh đã mua
        for (Course course : coursesInCart) {
            if (!courseIdsBought.contains(course.getId())) {
                courseRepo.addCourseByStudentId(student.getStudentID(), course.getId());
            }
        }
        // 6. xóa cookie courseCartCookie
        Cookie courseCartCookieDelete = new Cookie("courseCartCookie", "");
        courseCartCookieDelete.setMaxAge(0);
        courseCartCookieDelete.setPath("/");
        response.addCookie(courseCartCookieDelete);
        
        return "Cart/done";
    }
}
