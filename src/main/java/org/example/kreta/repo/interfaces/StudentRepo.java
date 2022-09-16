package org.example.kreta.repo.interfaces;

import org.example.kreta.model.Student;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

//https://www.javatpoint.com/spring-boot-crud-operations
//https://howtodoinjava.com/spring-boot2/pagination-sorting-example/

@Repository
public interface StudentRepo extends PagingAndSortingRepository<Student,Long> {


}
