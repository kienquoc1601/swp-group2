package com.group2.swpgroup2.controllers.Course;

// import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.ModelAttribute;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.group2.swpgroup2.models.Category;
// import com.group2.swpgroup2.models.Student;
import com.group2.swpgroup2.models.Course;
import com.group2.swpgroup2.repositories.CategoryRepository;
import com.group2.swpgroup2.repositories.CourseRepository;
// import com.group2.swpgroup2.repositories.CourseStudentRepo;
// import com.group2.swpgroup2.repositories.StudentRepository;

@Controller
public class CourseController {
    @Autowired
    private CourseRepository courseRepo;

    @Autowired
    private CategoryRepository categoryRepo;

    // @Autowired
    // private StudentRepository studentRepo;

    // @Autowired
    // private CourseStudentRepo courseStudentRepo;

    @GetMapping("/courses")
    public String Course(HttpServletRequest request, HttpServletResponse response, Model model,
            @RequestParam(name = "category", required = false) Integer category,
            @RequestParam(name = "page", required = false) Integer page
    // @SessionAttribute("username") String username,
    // @SessionAttribute("courseCartCookie") String courseCartCookie
    ) {
        System.out.println(
                "===============================================================GetMapping: /courses================================================================================================");
        // 1. get all course
        // List<Course> courses = courseRepo.findAll();
        // model.addAttribute("courses", courses);
        // for (Course course : courses) {
        // System.out.println("courses: " + course.getCourseManager().getImgSrc());
        // }
        // List<Category> categories = categoryRepo.findAll();
        // model.addAttribute("categories", categories);
        // 2. get student by username
        // Student student = studentRepo.findByUsername(username);
        // System.out.println("student: " + student.getUsername());
        // model.addAttribute("student", student);

        List<Course> courses;
        List<Course> featuredCoursesEnroll = courseRepo.findFeaturedCourseEnroll();
        List<Course> featuredCoursesRating = courseRepo.findFeaturedCourseRating();
        List<Category> categories = categoryRepo.findAll();
        if (category != null && !category.equals(0)) {
            courses = courseRepo.findCourseByCategory(category);
        } else {
            courses = courseRepo.findCourseOrderByIdDesc();
            category = 0;
        }
        // pagination
        int pageSize = 12;
        if (page == null) {
            page = 1;
        }
        int totalPage = (int) Math.ceil((double) courses.size() / pageSize);
        int start = (page - 1) * pageSize;
        int end = start + pageSize;
        if (end > courses.size()) {
            end = courses.size();
        }
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("page", page);
        model.addAttribute("courses", courses.subList(start, end));
        model.addAttribute("featuredCoursesEnroll", featuredCoursesEnroll);
        model.addAttribute("featuredCoursesRating", featuredCoursesRating);

        model.addAttribute("categories", categories);
        model.addAttribute("category", category);
        return "Home_Course/courses";
    }

    @GetMapping("/removeCart")
    public String RemoveCart(Model model, @CookieValue(value = "username", defaultValue = "") String username,
            @CookieValue(value = "courseCartCookie", defaultValue = "") String courseCartCookie,
            HttpServletResponse response) {
        // delete cookie courseCart
        Cookie cookie = new Cookie("courseCartCookie", "");
        cookie.setMaxAge(0);
        cookie.setPath("/");
        response.addCookie(cookie);
        return "redirect:/courses";
    }

    @GetMapping("/course/{name}")
    public String CourseDetail(Model model, @PathVariable("name") String name) {
        // if course not found
        Course course = courseRepo.findByName(name);
        if (course == null) {
            return "redirect:/courses";
        }
        model.addAttribute("course", course);
        // category of this course
        Category category = categoryRepo.findById(course.getCategoryID());
        model.addAttribute("categoryOfCourse", category);
        // number of student enroll this course
        int numberOfStudentEnroll = courseRepo.getNumberOfStudentEnroll(course.getId());
        model.addAttribute("numberOfStudentEnroll", numberOfStudentEnroll);
        // list of related courses
        List<Course> relatedCourses;
        // list of course in same category (same category, not this course)
        List<Course> sameCateCoourse = courseRepo.findSameCategory(course.getCategoryID(), course.getId());
        // add course from list of same category to related course
        relatedCourses = sameCateCoourse;
        // list of course have same Manager (same Manager, not this course)
        List<Course> sameManagerCourse = courseRepo.findSameManager(course.getCourseManager().getId(), course.getId());
        // add course from list of same Manager to related course
        relatedCourses.addAll(sameManagerCourse);
        // list of course have or contain same name (same name, not this course)
        List<Course> sameNameCourse = courseRepo.findSameName(course.getCourseName(), course.getId());
        // add course from list of same name to related course
        relatedCourses.addAll(sameNameCourse);
        model.addAttribute("relatedCourses", relatedCourses);
        // print size of related course
        System.out.println("relatedCourses: " + relatedCourses.size());
        return "Home_Course/course";
    }

    @GetMapping(value = "/mycourses")
    public String getMyCourses(HttpServletRequest request, HttpServletResponse response, Model model) {
        System.out.println(
                "===============================================================GetMapping: /mycourses================================================================================================");
        // 1. get all course of student
        List<Course> myCourses = courseRepo.findAllCourseOfStudent("user");
        model.addAttribute("myCourses", myCourses);
        return "Home_Course/mycourses";
    }

    // search course
    @GetMapping("/searchCourse")
    public String searchCourse(HttpServletRequest request, HttpServletResponse response, Model model,
            @RequestParam(name = "searchCourse", required = false) String searchCourse) {
        System.out.println(
                "===============================================================GetMapping: /searchCourse================================================================================================");
        System.out.println("search: " + searchCourse);
        return "Home_Course/courses";
    }

}
