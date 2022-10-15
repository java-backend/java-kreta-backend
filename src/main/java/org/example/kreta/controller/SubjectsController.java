package org.example.kreta.controller;

import org.example.kreta.model.Student;
import org.example.kreta.model.Subject;
import org.example.kreta.service.SubjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class SubjectsController {

        @Autowired
        SubjectsService subjectsService;

        @GetMapping("/subjects/index")
        public ModelAndView showSubjectList()
        {
            List<Subject> subjects = subjectsService.getAllSubjects();
            ModelAndView mav=new ModelAndView("subjects/index");
            mav.addObject("subjects",subjects);

            return mav;
        }

       @GetMapping("/subject/edit/{id}")
        public String showUpdateForm (@PathVariable("id") long id, Model model){
           Subject subject = subjectsService.getSubjectById(id);
           model.addAttribute("subject", subject);
           return "/subjects/update-subject";
        }

        @PostMapping("/subject/update/{id}")
        public String updateSubject(@PathVariable("id") Long id, @Valid Subject subject, BindingResult result, Model model) {
            if (result.hasErrors()){
                subject.setId(id);
                return "/subjects/update-subject";
            }
            subjectsService.saveOrUpdate(subject);
            return "redirect:/subjects/index/";
        }
        @GetMapping("/subject/delete/{id}")
        public String deleteUser (@PathVariable("id") long id, Model model) {
            Subject subject = subjectsService.getSubjectById(id);
            subjectsService.delete(id);
            return "redirect:/subjects/index";
        }

        @GetMapping ("/subject/signup")
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

                subjectsService.saveOrUpdate(subject);
                return "redirect:/subjects/index";
    }


  /*  @RequestMapping(value = "/listSubjects", method = RequestMethod.GET)
    public String listSubjects(
            Model model,
            @RequestParam("page")Optional<Integer> page,
            @RequestParam("size")Optional<Integer> size {
                int currentPage = page.orElse(1);
                int pageSize = size.orElse(5);
               Page<Subject> studentPage = subjectsService.getAllSubjects(PageRequest.of(currentPage-1,pageSize));
               / model
                }
            )*/






}
