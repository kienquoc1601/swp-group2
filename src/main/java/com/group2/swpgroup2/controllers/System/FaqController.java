package com.group2.swpgroup2.controllers.System;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.group2.swpgroup2.models.faq;
import com.group2.swpgroup2.repositories.FaqRepository;

@Controller
public class FaqController {
    @Autowired
    FaqRepository fRepo;

    @GetMapping("/faq")
    public String ModuleListByID(Model model){
        List<faq> fl = fRepo.findAll();
        model.addAttribute("fl", fl);
        return "FAQ/faq";
    }

}
