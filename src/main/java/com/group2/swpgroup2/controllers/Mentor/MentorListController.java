package com.group2.swpgroup2.controllers.Mentor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MentorListController {
    
    @GetMapping("/mentorlist")
    public String MentorList(){
        return "common/layout1";
    }
}
