package org.example.kreta.model;

import java.util.Date;
import java.util.List;

public class Grade {
    private long teacherId;
    private long subjectId;
    private long studentId;

    private List<Integer> grades;

    public Grade(long teacherId, long subjectId, long studentId, List<Integer> grades) {
        this.teacherId = teacherId;
        this.subjectId = subjectId;
        this.studentId = studentId;
        this.grades = grades;
    }
}