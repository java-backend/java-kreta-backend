package org.example.kreta.service;

import org.example.kreta.model.Subject;
import org.example.kreta.model.generic.PagedList;
import org.example.kreta.repo.interfaces.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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


    public PagedList<Subject> getAllSubjects(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging;
        if (sortBy!=null)
            paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        else
            paging = PageRequest.of(pageNo, pageSize);
        Page<Subject> pagedResult = subjectRepository.findAll(paging);
        PagedList<Subject> pagedList = new PagedList<Subject>();

        if (pagedResult.hasContent()) {
            pagedList.setList(pagedResult.getContent());

            pagedList.setCurrentPage(paging.getPageNumber());
            pagedList.setPageSize(pageSize);
            int numberOfPage=(int) Math.floor(subjectRepository.count()/pageSize)+1;
            pagedList.setNumberOfPage(numberOfPage);
            pagedList.setNumberOfItem(subjectRepository.count());
        }
        else {
            pagedList.setCurrentPage(paging.getPageNumber());
            pagedList.setPageSize(pageSize);
            pagedList.setNumberOfPage(0);
            pagedList.setNumberOfItem(subjectRepository.count());
        }
        return pagedList;
    }
}
