package org.example.kreta.repo.oldrepo;


import org.example.kreta.model.Grade;

import java.util.ArrayList;
import java.util.List;

public class GradeRepo {

    List<Grade> grades;

    public GradeRepo() {
        grades = new ArrayList<Grade>();
        MakeTestData();
    }

    public void MakeTestData() {
        grades.add(new Grade(1, 1, 1, new ArrayList<Integer>()));
        grades.add(new Grade(1, 2, 1, new ArrayList<Integer>()));
    }
}



