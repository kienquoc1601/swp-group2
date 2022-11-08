package com.group2.swpgroup2.controllers.Question;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.group2.swpgroup2.models.Answer;
import com.group2.swpgroup2.models.Mentor;
import com.group2.swpgroup2.models.Question;
import com.group2.swpgroup2.models.Student;
import com.group2.swpgroup2.repositories.AnswerRepository;
import com.group2.swpgroup2.repositories.MentorRepository;
import com.group2.swpgroup2.repositories.QuestionRepository;
import com.group2.swpgroup2.repositories.StudentRepository;



@Controller
public class QuestionController {
    @Autowired
    QuestionRepository qRepo;
    @Autowired
    AnswerRepository aRepo;
    @Autowired
    StudentRepository sRepo;
    @Autowired
    MentorRepository mRepo;

    @GetMapping("/qlist/id={id}")
    public String QList(Model model, @PathVariable String id){
        List<Question> lq = qRepo.findByCourse(Integer.parseInt(id));
        System.out.println(lq.size());
        model.addAttribute("lq", lq);
        return "Forum/PostPage";
    }
    @GetMapping("/q/id={id}")
    public String Question(Model model, @PathVariable String id){
        Question q = qRepo.findByID(Integer.parseInt(id));
        Student s = q.getStudent();
        List<Answer> aList = aRepo.findByQuestion(Integer.parseInt(id));
        System.out.println(q.qName);
        System.out.println(s.getUsername());
        System.out.println(aList.size());
        model.addAttribute("q", q);
        model.addAttribute("s", s);
        model.addAttribute("aList", aList);

        return "Forum/ForumDetail";

    }
    @RequestMapping("/q")
    public String newAns(
        @RequestParam(value = "comment", required = false) String comment,
        @RequestParam(value = "qid", required = false) String qid,
        Model model)
        {
            String current = SecurityContextHolder.getContext().getAuthentication().getName();
            LocalDate localDate = LocalDate.now();
            Mentor m = mRepo.findByUname(current);
            Answer a = Answer.builder().questionID(Integer.parseInt(qid)).mentor(m).answer(comment).build();
            aRepo.save(a);
            return "redirect:/q/id="+ qid;
        }
}
