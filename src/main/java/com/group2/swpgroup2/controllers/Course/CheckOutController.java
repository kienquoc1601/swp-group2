package com.group2.swpgroup2.controllers.Course;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CheckOutController {
    
    @GetMapping("/checkout")
    public String CheckOut() {
        return "Cart/checkout";
    }
}
