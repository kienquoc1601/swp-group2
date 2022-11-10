package com.group2.swpgroup2.controllers.Student;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.group2.swpgroup2.models.Student;
import com.group2.swpgroup2.repositories.StudentRepository;

@Controller
public class StudentController {
    @Autowired
    StudentRepository sRepo;

    @GetMapping("/slist")
    public String QList(Model model, @PathVariable String id){
        List<Student> lq = sRepo.findAll();
        System.out.println(lq.size());
        model.addAttribute("lq", lq);
        return "ListStudent/ListStudent";
    }
    @GetMapping("/slist/id={id}")
    public String sList(Model model , @PathVariable String id){
        List<Student> lq = sRepo.findByCourse(Integer.parseInt(id));
        model.addAttribute("lq", lq);
        return "ListStudent/ListStudent";
    }
    @GetMapping("/sprofile/id={id}")
    public String sprofile(Model model , @PathVariable String id){
        Student s = sRepo.findByID(Integer.parseInt(id));
        model.addAttribute("s", s);
        return "ListStudent/StudentProfile";
    }
    @GetMapping("/profile")
    public String profile(Model model , @PathVariable String id){
        String current = SecurityContextHolder.getContext().getAuthentication().getName();
        Student s = sRepo.findStudentByUsername(current);
        model.addAttribute("s", s);
        return "ListStudent/StudentProfile";
    }
    
}
