package com.group2.swpgroup2.controllers.System;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.group2.swpgroup2.models.Account;
import com.group2.swpgroup2.models.Student;
import com.group2.swpgroup2.repositories.AccountRepository;
import com.group2.swpgroup2.repositories.StudentRepository;

@Controller
public class LoginController {
    @Autowired
    private AccountRepository accountRepo;

    @Autowired
    private StudentRepository studentRepo;

    @GetMapping("/login")
    public String Login() {
        return "OaiTemp/login";
    }

    @PostMapping("/login")
    public String Login(@ModelAttribute("account") Account account, HttpServletResponse response, Model model) {
        Account accountDB = accountRepo.findByUsername(account.getUsername());
        if (accountDB != null) {
            if (accountDB.getPassword().equals(account.getPassword())) {
                // if user click remember me, save cookie
                // if (account.isRememberMe()) {
                    Cookie cookie = new Cookie("username", accountDB.getUsername());
                    //set cookie expire in 1 day, path is root
                    cookie.setMaxAge(60 * 60 * 24);
                    cookie.setPath("/");
                    response.addCookie(cookie);
                    cookie = new Cookie("password", accountDB.getPassword());
                    cookie.setMaxAge(60 * 60 * 24);
                    cookie.setPath("/");
                    response.addCookie(cookie);
                // }
                model.addAttribute("account", accountDB);
                //add model student if found student by username
                Student student = studentRepo.findByUsername(accountDB.getUsername());
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
