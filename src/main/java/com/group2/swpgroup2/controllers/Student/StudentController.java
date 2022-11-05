package com.group2.swpgroup2.controllers.Student;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.group2.swpgroup2.models.Student;
import com.group2.swpgroup2.repositories.StudentRepository;

public class StudentController {
    @Autowired
    StudentRepository sRepo;

    @GetMapping("/slist")
    public String QList(Model model, @PathVariable String id){
        List<Student> lq = sRepo.findAll();
        System.out.println(lq.size());
        model.addAttribute("lq", lq);
        return "Forum/PostPage";
    }
}
