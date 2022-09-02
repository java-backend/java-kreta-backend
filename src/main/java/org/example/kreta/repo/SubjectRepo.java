package org.example.kreta.repo;

import org.example.kreta.model.Subject;
import org.example.kreta.repo.interfaces.SubjectRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SubjectRepo {
    private List<Subject> subjects;

    public SubjectRepo() {
        subjects=new ArrayList<>();
        MakeTestData();
    }

    public void MakeTestData() {
        subjects.add(new Subject(1, "Informatika"));
        subjects.add(new Subject(2, "Angol"));
        subjects.add(new Subject(3, "Matematika"));
        subjects.add(new Subject(4, "Fizika"));
        subjects.add(new Subject(5, "Testnevelés"));
        subjects.add(new Subject(6, "Történelem"));
        subjects.add(new Subject(7, "Magyar nyelv és Irodalom"));
    }


    public List<Subject> getSubjectByIds(List<Long> subjectIds) {
        return subjects.stream()
                .filter(s -> subjectIds.contains(s.getId()))
                .collect(Collectors.toList());
    }
}

