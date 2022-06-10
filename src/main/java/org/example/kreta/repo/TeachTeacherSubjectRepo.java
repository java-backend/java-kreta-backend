package org.example.kreta.repo;

import org.example.kreta.model.TeachTeacherSubject;

import java.util.ArrayList;
import java.util.List;

public class TeachTeacherSubjectRepo {
    private List<TeachTeacherSubject> teachTeacherSubjects;

    public TeachTeacherSubjectRepo() {
        teachTeacherSubjects = new ArrayList<TeachTeacherSubject>();
        MakeTestData();
    }

    public void MakeTestData() {
        teachTeacherSubjects.add(new TeachTeacherSubject(1, 1));
        teachTeacherSubjects.add(new TeachTeacherSubject(1, 2));
        teachTeacherSubjects.add(new TeachTeacherSubject(2, 1));
        teachTeacherSubjects.add(new TeachTeacherSubject(2, 2));
        teachTeacherSubjects.add(new TeachTeacherSubject(2, 3));
    }
}