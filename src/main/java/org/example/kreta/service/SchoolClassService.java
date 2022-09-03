package org.example.kreta.service;
import org.example.kreta.model.SchoolClass;
import org.example.kreta.repo.interfaces.SchoolClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class SchoolClassService {

    @Autowired
    SchoolClassRepository schoolClassRepository;

    public List<SchoolClass> getAllSchoolClass()
    {
        List<SchoolClass> schoolClasses=new ArrayList<SchoolClass>();
        schoolClassRepository.findAll().forEach(schoolClass -> schoolClasses.add(schoolClass));
        return schoolClasses ;
    }

    public SchoolClass getSchoolClass(Long id) {return schoolClassRepository.findById(id).get();
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
}
