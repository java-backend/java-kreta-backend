package org.example.kreta.controller;

import org.example.kreta.model.Student;
import org.example.kreta.model.Subject;
import org.example.kreta.repo.exceptions.RecordNotFoundException;
import org.example.kreta.service.StudentsService;
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
public class StudentsController {

    @Autowired
    StudentsService service;

    @GetMapping("/student/index")
    public ModelAndView showStudentsList()
    {
        List<Student> students = service.getAllStudents();
        ModelAndView mav=new ModelAndView("th/students/index");
        mav.addObject("students",students);

        return mav;
    }

    @GetMapping("/student/edit/{id}")
    public String showUpdateForm (@PathVariable("id") long id, Model model) {
        try {
            Student student = service.getStudentById(id);
            model.addAttribute("student", student);
        } catch (RecordNotFoundException exception)
        {
            return "redirect: /students/index";
        }
        return "/students/update-student";
    }

    @PostMapping("/student/update/{id}")
    public String updateStudent(@PathVariable("id") Long id, @Valid Student student, BindingResult result, Model model) {
        if (result.hasErrors()){
            student.setId(id);
            return "/students/update-student";
        }
        try {


            service.saveOrUpdate(student);
        }catch (RecordNotFoundException exception){
            return "redirect: /students/index";
        }
        return "redirect:/students/index/";
    }

    @GetMapping("/student/delete/{id}")
    public String deleteStudent (@PathVariable("id") long id, Model model) {
        try {


            Student student = service.getStudentById(id);
            service.delete(id);

        }catch (RecordNotFoundException exception){
           return "redirect:/students/index/";
        }
        return "redirect:/students/index";
    }

    @GetMapping ("/student/signup")
    public ModelAndView showSingUpForm(){
        Student nevStudent=new Student();
        ModelAndView mav=new ModelAndView();
        mav.setViewName("/th/students/add-student");
        mav.addObject("student",nevStudent);
        return mav;
    }

    @PostMapping("/student/add-student")
    public String addNewStudent(@Valid Student student, BindingResult result, Model model)  {
       /* ha jó a dátum akkor mehet
        if (result.hasErrors()) {
            return "th/students/add-student";
        }*/
        try {
            service.saveOrUpdate(student);
        }catch (RecordNotFoundException exception){
            return "redirect:/student/index/";
        }
        return "redirect:/student/index";
    }
}
