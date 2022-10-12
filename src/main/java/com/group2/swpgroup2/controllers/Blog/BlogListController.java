package com.group2.swpgroup2.controllers.Blog;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.group2.swpgroup2.models.Blog;
import com.group2.swpgroup2.models.Category;
import com.group2.swpgroup2.repositories.BlogRepository;
import com.group2.swpgroup2.repositories.CategoryRepository;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogListController {
    @Autowired
    private BlogRepository blogRepo;
    @Autowired
    private CategoryRepository categoryRepo;

    @GetMapping("/blog")
    public String BlogList(Model model, @RequestParam(name = "category", required = false) String category,
            @RequestParam(name = "page", required = false) Integer page) {
        List<Blog> blogs;
        if (category != null && !category.equals("all")) {
            blogs = blogRepo.findByCategoryOrderByDateDesc(category);
        } else {
            blogs = blogRepo.findAllByOrderByDateDesc();
            category = "all";
        }
        model.addAttribute("blogs", blogs);

        // pagination
        int pageSize = 5;
        if (page == null) {
            page = 1;
        }
        int totalPage = (int) Math.ceil((double) blogs.size() / pageSize);
        int start = (page - 1) * pageSize;
        int end = start + pageSize;
        if (end > blogs.size()) {
            end = blogs.size();
        }
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("page", page);
        model.addAttribute("blogs", blogs.subList(start, end));

        List<Blog> trendingBlogs = blogRepo.findTop10ByOrderByRatingDesc();
        model.addAttribute("trendingBlogs", trendingBlogs);

        List<Blog> categoryBlogs = blogRepo.findTop5ByOrderByCategoryDesc();
        model.addAttribute("categoryBlogs", categoryBlogs);

        List<Category> categories = categoryRepo.findAll();
        model.addAttribute("categories", categories);
        model.addAttribute("category", category);

        return "Blog/blogslist";
    }

    @GetMapping("/blog/detail/{id}")
    public String BlogDetail(Model model, @PathVariable("id") int id) {
        // if blog_id is not found, redirect to blog list
        if (!blogRepo.existsById(id)) {
            return "redirect:/blog";
        }
        Blog blog = blogRepo.findById(id);
        model.addAttribute("blog", blog);

        List<Blog> trendingBlogs = blogRepo.findTop10ByOrderByRatingDesc();
        model.addAttribute("trendingBlogs", trendingBlogs);

        List<Blog> categoryBlogs = blogRepo.findTop5ByOrderByCategoryDesc();
        model.addAttribute("categoryBlogs", categoryBlogs);

        List<Category> categories = categoryRepo.findAll();
        model.addAttribute("categories", categories);
        return "Blog/blogdetail";
    }

    @GetMapping(value = "/blog/add")
    public String addBlog(Model model) {
        List<Category> categories = categoryRepo.findAll();
        model.addAttribute("categories", categories);
        return "Blog/blogadd";
    }

    @PostMapping("/blog/add")
    public String addBlog(@ModelAttribute("blog") Blog blog) {
        // new blog and save it to database
        Blog newBlog = new Blog();
        // title, blog_image, blog_description, poster_uname, blog_content, category,
        // date
        newBlog.setTitle(blog.getTitle());
        newBlog.setBlog_image(blog.getBlog_image());
        newBlog.setBlog_description(blog.getBlog_description());
        newBlog.setPoster_uname(blog.getPoster_uname());
        newBlog.setBlog_content(blog.getBlog_content());
        newBlog.setCategory(blog.getCategory());
        //set status
        newBlog.setStatus("public");
        // date = today
        newBlog.setDate(new Date(System.currentTimeMillis()));
        blogRepo.save(newBlog);
        // lấy blog vừa thêm vào để lấy id
        Blog blogAdded = blogRepo.findByTitleAndDateAndStatus(newBlog.getTitle(), newBlog.getDate(), newBlog.getStatus());
        return "redirect:/blog/detail?blog_id=" + blogAdded.getBlog_id();
    }
}
