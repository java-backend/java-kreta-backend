package org.example.kreta.controller.FTL;

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
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/ftl")
public class SchoolClassFTLController {
    @Autowired
    SchoolClassesService service;

    @GetMapping(value={"schoolClass","schoolClass/","schoolClass/index"},name = "SchoolClass page")
    public String index(Model model) {
        List<SchoolClass> schoolClasses=service.getAllSchoolClass();
        model.addAttribute("numberOfSchoolClass",schoolClasses.size());
        model.addAttribute("schoolClasses" , schoolClasses);
        return "schoolClasses/index";
    }

    @GetMapping("/schoolClass/edit/{id}")
    public String showUpdateForm (@PathVariable("id") long id, Model model){
        SchoolClass schoolClass = service.getSchoolClassByID(id);
        model.addAttribute("schoolClass", schoolClass);
        model.addAttribute("add",false);
        return "schoolClasses/add-schoolClass";
    }
}
