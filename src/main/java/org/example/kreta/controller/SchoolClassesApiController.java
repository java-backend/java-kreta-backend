package org.example.kreta.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.kreta.model.SchoolClass;
import org.example.kreta.model.Subject;
import org.example.kreta.model.dto.QueryStringParameterDto;
import org.example.kreta.model.generic.PagedList;
import org.example.kreta.model.paging.PagingResult;
import org.example.kreta.service.SchoolClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class SchoolClassesApiController {
    @Autowired
    SchoolClassesService schoolClassService;

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


    @GetMapping("/schoolClass/parameters")
    public ResponseEntity<PagedList<SchoolClass>> getAllSchoolClassesParameters(@SpringQueryMap QueryStringParameterDto queryStringParameterDto) throws JsonProcessingException {
        PagedList<SchoolClass> schoolClasses= new PagedList<>();
        if (queryStringParameterDto.isPaging() && queryStringParameterDto.isSorting())
            schoolClasses= schoolClassService.getAllSchoolClasses(queryStringParameterDto.getCurrentPage(),
                    queryStringParameterDto.getPageSize(),
                    queryStringParameterDto.getFilter());
        else if (queryStringParameterDto.isSorting()) {
            List<SchoolClass> listSchoolClass = new ArrayList<SchoolClass>();
            schoolClasses.setList(listSchoolClass);
        }
        else if (queryStringParameterDto.isPaging()) {
            schoolClasses = schoolClassService.getAllSchoolClasses(
                    queryStringParameterDto.getCurrentPage(),
                    queryStringParameterDto.getPageSize(),
                    "");
        }
        HttpHeaders headers=new HttpHeaders();
        if (queryStringParameterDto.isPaging()) {
            PagingResult result=schoolClasses.getPagingResult();
            String serialized = new ObjectMapper().writeValueAsString(result);
            headers.add("X-Pagination",serialized);
        }

        return  new ResponseEntity<PagedList<SchoolClass>>(schoolClasses,headers, HttpStatus.OK);
    }
}
