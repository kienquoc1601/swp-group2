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
public class LoginController {
    @Autowired
    private UserRepository uRepo;

    @Autowired
    private StudentRepository studentRepo;

    @GetMapping("/login")
    public String login() {
        return "Login/login";
    }

    @PostMapping("/login")
    public String Login(@ModelAttribute("user") User user, HttpServletResponse response, Model model) {
        User uDB = uRepo.findByUsername(user.getUsername());
        if (uDB != null) {
            if (uDB.getPassword().equals(user.getPassword())) {
                // if user click remember me, save cookie
                // if (account.isRememberMe()) {
                    Cookie cookie = new Cookie("username", uDB.getUsername());
                    //set cookie expire in 1 day, path is root
                    cookie.setMaxAge(60 * 60 * 24);
                    cookie.setPath("/");
                    response.addCookie(cookie);
                    cookie = new Cookie("password", uDB.getPassword());
                    cookie.setMaxAge(60 * 60 * 24);
                    cookie.setPath("/");
                    response.addCookie(cookie);
                // }
                model.addAttribute("account", uDB);
                //add model student if found student by username
                Student student = studentRepo.findByUsername(uDB.getUsername());
                if (student != null) {
                    //add student to model
                    model.addAttribute("student", student);
                } else {
                    //return to login page if not found student
                    return "redirect:/login";
                }
                return "redirect:/home";
            }
        }
        return "redirect:/login";
    }
}
