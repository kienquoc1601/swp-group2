package com.group2.swpgroup2.controllers.Blog;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.group2.swpgroup2.models.Blog;
import com.group2.swpgroup2.repositories.BlogRepository;
import org.springframework.web.bind.annotation.GetMapping;


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
    @GetMapping(value="/blog/add")
    public String addBlog(Model model) {
        return "Blog/blogadd";
    }
    @PostMapping("/blog/add")
    public String addBlog(@ModelAttribute("blog") Blog blog) {
        //new blog and save it to database
        Blog newBlog = new Blog();
        //title, blog_image, blog_description, poster_uname, blog_content, category, date
        newBlog.setTitle(blog.getTitle());
        newBlog.setBlog_image(blog.getBlog_image());
        newBlog.setBlog_description(blog.getBlog_description());
        newBlog.setPoster_uname(blog.getPoster_uname());
        newBlog.setBlog_content(blog.getBlog_content());
        newBlog.setCategory(blog.getCategory());
        //date = today
        newBlog.setDate(new Date(System.currentTimeMillis()));
        blogRepo.save(newBlog);
        return "redirect:/blog";
    }

}
