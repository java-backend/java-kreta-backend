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

       @GetMapping("/subject/edit/{id}")
        public String showUpdateForm (@PathVariable("id") long id, Model model){
           Subject subject = service.getSubjectById(id);
           model.addAttribute("subject", subject);
           return "/subjects/update-subject";
        }

        @PostMapping("/subject/update/{id}")
        public String updateSubject(@PathVariable("id") Long id, @Valid Subject subject, BindingResult result, Model model) {
            if (result.hasErrors()){
                subject.setId(id);
                return "/subjects/update-subject";
            }
            service.saveOrUpdate(subject);
            return "redirect:/subjects/index/";
        }
        @GetMapping("/subject/delete/{id}")
        public String deleteUser (@PathVariable("id") long id, Model model) {
            Subject subject = service.getSubjectById(id);
            service.delete(id);
            return "redirect:/subjects/index";


        }

        @GetMapping ("/signup")
        public ModelAndView showSingUpForm(){
            Subject newSubject=new Subject();
            ModelAndView mav=new ModelAndView();
            mav.setViewName("/subjects/add-subject");
            mav.addObject("subject",newSubject);

            return mav;
        }



        @PostMapping("/subject/add-subject")
            public String addNewSubject(@Valid Subject subject, BindingResult result, Model model) {
                if (result.hasErrors()) {
                    return "/subject/add-subject";
                }

                service.saveOrUpdate(subject);
                return "redirect:/subjects/index";
    }



}
