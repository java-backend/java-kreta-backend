package org.example.kreta.service;

import org.example.kreta.model.Student;
import org.example.kreta.repo.interfaces.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class StudentsService {

    @Autowired
    StudentRepository studentRepository;

    public List<Student> getAllStudents()
    {
        List<Student> students=new ArrayList<Student>();
        studentRepository.findAll().forEach(student -> students.add(student));
        return students;
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).get();
    }

    public void saveOrUpdate(Student student) {
        studentRepository.save(student);
    }

    public void delete(Long id) {
        studentRepository.deleteById(id);
    }

    public void update(Student student, Long id) {
        studentRepository.save(student);
    }
}
