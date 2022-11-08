package org.example.kreta.repo.interfaces;

import org.example.kreta.model.Subject;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends PagingAndSortingRepository<Subject,Long> {
}
