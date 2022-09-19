package org.example.kreta.service;

import org.example.kreta.model.Subject;
import org.example.kreta.repo.interfaces.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class SubjectsService {
    @Autowired
    SubjectRepository subjectRepository;

    public List<Subject> getAllSubjects()
    {
        List<Subject> subjects=new ArrayList<Subject>();
      subjectRepository.findAll().forEach(subject -> subjects.add(subject));
        return subjects;
    }

    public Subject getSubjectById(Long id) {
        Optional<Subject> subject=subjectRepository.findById(id);
        return subject.get();
    }

    public void saveOrUpdate(Subject subject) {
        subjectRepository.save(subject);
    }

    public void delete(Long id) {
        subjectRepository.deleteById(id);
    }

    public void update(Subject subject, Long id) {
        subjectRepository.save(subject);
    }
}
