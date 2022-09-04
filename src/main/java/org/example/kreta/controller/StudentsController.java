package org.example.kreta.controller;

import org.example.kreta.model.Student;
import org.example.kreta.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class StudentsController {

    @Autowired
    StudentsService service;

    @GetMapping("/students/index")
    public String showStudentsList(Model model)
    {
        List<Student> students = service.getAllStudents();
        model.addAttribute("students",students);
        return "students";
    }
}
