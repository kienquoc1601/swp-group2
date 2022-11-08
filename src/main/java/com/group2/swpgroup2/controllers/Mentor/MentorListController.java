package com.group2.swpgroup2.controllers.Mentor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.group2.swpgroup2.models.Mentor;
import com.group2.swpgroup2.repositories.MentorRepository;

@Controller
public class MentorListController {
    @Autowired
    MentorRepository mRepo;
    @GetMapping("/mentorlist")
    public String MentorList(Model model){
        List<Mentor> l = mRepo.findAll();
        model.addAttribute("l", l);
        return "Mentor/MentorList";
    }
}
