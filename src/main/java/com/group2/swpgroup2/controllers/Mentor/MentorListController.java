package com.group2.swpgroup2.controllers.Mentor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.group2.swpgroup2.models.Mentor;
import com.group2.swpgroup2.repositories.MentorRepository;

@Controller
public class MentorListController {
    @Autowired
    MentorRepository mRepo;
    @GetMapping("/admin/mentorlist")
    public String MentorList(Model model){
        List<Mentor> mentors = mRepo.findAll();
        model.addAttribute("mentors", mentors);
        return "Admin/mentorlist";
    }
    @PostMapping("/admin/mentorlist/add")
    public String AddMentor(@ModelAttribute("Mentor") Mentor mentor){
        if(mRepo.addMentor(mentor.getUsername(),mentor.getName(),mentor.getFullName(), mentor.getImgSrc(), mentor.isGender(), 
        mentor.getDob(), mentor.getPhone()) == 1) {
            return "redirect:/admin/mentorlist";
        } else {
            return "error";
        }
    }
    @GetMapping("/mentorlist/id={id}")
    public String ModuleList(Model model , @PathVariable String id){
        List<Mentor> l = mRepo.findByCourse(Integer.parseInt(id));
        model.addAttribute("l", l);
        return "Mentor/MentorList";
    }
}
