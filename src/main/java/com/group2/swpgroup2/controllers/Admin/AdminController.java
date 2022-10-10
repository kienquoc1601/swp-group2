package com.group2.swpgroup2.controllers.Admin;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.group2.swpgroup2.repositories.BlogRepository;
import com.group2.swpgroup2.repositories.CourseRepository;

@Controller
public class AdminController {
    @Autowired
    private BlogRepository blogRepo;

    @Autowired
    private CourseRepository courseRepo;
    
    //admin dashboard
    @GetMapping("/admin")
    public String Admin(Model model, HttpServletRequest request){
        model.addAttribute("currentUrl", request.getRequestURI().toString());
        return "Admin/index";
    }

    //admin blog
    @GetMapping("/admin/blog")
    public String AdminBlog(Model model, HttpServletRequest request){
        //model current url to active menu
        model.addAttribute("currentUrl", request.getRequestURI().toString());
        //get all blog
        model.addAttribute("blogs", blogRepo.findAll());
        return "Admin/blog";
    }
}
