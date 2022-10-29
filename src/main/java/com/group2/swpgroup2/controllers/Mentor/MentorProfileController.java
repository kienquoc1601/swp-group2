package com.group2.swpgroup2.controllers.Mentor;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.group2.swpgroup2.models.Mentor;
import com.group2.swpgroup2.repositories.MentorRepository;

@Controller
public class MentorProfileController {
    @Autowired
    MentorRepository mentorRepository;
    
    @GetMapping("/mentorprofile")
    public String MentorList(){
        return "MentorProfile/MentorProfile";
    }

    @GetMapping("/mentorprofile?cid={id}")
    public String ModuleListByID(Model model , @PathVariable String id){
        Optional<Mentor> m = mentorRepository.findById(Integer.parseInt(id));
        model.addAttribute("m", m);
        return "MentorProfile/MentorProfile";
    }
}
