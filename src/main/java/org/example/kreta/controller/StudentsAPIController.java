package org.example.kreta.controller;

import org.example.kreta.model.Student;
import org.example.kreta.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentsAPIController {

    @Autowired
    StudentsService studentsService;

    @GetMapping(value="/api/student",name="List of all students")
    private List<Student> getAllStudents() {
        return studentsService.getAllStudents();
    }

    @GetMapping(value = "/api/student/{studentid}", name = "Get student by id")
    private Student getStudent(@PathVariable("studentid") Long studentid) {
        return studentsService.getStudentById(studentid);
    }

    @DeleteMapping(value="/api/student/{studentid}",name = "Delete student")
    private void deleteStudent(@PathVariable("studentid") Long studentid) {
        studentsService.delete(studentid);
    }


    @PostMapping(value = "/api/student",name="Save new student")
    private Long saveStudent(@RequestBody Student student) {
        studentsService.saveOrUpdate(student);
        return student.getId();
    }

    @PutMapping(value = "/api/student",name="Update student")
    private Student update(@RequestBody Student student) {
        studentsService.saveOrUpdate(student);
        return student;
    }
}
