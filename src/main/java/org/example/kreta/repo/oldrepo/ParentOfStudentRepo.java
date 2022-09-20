package org.example.kreta.repo.oldrepo;


import org.example.kreta.model.ParentOfStudent;

import java.util.ArrayList;
import java.util.List;

public class ParentOfStudentRepo {
    List<ParentOfStudent> parentOfStudents;

    public ParentOfStudentRepo() {
        parentOfStudents = new ArrayList<>();
        MakeTestData();
    }

    private void MakeTestData() {
        parentOfStudents.add(new ParentOfStudent(1, 1));
        parentOfStudents.add(new ParentOfStudent(1, 2));
        parentOfStudents.add(new ParentOfStudent(2, 3));
        parentOfStudents.add(new ParentOfStudent(2, 4));
        parentOfStudents.add(new ParentOfStudent(3, 5));
        parentOfStudents.add(new ParentOfStudent(3, 6));
        parentOfStudents.add(new ParentOfStudent(4, 7));
        parentOfStudents.add(new ParentOfStudent(4, 8));
        parentOfStudents.add(new ParentOfStudent(5, 9));
        parentOfStudents.add(new ParentOfStudent(6, 10));
    }
}


