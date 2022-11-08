package com.group2.swpgroup2.controllers.EditStudentProfile;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EditStudenProfile {
    @GetMapping("/editstudent")
    public String Student(){
        return "EditStudentProfile/EditStudentProfile";
    }
}
