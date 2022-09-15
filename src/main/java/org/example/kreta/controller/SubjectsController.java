package org.example.kreta.controller;

import org.example.kreta.model.Subject;
import org.example.kreta.service.SubjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
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

       @GetMapping("/edit/{id}")
        public String showUpdateForm (@PathVariable("id") long id, Model model){
            Subject subject = service.getSubjectById(id);
           model.addAttribute("subject", subject);
           return "update-subject";
        }

        @PostMapping("/update/{id}")
        public String updateSubject(@PathVariable("id") long id, @Valid Subject subject, BindingResult result, Model model) {
            if (result.hasErrors()){
                subject.setId(id);
                return "update-subject";
            }
            service.saveOrUpdate(subject);
            return "redirect:/index/";
        }
     /*   @GetMapping("/delete/{id}")
        public String deleteUser (@PathVariable("id") long id, Model model) {
            Subject subject = service.getSubjectById(id);
            ser;
        }*/


       /* @PostMapping ("/adduser")
        public ModelAndView showSubjectList(){
            List<Subject> subjects = service.getAllSubjects();
            ModelAndView mav=new ModelAndView("subjects/index");
        }*/



}
