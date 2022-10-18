package org.example.kreta.controller.FTL;

import org.example.kreta.model.Subject;
import org.example.kreta.service.SubjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class SubjectFTLController {
    @Autowired
    SubjectsService service;

    @GetMapping("/ftl/subject/index")
    public ModelAndView showSubjectList()
    {
        //List<Subject> subjects = service.getAllSubjects();
        ModelAndView mav=new ModelAndView("subjects/index.ftl");
        //mav.addObject("subjects",subjects);

        return mav;
    }
}
