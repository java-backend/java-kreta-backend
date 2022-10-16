package org.example.kreta.repo.interfaces;

import org.example.kreta.model.SchoolClass;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SchoolClassRepository extends PagingAndSortingRepository<SchoolClass, Long> {
}
