package com.group2.swpgroup2.controllers.EditMentorProfile;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EditMentorProfile {
    @GetMapping("/editmentor")
    public String Mentor(){
        return "EditMentorProfile/EditMentorProfile";
    }
}
