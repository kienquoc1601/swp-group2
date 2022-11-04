package com.group2.swpgroup2.controllers.System;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.group2.swpgroup2.models.Student;
import com.group2.swpgroup2.models.User;

import com.group2.swpgroup2.repositories.StudentRepository;
import com.group2.swpgroup2.repositories.UserRepository;

@Controller
public class authController {
    @Autowired
    private UserRepository uRepo;

    @Autowired
    private StudentRepository studentRepo;

    @GetMapping("/auth")
    public String auth(HttpServletResponse response, Model model) {
        String currentUserName = SecurityContextHolder.getContext().getAuthentication().getName();
        Cookie cookie = new Cookie("username", currentUserName);
        System.out.println(currentUserName);
        cookie.setMaxAge(60 * 60 * 24);
        cookie.setPath("/");
        response.addCookie(cookie);
        return "redirect:/";
    }
}
