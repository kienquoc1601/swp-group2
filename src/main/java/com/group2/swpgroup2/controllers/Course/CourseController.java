package com.group2.swpgroup2.controllers.Course;

// import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.ModelAttribute;
// import org.springframework.web.bind.annotation.PostMapping;

import com.group2.swpgroup2.models.Student;
import com.group2.swpgroup2.models.Course;
import com.group2.swpgroup2.repositories.CourseRepository;
// import com.group2.swpgroup2.repositories.CourseStudentRepo;
import com.group2.swpgroup2.repositories.StudentRepository;

@Controller
public class CourseController {
    @Autowired
    private CourseRepository courseRepo;

    @Autowired
    private StudentRepository studentRepo;

    // @Autowired
    // private CourseStudentRepo courseStudentRepo;

    @GetMapping("/courses")
    public String Course(HttpServletRequest request, HttpServletResponse response, Model model,
            @CookieValue(value = "username", defaultValue = "") String username,
            @CookieValue(value = "courseCartCookie", defaultValue = "") String courseCartCookie) {
                System.out.println("===============================================================================================================================================================");
        // 1. get all course
        List<Course> courses = courseRepo.findAll();
        model.addAttribute("courses", courses);
        // 2. get student by username
        Student student = studentRepo.findByUsername(username);
        model.addAttribute("student", student);
        return "Home_Course/courses";
    }

    @GetMapping("/removeCart")
    public String RemoveCart(Model model, @CookieValue(value = "username", defaultValue = "") String username,
            @CookieValue(value = "courseCartCookie", defaultValue = "") String courseCartCookie,
            HttpServletResponse response) {
        // delete cookie courseCart
        Cookie cookie = new Cookie("courseCartCookie", "");
        cookie.setMaxAge(0);
        cookie.setPath("/");
        response.addCookie(cookie);
        return "redirect:/courses";
    }
}
