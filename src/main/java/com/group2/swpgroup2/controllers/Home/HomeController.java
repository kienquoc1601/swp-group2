package com.group2.swpgroup2.controllers.Home;

import org.springframework.web.bind.annotation.*;
import com.group2.swpgroup2.repositories.BlogRepository;
import com.group2.swpgroup2.repositories.CategoryRepository;
import com.group2.swpgroup2.repositories.CourseRepository;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.group2.swpgroup2.models.Blog;
import com.group2.swpgroup2.models.Category;
import com.group2.swpgroup2.models.Course;

@Controller
public class HomeController {
    @Autowired
    private CategoryRepository categoryRepo;

    @Autowired
    private BlogRepository blogRepo;

    @Autowired
    private CourseRepository courseRepo;

    @GetMapping("/home")
    public String Home(Model model, HttpServletRequest request,
            @CookieValue(value = "username", defaultValue = "") String username) {
        model.addAttribute("currentUrl", request.getRequestURI().toString());
        model.addAttribute("username", username);

        // 1. get all category with number of course join with course table
        List<Category> categories = categoryRepo.getTop8CategoryWithNumCourse();
        // đảo ngẫu nhiên thứ tự các category trong list
        Collections.shuffle(categories);
        model.addAttribute("categories", categories);

        // 2. get top 8 course have highest rating
        List<Course> courses = courseRepo.findTop8CourseByRating();
        // đảo ngẫu nhiên thứ tự các course trong list
        Collections.shuffle(courses);
        model.addAttribute("courses", courses);

        // 3. get top 3 blog have highest rating and newest
        List<Blog> blogs = blogRepo.findTop3BlogByRatingAndDate();
        // đảo ngẫu nhiên thứ tự các blog trong list
        Collections.shuffle(blogs);
        model.addAttribute("blogs", blogs);

        return "Home_Course/index";
    }

}
