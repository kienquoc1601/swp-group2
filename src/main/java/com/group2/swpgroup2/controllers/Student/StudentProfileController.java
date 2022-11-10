package com.group2.swpgroup2.controllers.Student;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentProfileController {
    @GetMapping("/studentprofile")
    public String StudentProfile(){
        return "ListStudent/StudentProfile";
    }
}
