package com.group2.swpgroup2.controllers.Question;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QuestionController {
    @GetMapping("/question")
    public String login() {
        return "Question/question";
    }
}
