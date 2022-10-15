package org.example.kreta.service;
import org.example.kreta.model.SchoolClass;
import org.example.kreta.model.Subject;
import org.example.kreta.model.generic.PagedList;
import org.example.kreta.repo.interfaces.SchoolClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class SchoolClassesService {

    @Autowired
    SchoolClassRepository schoolClassRepository;

    public List<SchoolClass> getAllSchoolClass()
    {
        List<SchoolClass> schoolClasses=new ArrayList<SchoolClass>();
        schoolClassRepository.findAll().forEach(schoolClass -> schoolClasses.add(schoolClass));
        return schoolClasses ;
    }

    public SchoolClass getSchoolClassByID(Long id) {return schoolClassRepository.findById(id).get();
    }

    public void saveOrUpdate(SchoolClass schoolClass) {
        schoolClassRepository.save(schoolClass);
    }

    public void delete(Long id) {
        schoolClassRepository.deleteById(id);
    }

    public void update(SchoolClass schoolClass, Long id) {
        schoolClassRepository.save(schoolClass);
    }

    public PagedList<SchoolClass> getAllSchoolClasses(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging;
        if (sortBy!=null)
            paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        else
            paging = PageRequest.of(pageNo, pageSize);
        Page<SchoolClass> pagedResult = schoolClassRepository.findAll(paging);
        PagedList<SchoolClass> pagedList = new PagedList<SchoolClass>();

        if (pagedResult.hasContent()) {
            pagedList.setList(pagedResult.getContent());

            pagedList.setCurrentPage(paging.getPageNumber());
            pagedList.setPageSize(pageSize);
            int numberOfPage=(int) Math.floor(schoolClassRepository.count()/pageSize)+1;
            pagedList.setNumberOfPage(numberOfPage);
            pagedList.setNumberOfItem(schoolClassRepository.count());
        }
        else {
            pagedList.setCurrentPage(paging.getPageNumber());
            pagedList.setPageSize(pageSize);
            pagedList.setNumberOfPage(0);
            pagedList.setNumberOfItem(schoolClassRepository.count());
        }
        return pagedList;
    }
}
