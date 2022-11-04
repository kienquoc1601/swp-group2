package com.group2.swpgroup2.controllers.Module;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.group2.swpgroup2.models.Module;
import com.group2.swpgroup2.repositories.ModuleRepository;



@Controller
public class ModuleController {
    @Autowired
    ModuleRepository moduleRepo;

    @GetMapping("/module")
    public String Module(Model model){
        return "Module/Module";
    }

    @GetMapping("/module/cid={id}")
    public String Module(Model model , @PathVariable String id){
        //List<Integer> ids = Arrays.asList(Integer.parseInt(id));
        List<Module> mList = moduleRepo.findByChapter(Integer.parseInt(id));
        
        model.addAttribute("mList", mList);
        return "Module/ModuleVideo";
    }
}