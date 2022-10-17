package org.example.kreta.controller;

import org.example.kreta.model.SchoolClass;
import org.example.kreta.model.Subject;
import org.example.kreta.service.SchoolClassesService;
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
public class SchoolClassesController {

    @Autowired
    SchoolClassesService service;

    @GetMapping("/schoolClass/index")
    public ModelAndView showSchoolClassList()
    {
        List<SchoolClass> schoolClasses = service.getAllSchoolClass();
        ModelAndView mav=new ModelAndView("schoolClasses/index");
        mav.addObject("schoolClasses",schoolClasses);
        mav.setViewName("th/schoolClasses/index");
        return mav;
    }

    @GetMapping("/schoolClass/edit/{id}")
    public String showUpdateForm (@PathVariable("id") long id, Model model){
        SchoolClass schoolClass = service.getSchoolClassByID(id);
        model.addAttribute("schoolClass", schoolClass);
        return "/schoolClasses/update-schoolClass";
    }

    @PostMapping("/schoolClass/update/{id}")
    public String updateSchoolClass(@PathVariable("id") Long id, @Valid SchoolClass schoolClass, BindingResult result, Model model) {
        if (result.hasErrors()){
            schoolClass.setId(id);
            return "/schoolClasses/update-schoolClass";
        }
        service.saveOrUpdate(schoolClass);
        return "redirect:/schoolClasses/index/";
    }

    @GetMapping("/schoolClass/delete/{id}")
    public String deleteUser (@PathVariable("id") long id, Model model) {
        SchoolClass schoolClass = service.getSchoolClassByID(id);
        service.delete(id);
        return "redirect:/schoolClasses/index";


    }
    @GetMapping ("/schoolClass/signup")
    public ModelAndView showSingUpForm(){
        SchoolClass newSchoolClass=new SchoolClass();
        ModelAndView mav=new ModelAndView();
        mav.setViewName("/th/schoolClasses/add-schoolClass");
        mav.addObject("schoolClass",newSchoolClass);

        return mav;
    }

    @PostMapping("/schoolClass/add-schoolClass")
    public String addNewSchoolClass(@Valid SchoolClass schoolClass, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "th/schoolClasses/index";
        }

        service.saveOrUpdate(schoolClass);
        return "th/schoolClasses/index";
    }
}
