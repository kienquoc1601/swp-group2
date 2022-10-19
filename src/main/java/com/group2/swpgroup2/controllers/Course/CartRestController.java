package com.group2.swpgroup2.controllers.Course;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.group2.swpgroup2.models.Course;
import com.group2.swpgroup2.repositories.CourseRepository;

@RestController
public class CartRestController {
    @Autowired
    private CourseRepository courseRepo;

    // khi người dùng click vào nút cart trên header, lấy dữ liệu từ cookie và hiển
    // thị ra trang cart (popup)
    @GetMapping("/showCart")
    public List<Course> getCart(HttpServletRequest request, HttpServletResponse response,
            @CookieValue(value = "courseCartCookie", defaultValue = "") String courseCartCookie,
            Model model) {
                System.out.println("show cart ====== show cart ======= show cart ");
        // 1. chuyển chuỗi courseCartCookie thành mảng các id course
        String[] coursesInCartArray = courseCartCookie.split("_");
        // 2. tạo một list các course từ mảng các id course
        List<Course> coursesInCart = new ArrayList<>();
        for (String courseId : coursesInCartArray) {
            if (!courseId.equals("")) {
                coursesInCart.add(courseRepo.findById(Integer.parseInt(courseId)));
            }
        }
        // print out time now, không hiểu vì sao nó lại print ra 2 lần ???
        System.out.println("Time now: " + System.currentTimeMillis());
        // 3. trả về list các course ( để hiển thị ra popup cart) dưới dạng json
        return coursesInCart;
    }

    // khi người dùng click vào nút add to cart trên trang course list hoặc trong
    // course detail, thêm course vào cookie và thông báo đã thêm vào cart
    @PostMapping("/addToCart")
    public String AddToCart(Model model, @RequestParam(value = "courseId", required = false) int courseId,
            HttpServletRequest request, HttpServletResponse response,
            @CookieValue(value = "courseCartCookie", defaultValue = "") String courseCartCookie) {
        System.out.println("before: courseCartCookie: " + courseCartCookie);
        // 1. nối courseId vào courseCartCookie
        // kiểm tra xem course đã có trong cookie chưa
        String[] coursesInCartArray = courseCartCookie.split("_");
        boolean isCourseInCart = false;
        for (String course : coursesInCartArray) {
            if (course.equals(String.valueOf(courseId))) {
                isCourseInCart = true;
                break;
            }
        }
        if (!isCourseInCart) {
            if(courseCartCookie.equals("")) {
                courseCartCookie = String.valueOf(courseId);
            } else {
                courseCartCookie = courseCartCookie + "_" + courseId;
            }
        } else {
            return "fail";
        }
        System.out.println("after: courseCartCookie: " + courseCartCookie);
        // 2. update courseCartCookie
        Cookie cookie = new Cookie("courseCartCookie", courseCartCookie);
        cookie.setMaxAge(60 * 60 * 24 * 365);
        cookie.setPath("/");
        response.addCookie(cookie);
        // 3. lấy courseCartCookie mới update từ request
        String temp = "";
        Cookie[] cookies = request.getCookies();
        for (Cookie c : cookies) {
            if (c.getName().equals("courseCartCookie")) {
                temp = c.getValue();
            }
        }
        System.out.println("after: temp: " + temp);
        return "courseId: " + courseId;
    }
}
