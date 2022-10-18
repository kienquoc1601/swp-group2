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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.group2.swpgroup2.models.Student;
import com.group2.swpgroup2.models.Course;
import com.group2.swpgroup2.repositories.CourseRepository;
import com.group2.swpgroup2.repositories.CourseStudentRepo;
import com.group2.swpgroup2.repositories.StudentRepository;

@Controller
public class CourseController {
    @Autowired
    private CourseRepository courseRepo;

    @Autowired
    private StudentRepository studentRepo;

    @Autowired
    private CourseStudentRepo courseStudentRepo;

    @GetMapping("/courses")
    public String Course(HttpServletRequest request, HttpServletResponse response, Model model,
            @CookieValue(value = "username", defaultValue = "") String username,
            @CookieValue(value = "courseCartCookie", defaultValue = "") String courseCartCookie) {
        // get user information
        model.addAttribute("username", username);
        Student student = studentRepo.findByUsername(username);
        model.addAttribute("student", student);
        // get all course
        model.addAttribute("courses", courseRepo.findAll());
        // if courseCart is not empty, get all course in courseCart
        // System.out.println a null page to see clear
        System.out.println(
                "===========================================================================================================================================================================");
        System.out.println(
                "===========================================================================================================================================================================");
        System.out.println(
                "===========================================================================================================================================================================");
        System.out.println(
                "===========================================================================================================================================================================");
        System.out.println(
                "===========================================================================================================================================================================");
        System.out.println(
                "===========================================================================================================================================================================");
        System.out.println(
                "===========================================================================================================================================================================");
        System.out.println(
                "===========================================================================================================================================================================");
        System.out.println(
                "===========================================================================================================================================================================");
        System.out.println("courseCartCookie: " + courseCartCookie);
        // model.addAttribute("courseCartList",
        // courseRepo.findTop2CourseFreeHightestRating());

        // //delete cookie courseCart
        // Cookie cookie = new Cookie("courseCartCookie", "");
        // cookie.setMaxAge(0);
        // cookie.setPath("/");
        // response.addCookie(cookie);

        // Cookie cookie = new Cookie("courseCart", "17_18_19");
        // cookie.setMaxAge(60 * 60 * 24);
        // cookie.setPath("/");
        // response.addCookie(cookie);
        // //get cookie courseCart from request
        // Cookie[] cookies = request.getCookies();
        // for (Cookie c : cookies) {
        // if (c.getName().equals("courseCart")) {
        // System.out.println("cookie courseCart: " + c.getValue());
        // }
        // }

        // get courseCart from cookie
        if (!courseCartCookie.equals("")) {
            String[] courseCartCookieArray = courseCartCookie.split("_");
            List<Course> courseCartList = new ArrayList<Course>();
            for (String s : courseCartCookieArray) {
                courseCartList.add(courseRepo.findById(Integer.parseInt(s)));
            }
            model.addAttribute("courseCartList", courseCartList);
            System.out.println("if: courseCartList: " + courseCartList);
        } else {
            try {
                // courseCartCookie đang trống, thêm tạm một course miễn phí có rating cao nhất
                // để thêm vào courseCart, tránh null
                List<Course> courseCartList = new ArrayList<Course>();
                courseCartList = courseRepo.findTop2CourseFreeHightestRating();
                model.addAttribute("courseCartList", courseCartList);
                System.out.println("else: courseCartList: " + courseCartList);

                String courseCartCookieString = "";
                for (Course c : courseCartList) {
                    courseCartCookieString += c.getId() + "_";
                }
                courseCartCookie = courseCartCookieString.substring(0, courseCartCookieString.length() - 1);
                System.out.println("before courseCartCookie: " + courseCartCookie);

                // add cookie courseCart
                Cookie cookie = new Cookie("courseCartCookie", courseCartCookie);
                cookie.setMaxAge(60 * 60 * 24 * 365);
                cookie.setPath("/");
                response.addCookie(cookie);

                // String temp = "";
                // //get cookie courseCart from request
                // Cookie[] cookies = request.getCookies();
                // for (Cookie c : cookies) {
                // if (c.getName().equals("courseCartCookie")) {
                // temp = c.getValue();
                // }
                // }
                // System.out.println("after courseCartCookie: " + temp);
            } catch (Exception e) {
                System.out.println("courseCartCookie is null: " + e.getMessage());
            }
        }
        return "Home_Course/courses";
    }

    @PostMapping("/courses/addtocart{courseID}")
    public String AddToCart(Model model, @ModelAttribute("courseID") int courseID,
            @CookieValue(value = "username", defaultValue = "") String username) {
        Student student = studentRepo.findByUsername(username);
        // kiểm tra xem đã mua khóa học này chưa, nếu chưa thì mới cho mua
        if (courseStudentRepo.findByCourseIDAndStudentID(courseID, student.getStudentID()) == null) {
            Course course = courseRepo.findById(courseID);

        }
        // CourseStudent courseStudent = new CourseStudent();
        // courseStudent.setCourseID(courseID);
        // courseStudent.setStudentID(student.getStudentID());
        // if (courseStudentRepo.save(courseStudent) != null) {
        // model.addAttribute("message", "Add to cart successfully!");
        // } else {
        // model.addAttribute("message", "Add to cart failed!");
        // }
        return "Home_Course/courses";
    }
}
