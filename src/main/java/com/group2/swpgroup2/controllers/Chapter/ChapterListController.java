package com.group2.swpgroup2.controllers.Chapter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.group2.swpgroup2.models.Chapter;
import com.group2.swpgroup2.repositories.ChapterRepository;

@Controller
public class ChapterListController {
    @Autowired
    ChapterRepository chapterRepo;

    @GetMapping("/chapterlist")
    public String ChapterList(Model model){
        List<Chapter> cList = chapterRepo.findAll();
        model.addAttribute("cList", cList);
        return "Chapter/ChapterList";
    }
    
}