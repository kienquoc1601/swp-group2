package com.group2.swpgroup2.controllers.Forum;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ForumDetailController {
    @GetMapping("/forumdetail")
    public String MentorList(){
        return "Forum/ForumDetail";
    }

}
