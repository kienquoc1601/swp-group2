package com.group2.swpgroup2.controllers.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.group2.swpgroup2.repositories.StudentRepository;

@Controller
public class ListStudentController {
    @Autowired
    private StudentRepository studentRepo;
    // @GetMapping("/liststudent")
    // public String login() {
    //     return "ListStudent/ListStudent";
    // }
    @GetMapping("/liststudent")
    public String ListStudent(){
        return "ListStudent/ListStudent";
    }
}
