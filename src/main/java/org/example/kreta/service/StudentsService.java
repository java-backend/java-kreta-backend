package org.example.kreta.service;

import org.example.kreta.model.Student;
import org.example.kreta.model.generic.PagedList;
import org.example.kreta.repo.exceptions.RecordNotFoundException;
import org.example.kreta.repo.interfaces.StudentRepository;
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
public class StudentsService {

    @Autowired
    StudentRepository studentRepository;

    public List<Student> getAllStudents()
    {
        List<Student> students=new ArrayList<Student>();
        studentRepository.findAll().forEach(student -> students.add(student));

        // findAll(Sort.by("name"))

        return students;
    }

    public Student getStudentById(Long id) throws RecordNotFoundException {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent())
            return student.get();
        else
            throw new RecordNotFoundException("Nincs diák a megadott felhasználói id-vel.");
    }

    public Student saveOrUpdate(Student entity) throws RecordNotFoundException {
        Optional<Student> student = studentRepository.findById(entity.getId());
        studentRepository.save(entity);
        return entity;
    }

    public void delete(Long id) throws RecordNotFoundException {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent())
            studentRepository.deleteById(id);
        throw new RecordNotFoundException("Nincs diák a megadott felhasználói id-vel.");
    }

    public void update(Student student, Long id) {
        studentRepository.save(student);
    }

    public PagedList<Student> getAllStudents(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging;
        if (sortBy!=null)
            paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        else
            paging = PageRequest.of(pageNo, pageSize);
        Page<Student> pagedResult = studentRepository.findAll(paging);
        PagedList<Student> pagedList = new PagedList<Student>();

        if (pagedResult.hasContent()) {
            pagedList.setList(pagedResult.getContent());

            pagedList.setCurrentPage(paging.getPageNumber());
            pagedList.setPageSize(pageSize);
            int numberOfPage=(int) Math.floor(studentRepository.count()/pageSize)+1;
            pagedList.setNumberOfPage(numberOfPage);
            pagedList.setNumberOfItem(studentRepository.count());
        }
        else {
            pagedList.setCurrentPage(paging.getPageNumber());
            pagedList.setPageSize(pageSize);
            pagedList.setNumberOfPage(0);
            pagedList.setNumberOfItem(studentRepository.count());
        }
        return pagedList;
    }
}
