package com.group2.swpgroup2.controllers.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.group2.swpgroup2.repositories.StudentRepository;

@Controller
public class ListStudentController {
    @Autowired
    private StudentRepository studentRepo;
}
