package org.example.kreta.controller.FTL;

import org.example.kreta.model.Subject;
import org.example.kreta.service.SubjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/ftl")
public class SubjectFTLController {
    @Autowired
    SubjectsService service;
    @GetMapping(value={"subject","subject/","subject/index"},name = "Subject page")
    public String index(Model model) {
        List<Subject> subjects=service.getAllSubjects();
        model.addAttribute("numberOfSubject",subjects.size());
        return "subjects/index";
    }
}
