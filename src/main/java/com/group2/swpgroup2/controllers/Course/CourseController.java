package com.group2.swpgroup2.controllers.Course;

// import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

import com.group2.swpgroup2.models.Student;
import com.group2.swpgroup2.repositories.CourseRepository;
import com.group2.swpgroup2.repositories.StudentRepository;

@Controller
public class CourseController {
    @Autowired
    private CourseRepository courseRepo;

    @Autowired
    private StudentRepository studentRepo;

    @GetMapping("/courses")
    public String Course(Model model, @CookieValue(value = "username", defaultValue = "") String username) {
        model.addAttribute("username", username);
        Student student = studentRepo.findByUsername(username);
        model.addAttribute("student", student);

        // ArrayList<Integer> courseIDs = courseRepo.findByStudentID(student.getStudentID());
        // model.addAttribute("coursesBought", studentRepo.findByStudentID(student.getStudentID()));
        model.addAttribute("courses", courseRepo.findAll());
        return "Home_Course/courses";
    }
}
