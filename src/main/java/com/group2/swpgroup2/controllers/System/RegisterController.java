package com.group2.swpgroup2.controllers.System;

import java.lang.ProcessBuilder.Redirect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.group2.swpgroup2.models.User;
import com.group2.swpgroup2.repositories.UserRepository;

@Controller
public class RegisterController {
    @Autowired
    private UserRepository uRepo;

    

    @GetMapping("/register")
    public String Resgister() {
        return "RegisterForm/RegistForm";
    }
    @PostMapping("/register")
    public String ResgisterSubmit(@ModelAttribute User user, Model model) {
        model.addAttribute("user", user);
        @RequestParam(value = "fullname", required = false) String fullname,
        return "redirect:/";
    }
    
}
