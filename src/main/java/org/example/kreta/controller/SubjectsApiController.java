package org.example.kreta.controller;

import org.example.kreta.model.Subject;
import org.example.kreta.service.SubjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

// https://www.javatpoint.com/spring-boot-crud-operations
@RestController
public class SubjectsApiController {
    @Autowired
    SubjectsService subjectsService;
    @GetMapping(value="/subject",name="List of all subjects")

    private List<Subject> getAllSubjects(){
        return subjectsService.getAllSubjects();
    }

    @GetMapping(value = "/subject/{subjectid}", name = "Get subject by id")
    private Subject getsubject(@PathVariable("subjectid") Long subjectid) {
        return subjectsService.getSubjectById(subjectid);
    }

    @DeleteMapping(value="/subject/{subjectid}",name = "Delete subject")
    private void deleteSubject(@PathVariable("subjectid") Long subjectid) {
        subjectsService.delete(subjectid);
    }

    @PostMapping(value = "/subject",name="Save new subject")
    private Long saveSubject(@RequestBody Subject subject) {
        subjectsService.saveOrUpdate(subject);
        return subject.getId();
    }

    @PutMapping(value = "/subject",name="Update subject")
    private Subject update(@RequestBody Subject subject) {
       subjectsService.saveOrUpdate(subject);
        return subject;
    }

}
