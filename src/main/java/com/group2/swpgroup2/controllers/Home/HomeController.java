package com.group2.swpgroup2.controllers.Home;

import org.springframework.web.bind.annotation.*;

// import com.group2.swpgroup2.repositories.BlogRepository;
import com.group2.swpgroup2.repositories.CategoryRepository;

import com.group2.swpgroup2.repositories.CourseRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

// import com.group2.swpgroup2.models.Blog;
import com.group2.swpgroup2.models.Category;
import com.group2.swpgroup2.models.Course;

@Controller
public class HomeController {
    @Autowired
    private CategoryRepository categoryRepo;

    // @Autowired
    // private BlogRepository blogRepo;


    @Autowired
    private CourseRepository courseRepo;


    @GetMapping("/home")
    public String Home(Model model, @CookieValue(value = "username", defaultValue = "") String username) {
        // list first 6 category that have hightest numCourse
        List<Category> categories = categoryRepo.findTop6ByOrderByNumCourseDesc();
        model.addAttribute("categories", categories);
        model.addAttribute("username", username);
        // may tôi chạy course thì cứ bị lỗi bean không tìm thấy
        // //list top 8 course that have hightest rating

         List<Course> courses = courseRepo.findTop8ByOrderByRatingDesc();
         model.addAttribute("courses", courses);


        // test, Quốc nhớ xóa chỗ này nhé :v
        // List<Blog> blogs = blogRepo.findTop8ByOrderByRatingDesc();
        // model.addAttribute("courses", blogs);
        // end test
        return "Home_Course/index";
        // return "common/headerOai2";
    }

    @GetMapping("/home2")
    public String Home2(Model model) {
        return "common/headerOai2";
    }

    @GetMapping("/home3")
    public String Home3(Model model) {
        return "common/footerOai2";
    }

    @GetMapping("/home4")
    public String Home4(Model model) {
        return "common/layoutOai2";
    }

}
