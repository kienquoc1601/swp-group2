package com.group2.swpgroup2.controllers.Forum;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PostPageController {
    @GetMapping("/postpage")
    public String MentorList(){
        return "Forum/PostPage";
    }
}
