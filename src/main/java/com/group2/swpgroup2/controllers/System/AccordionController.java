package com.group2.swpgroup2.controllers.System;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccordionController {
    
    @GetMapping("/faq")
    public String login() {
        return "FAQ/faq";
    }
}
