package org.example.kreta.repo;

import org.example.kreta.model.Student;
import org.example.kreta.repo.interfaces.StudentRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;

//https://www.javatpoint.com/spring-boot-crud-operations

//public class StudentRepo implements CrudRepository<Student, Long> {
public class StudentRepo {

    private List<Student> students;

    public StudentRepo() {  this.students = new ArrayList<Student>(); MakeTestData(); }

    public void MakeTestData()  {
        //students.add(new Student((long) 1,"Kis Pista", new GregorianCalendar(2002,1,15),false));
        //students.add(new Student((long) 2,"Nagy Éva",new GregorianCalendar(2003,5,13),true));
        //students.add(new Student((long) 3,"Nagy János",new GregorianCalendar(2002,9,13),false));
        //students.add(new Student((long) 4,"Kis Cecil",new GregorianCalendar(2002,4,8),true));
    }
}
