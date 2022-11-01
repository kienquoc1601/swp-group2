package com.group2.swpgroup2.controllers.System;

import java.lang.ProcessBuilder.Redirect;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.group2.swpgroup2.models.Student;
import com.group2.swpgroup2.models.User;
import com.group2.swpgroup2.repositories.StudentRepository;
import com.group2.swpgroup2.repositories.UserRepository;

@Controller
public class RegisterController {
    @Autowired
    private UserRepository uRepo;
    @Autowired
    private StudentRepository sRepo;
    
    

    @GetMapping("/register")
    public String Resgister() {
        return "RegisterForm/RegistForm";
    }

    @RequestMapping("/register")
    public String ResgisterSubmit(
        @RequestParam(value = "fullname" , required = false) String fullname,
        @RequestParam(value = "username", required = false) String username,
        @RequestParam(value = "password", required = false) String password,
        @RequestParam(value = "dob", required = false) Date dob,
        @RequestParam(value = "gender", required = false) String gender,
        Model model
    )
    {
        boolean a;
        if(gender.equalsIgnoreCase("male")){
            a = true;
        }else{
            a = false;
        }
        User u = new User(username,password, true);
        uRepo.save(u);
        Student s = Student.builder().username(username).fullname(fullname).dob(dob).gender(a).build();

        sRepo.save(s);
        return "redirect:/";
    }
    
}
