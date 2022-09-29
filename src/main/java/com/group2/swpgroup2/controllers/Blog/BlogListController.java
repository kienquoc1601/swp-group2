package com.group2.swpgroup2.controllers.Blog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogListController {
    @GetMapping("/blog")
    public String BlogList(){
        return "Blog/blogslist";
    }
    @GetMapping("/blog/detail")
    public String BlogDetail(){
        return "Blog/blogdetail";
    }
}
