package org.example.kreta.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.kreta.model.Subject;
import org.example.kreta.model.dto.QueryStringParameterDto;
import org.example.kreta.model.generic.PagedList;
import org.example.kreta.model.paging.PagingResult;
import org.example.kreta.service.SubjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
        Subject subject=subjectsService.getSubjectById(subjectid);
        return subject;
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


    @GetMapping("/subject/parameters")
    public ResponseEntity<PagedList<Subject>> getAllSubjectsParameters(@SpringQueryMap QueryStringParameterDto queryStringParameterDto) throws JsonProcessingException {
        PagedList<Subject> subjects= new PagedList<>();
        if (queryStringParameterDto.isPaging() && queryStringParameterDto.isSorting())
            subjects= subjectsService.getAllSubjects(queryStringParameterDto.getCurrentPage(),
                    queryStringParameterDto.getPageSize(),
                    queryStringParameterDto.getFilter());
        else if (queryStringParameterDto.isSorting()) {
            List<Subject> listSubject = new ArrayList<Subject>();
            subjects.setList(listSubject);
        }
        else if (queryStringParameterDto.isPaging()) {
            subjects = subjectsService.getAllSubjects(
                    queryStringParameterDto.getCurrentPage(),
                    queryStringParameterDto.getPageSize(),
                    "");
        }
        HttpHeaders headers=new HttpHeaders();
        if (queryStringParameterDto.isPaging()) {
            PagingResult result=subjects.getPagingResult();
            String serialized = new ObjectMapper().writeValueAsString(result);
            headers.add("X-Pagination",serialized);
        }

        return  new ResponseEntity<PagedList<Subject>>(subjects,headers, HttpStatus.OK);
    }

}
