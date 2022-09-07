package org.example.kreta.controller;

import org.example.kreta.model.SchoolClass;
import org.example.kreta.model.Subject;
import org.example.kreta.service.SchoolClassesService;
import org.example.kreta.service.SubjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class SchoolClassesController {

    @Autowired
    SchoolClassesService service;

    @GetMapping("/schoolClasses/index")
    public ModelAndView showSchoolClassList()
    {
        List<SchoolClass> schoolClasses = service.getAllSchoolClass();
        ModelAndView mav=new ModelAndView("schoolClasses/index");
        mav.addObject("schoolClasses",schoolClasses);

        return mav;
    }
}
