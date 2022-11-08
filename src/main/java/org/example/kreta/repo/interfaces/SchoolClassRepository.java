package org.example.kreta.repo.interfaces;

import org.example.kreta.model.SchoolClass;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolClassRepository extends PagingAndSortingRepository<SchoolClass, Long> {
}
