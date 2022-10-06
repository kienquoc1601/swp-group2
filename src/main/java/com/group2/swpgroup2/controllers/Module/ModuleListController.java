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
public class ModuleListController {

    @Autowired
    ModuleRepository moduleRepo;

    @GetMapping("/modulelist")
    public String ModuleList(Model model){
        List<Module> mList = moduleRepo.findAll();
        model.addAttribute("mList", mList);
        return "Module/ModuleList";
    }

    @GetMapping("/modulelist?cid={id}")
    public String ModuleListByID(Model model , @PathVariable String id){
        List<Integer> ids = Arrays.asList(Integer.parseInt(id));
        List<Module> mList = moduleRepo.findAllById(ids);
        model.addAttribute("mList", mList);
        return "Module/ModuleList";
    }
}
