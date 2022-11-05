package com.group2.swpgroup2.controllers.Question;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.group2.swpgroup2.models.Question;
import com.group2.swpgroup2.repositories.QuestionRepository;



@Controller
public class QuestionController {
    @Autowired
    QuestionRepository qRepo;

    @GetMapping("/qlist/id={id}")
    public String QList(Model model, @PathVariable String id){
        List<Question> lq = qRepo.findByCourse(Integer.parseInt(id));
        System.out.println(lq.size());
        model.addAttribute("lq", lq);
        return "Forum/PostPage";
    }
    @GetMapping("/q/id={id}")
    public String Question(Model model, @PathVariable String id){
        List<Question> lq = qRepo.findByCourse(Integer.parseInt(id));
        model.addAttribute("lq", lq);
        return "Forum/PostPage";
    }
}
