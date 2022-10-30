package com.group2.swpgroup2.controllers.Admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.group2.swpgroup2.models.Category;
import com.group2.swpgroup2.models.Course;
import com.group2.swpgroup2.models.Manager;
import com.group2.swpgroup2.repositories.BlogRepository;
import com.group2.swpgroup2.repositories.CategoryRepository;
import com.group2.swpgroup2.repositories.CourseRepository;
import com.group2.swpgroup2.repositories.ManagerRepository;

@Controller
public class AdminController {
    @Autowired
    private BlogRepository blogRepo;

    @Autowired
    private CourseRepository courseRepo;

    @Autowired
    private ManagerRepository managerRepo;

    @Autowired
    private CategoryRepository categoryRepo;

    // admin dashboard
    @GetMapping("/admin")
    public String Admin(Model model, HttpServletRequest request) {
        model.addAttribute("currentUrl", request.getRequestURI().toString());
        return "Admin/index";
    }

    // admin blog
    @GetMapping("/admin/blogs")
    public String AdminBlog(Model model, HttpServletRequest request) {
        // model current url to active menu
        model.addAttribute("currentUrl", request.getRequestURI().toString());
        // get all blog
        model.addAttribute("blogs", blogRepo.findAll());
        return "Admin/blog";
    }

    // get mapping to delete a blog by id and return message successfully, don't
    // need get current url
    @GetMapping("/admin/blog/delete/{id}")
    public String AdminBlogDelete(Model model, @PathVariable("id") int id) {
        // delete blog by id
        blogRepo.deleteById(id);
        // return message successfully
        model.addAttribute("message", "Delete successfully");
        // redirect to admin blog page
        return "redirect:/admin/blogs";
    }

    // admin course
    @GetMapping("/admin/courses")
    public String AdminCourse(Model model, HttpServletRequest request) {
        System.out.println("========================Admin course========================");

        // model current url to active menu
        model.addAttribute("currentUrl", request.getRequestURI().toString());

        // get all course
        List<Course> courses = courseRepo.findAllCourseWithNumberOfStudentEnroll();
        model.addAttribute("courses", courses);

        //get all manager
        List<Manager> managers = managerRepo.getAllManager();
        model.addAttribute("managers", managers);

        //get all category
        List<Category> categories = categoryRepo.findAll();
        model.addAttribute("categories", categories);

        return "Admin/course";
    }

    // get mapping to delete a course by id and return message successfully, don't
    // need get current url
    @GetMapping("/admin/course/delete/{id}")
    public String AdminCourseDelete(Model model, @PathVariable("id") int id) {
        // delete course by id
        courseRepo.deleteById(id);
        // return message successfully
        model.addAttribute("message", "Delete successfully");
        // redirect to admin course page
        return "redirect:/admin/courses";
    }

    //post mapping to update a course
    @PostMapping("/admin/course/update")
    public String AdminCourseUpdate(@ModelAttribute("CourseCategoryManager") CourseCategoryManager course) {
        //update course and redirect to admin course page if successfully, else return error message
        if(courseRepo.updateCourse(course.getCategoryId(),course.getCourseName(), course.getCourseManagerId(), course.getCourseDescription(), 
        course.getCourseImage(), course.getCourseRating(), course.getCoursePrice(), course.getCourseId()) == 1) {
            return "redirect:/admin/courses";
        } else {
            return "error";
        }
    }

    //post mapping to add a course
    @PostMapping("/admin/course/add")
    public String AdminCourseAdd(@ModelAttribute("CourseCategoryManager") CourseCategoryManager course) {
        //add course and redirect to admin course page if successfully, else return error message
        if(courseRepo.addCourse(course.getCategoryId(),course.getCourseName(), course.getCourseManagerId(), course.getCourseDescription(), 
        course.getCourseImage(), course.getCourseRating(), course.getCoursePrice()) == 1) {
            return "redirect:/admin/courses";
        } else {
            return "error";
        }
    }

    //tạo một  class để chứa các thuộc tính chung của course và category và manager để dùng chung cho việc thêm mới
    public class CourseCategoryManager {
        // gồm các thuộc tính chung: courseId, categoryId, courseName, courseManagerId, description, imgSrc, rating, price, numOfStudents
        private int courseId;
        private int categoryId;
        private String courseName;
        private int courseManagerId;
        private String courseDescription;
        private String courseImage;
        private float courseRating;
        private float coursePrice;
        private int numOfStudents;

        //getters and setters
        public int getCourseId() {
            return courseId;
        }

        public void setCourseId(int courseId) {
            this.courseId = courseId;
        }

        public int getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(int categoryId) {
            this.categoryId = categoryId;
        }

        public String getCourseName() {
            return courseName;
        }

        public void setCourseName(String courseName) {
            this.courseName = courseName;
        }

        public int getCourseManagerId() {
            return courseManagerId;
        }

        public void setCourseManagerId(int courseManagerId) {
            this.courseManagerId = courseManagerId;
        }

        public String getCourseDescription() {
            return courseDescription;
        }

        public void setCourseDescription(String courseDescription) {
            this.courseDescription = courseDescription;
        }

        public String getCourseImage() {
            return courseImage;
        }

        public void setCourseImage(String imgSrc) {
            this.courseImage = imgSrc;
        }

        public float getCourseRating() {
            return courseRating;
        }

        public void setCourseRating(float courseRating) {
            this.courseRating = courseRating;
        }

        public float getCoursePrice() {
            return coursePrice;
        }

        public void setCoursePrice(float price) {
            this.coursePrice = price;
        }

        public int getNumOfStudents() {
            return numOfStudents;
        }

        public void setNumOfStudents(int numOfStudents) {
            this.numOfStudents = numOfStudents;
        }

    }
}
