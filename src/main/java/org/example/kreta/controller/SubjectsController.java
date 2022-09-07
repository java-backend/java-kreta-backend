package org.example.kreta.controller;

import org.example.kreta.model.Subject;
import org.example.kreta.service.SubjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class SubjectsController {

        @Autowired
        SubjectsService service;

        @GetMapping("/subjects/index")
        public ModelAndView showSubjectList()
        {
            List<Subject> subjects = service.getAllSubjects();
            ModelAndView mav=new ModelAndView("subjects/index");
            mav.addObject("subjects",subjects);

            return mav;
        }
}
