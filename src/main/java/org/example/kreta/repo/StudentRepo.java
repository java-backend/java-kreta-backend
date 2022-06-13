package org.example.kreta.repo;

import org.example.kreta.model.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;

//https://www.javatpoint.com/spring-boot-crud-operations

public class StudentRepo implements CrudRepository<Student, Long> {

    private List<Student> students;

    public StudentRepo() {  this.students = new ArrayList<Student>();  }

    public void MakeTestData()  {
        students.add(new Student(1,"Kis Pista", new GregorianCalendar(2002,1,15),false));
        students.add(new Student(2,"Nagy Éva",new GregorianCalendar(2003,5,13),true));
        students.add(new Student(3,"Nagy János",new GregorianCalendar(2002,9,13),false));
        students.add(new Student(4,"Kis Cecil",new GregorianCalendar(2002,4,8),true));
    }

    @Override
    public <S extends Student> S save(S s) {
        return null;
    }

    @Override
    public <S extends Student> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Student> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Student> findAll() {
        return null;
    }

    @Override
    public Iterable<Student> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Student student) {

    }

    @Override
    public void deleteAll(Iterable<? extends Student> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
