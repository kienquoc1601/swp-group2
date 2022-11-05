package com.group2.swpgroup2.controllers.Forum;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ForumController {
    @GetMapping("/forum")
    public String MentorList(){
        return "Forum/Forum";
    }

}
