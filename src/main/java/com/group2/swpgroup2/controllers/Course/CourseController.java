package com.group2.swpgroup2.controllers.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.group2.swpgroup2.models.Student;
import com.group2.swpgroup2.repositories.CourseRepository;
import com.group2.swpgroup2.repositories.CourseStudentRepo;
import com.group2.swpgroup2.repositories.StudentRepository;

@Controller
public class CourseController {
    @Autowired
    private CourseRepository courseRepo;

    @Autowired
    private StudentRepository studentRepo;

    @Autowired
    private CourseStudentRepo courseStudentRepo;

    @GetMapping("/courses")
    public String Course(Model model, @CookieValue(value = "username", defaultValue = "") String username) {
        model.addAttribute("username", username);
        Student student = studentRepo.findByUsername(username);
        model.addAttribute("student", student);
        model.addAttribute("courses", courseRepo.findAll());
        model.addAttribute("coursesBought", courseRepo.findTop3ByOrderByRatingDesc());
        return "Home_Course/courses";
    }

    @PostMapping("/courses/addtocart{courseID}")
    public String AddToCart(Model model, @ModelAttribute("courseID") int courseID,  @CookieValue(value = "username", defaultValue = "") String username) {
        Student student = studentRepo.findByUsername(username);
        //kiểm tra xem đã mua khóa học này chưa, nếu chưa thì mới cho mua
        if (courseStudentRepo.findByCourseIDAndStudentID(courseID, student.getStudentID()) == null) {
            // Course course = courseRepo.findByCourseID(courseID);
            // //add this course to cookie
            // Cookie cookie = new Cookie("courseID", String.valueOf(courseID));
            // cookie.setMaxAge(60 * 60 * 24);
            // cookie.setPath("/");
            // model.addAttribute("course", course);
            // model.addAttribute("student", student);
        }   
            // CourseStudent courseStudent = new CourseStudent();
            // courseStudent.setCourseID(courseID);
            // courseStudent.setStudentID(student.getStudentID());
            // if (courseStudentRepo.save(courseStudent) != null) {
            //     model.addAttribute("message", "Add to cart successfully!");
            // } else {
            //     model.addAttribute("message", "Add to cart failed!");
            // }
        return "Home_Course/courses";
    }
}
