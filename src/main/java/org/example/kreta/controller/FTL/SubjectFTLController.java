package org.example.kreta.controller.FTL;

import org.example.kreta.model.Subject;
import org.example.kreta.service.SubjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
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
        model.addAttribute("subjects" , subjects);
        return "subjects/index";
    }

    @GetMapping("/subject/edit/{id}")
    public String showUpdateForm (@PathVariable("id") long id, Model model){
        Subject subject = service.getSubjectById(id);
        model.addAttribute("subject", subject);
        model.addAttribute("add",false);
        return "subjects/add-subject";
    }

    @PostMapping("/subject/update/{id}")
    public String updateSubject(@PathVariable("id") Long id, @Valid Subject subject, BindingResult result, Model model) {
        if (result.hasErrors()){
            subject.setId(id);
            return "subjects/add-subject";
        }
        service.saveOrUpdate(subject);
        return "redirect:/ftl/subject/index/";
    }

    @GetMapping("/subject/delete/{id}")
    public String deleteUser (@PathVariable("id") long id, Model model) {
        Subject subject = service.getSubjectById(id);
        service.delete(id);
        return "redirect:/ftl/subject/index";
    }

    @GetMapping ("/subject/signup")
    public String showSingUpForm(Model model){
        Subject newSubject=new Subject();
        model.addAttribute("subject", newSubject);
        model.addAttribute("add", true);
        return "subjects/add-subject";
    }
    @PostMapping ("/subject/add-subject")
    public String addNewSubject(@Valid Subject subject, BindingResult result, Model model){
        service.saveOrUpdate(subject);
        return "redirect:/ftl/subject/index";
    }

    @GetMapping ("subject/view/{id}")
    public String viewSubject(@PathVariable("id") long id, Model model){
        Subject subject = service.getSubjectById(id);
        model.addAttribute("subject", subject);
        return "subjects/view-subject";
    }
}
