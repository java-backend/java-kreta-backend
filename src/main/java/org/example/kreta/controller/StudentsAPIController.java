package org.example.kreta.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.example.kreta.model.Student;
import org.example.kreta.model.dto.QueryStringParameterDto;
import org.example.kreta.model.generic.PagedList;
import org.example.kreta.model.paging.PagingResult;
import org.example.kreta.model.paging.PagingResultSerializer;
import org.example.kreta.repo.exceptions.RecordNotFoundException;
import org.example.kreta.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.cloud.openfeign.SpringQueryMap;

import java.util.ArrayList;
import java.util.List;

// Maven search
@RestController
@RequestMapping("/api")
public class StudentsAPIController {

    @Autowired
    StudentsService studentsService;

    //GET
    // http://localhost:8888/api/student
    @GetMapping(value="/student",name="List of all students")
    private List<Student> getAllStudents() {
        return studentsService.getAllStudents();
    }

    //GET
    //http://localhost:8888/api/student/1
    @GetMapping(value = "/student/{studentid}", name = "Get student by id")
    private ResponseEntity<Student> getStudent(@PathVariable("studentid") Long studentid) throws RecordNotFoundException {
        Student entity=studentsService.getStudentById(studentid);
        return new ResponseEntity<Student>(entity,new HttpHeaders(), HttpStatus.OK);
    }

    //DELETE
    //http://localhost:8888/api/student/1
    @DeleteMapping(value="/student/{studentid}",name = "Delete student")
    private HttpStatus deleteStudent(@PathVariable("studentid") Long studentid) throws RecordNotFoundException {
        studentsService.delete(studentid);
        return HttpStatus.FORBIDDEN;
    }

    //http://localhost:8888/api/student
    @PostMapping(value = "/student",name="Save new student")
    private ResponseEntity<Student> saveStudent(@RequestBody Student entity) throws RecordNotFoundException {
        Student student= studentsService.saveOrUpdate(entity);
        return new ResponseEntity<Student>(student,new HttpHeaders(), HttpStatus.OK);
    }
    //http://localhost:8888/student
    @PutMapping(value = "/student",name="Update student")
    private ResponseEntity<Student> update(@RequestBody Student entity) throws RecordNotFoundException {
        Student student = studentsService.saveOrUpdate(entity);
        return new ResponseEntity<Student>(student,new HttpHeaders(), HttpStatus.OK);
    }

    // Sorting, filtring, paging
    // https://cloud.spring.io/spring-cloud-static/spring-cloud-openfeign/2.1.5.RELEASE/multi/multi_spring-cloud-feign.html#_feign_querymap_support
    @GetMapping("/student/parameters")
    public ResponseEntity<PagedList<Student>> getAllStudentsParameterised(@SpringQueryMap QueryStringParameterDto queryStringParameterDto) throws JsonProcessingException {
        PagedList<Student> students= new PagedList<>();
        if (queryStringParameterDto.isPaging() && queryStringParameterDto.isSorting())
            students=studentsService.getAllStudents(queryStringParameterDto.getCurrentPage(),
                    queryStringParameterDto.getPageSize(),
                    queryStringParameterDto.getFilter());
        else if (queryStringParameterDto.isSorting()) {
            List<Student> listStudent = new ArrayList<Student>();
            students.setList(listStudent);
        }
        else if (queryStringParameterDto.isPaging()) {
            students = studentsService.getAllStudents(
                    queryStringParameterDto.getCurrentPage(),
                    queryStringParameterDto.getPageSize(),
                    "");
        }
        HttpHeaders headers=new HttpHeaders();
        if (queryStringParameterDto.isPaging()) {
            PagingResult result=students.getPagingResult();
            String serialized = new ObjectMapper().writeValueAsString(result);
            headers.add("X-Pagination",serialized);
        }

        return  new ResponseEntity<PagedList<Student>>(students,headers,HttpStatus.OK);
    }
}
