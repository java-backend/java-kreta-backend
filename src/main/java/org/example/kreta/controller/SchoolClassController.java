package org.example.kreta.controller;

import org.example.kreta.model.SchoolClass;
import org.example.kreta.service.SchoolClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class SchoolClassController {
    @Autowired
    SchoolClassService schoolClassService;

    @GetMapping(value="/schoolClass",name="List of all schoolClasses")
    private List<SchoolClass> getAllSchoolClasses() {
        return schoolClassService.getAllSchoolClass();
    }

    @GetMapping(value = "/schoolClass/{schoolClassid}", name = "Get schoolClass by id")
    private SchoolClass getSchoolClass(@PathVariable("schoolClassid") Long schoolClassid) {
        return schoolClassService.getSchoolClassByID(schoolClassid);
    }

    @DeleteMapping(value="/schoolClass/{schoolClassid}",name = "Delete schoolClass")
    private void deleteSchoolClass(@PathVariable("schoolClassid") Long schoolClassid) {
        schoolClassService.delete(schoolClassid);
    }

    @PostMapping(value = "/schoolClass",name="Save new schoolClass")
    private Long saveSchoolClass(@RequestBody SchoolClass schoolClass) {
        schoolClassService.saveOrUpdate(schoolClass);
        return schoolClass.getId();
    }

    @PutMapping(value = "/schoolClass",name="Update schoolClass")
    private SchoolClass update(@RequestBody SchoolClass schoolClass) {
        schoolClassService.saveOrUpdate(schoolClass);
        return schoolClass;
    }
}
