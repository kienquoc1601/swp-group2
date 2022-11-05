package com.group2.swpgroup2.controllers.Question;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.group2.swpgroup2.repositories.QuestionRepository;



@Controller
public class QuestionController {
    @Autowired
    QuestionRepository qRepo;
}
