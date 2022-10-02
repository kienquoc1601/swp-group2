package com.group2.swpgroup2.controllers.Blog;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.group2.swpgroup2.models.Blog;
import com.group2.swpgroup2.repositories.BlogRepository;

@Controller
public class BlogListController {
    @Autowired
    private BlogRepository blogRepo;
    @RequestMapping("/blog")
    public String BlogList(Model model) {
        List<Blog> blogs = blogRepo.findAll();
        model.addAttribute("blogs", blogs);
        return "Blog/blogslist";
    }
    @RequestMapping(value="/blog/detail", method = RequestMethod.GET)
    public String BlogDetail(Model model, @RequestParam("blog_id") int blog_id) {
        Blog blog = blogRepo.findById(blog_id);
        model.addAttribute("blog", blog);
        return "Blog/blogdetail";
    }

    

    //get data from form and save blog to database
    // @RequestMapping(value="/blog/add", method = RequestMethod.GET)
    // public String BlogAdd(Model model) {

    //     return "Blog/blogadd";
    // }

    // @RequestMapping(value="/blog/add", method = RequestMethod.GET)
    // public String BlogAdd(Model model) {

    //     return "Blog/blogadd";
    // }
    // public String BlogAdd(Model model, @RequestParam("title") String title, @RequestParam("blog_image") String blog_image, @RequestParam("blog_description") String blog_description, @RequestParam("poster_uname") String poster_uname, @RequestParam("blog_content") String blog_content, @RequestParam("category") String category, @RequestParam("rating") float rating, @RequestParam("date") Date date) {
    //     Blog blog = new Blog();
    //     blog.setTitle(title);
    //     blog.setBlog_image(blog_image);
    //     blog.setBlog_description(blog_description);
    //     blog.setPoster_uname(poster_uname);
    //     blog.setBlog_content(blog_content);
    //     blog.setCategory(category);
    //     blog.setRating(rating);
    //     blog.setDate(date);
    //     blogRepo.save(blog);
    //     return "redirect:/blog";
    // }

    //add blog
    

}
