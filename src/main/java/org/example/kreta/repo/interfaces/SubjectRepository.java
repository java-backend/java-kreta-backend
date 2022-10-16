package org.example.kreta.repo.interfaces;

import org.example.kreta.model.Student;
import org.example.kreta.model.Subject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SubjectRepository extends PagingAndSortingRepository<Subject,Long> {
}
