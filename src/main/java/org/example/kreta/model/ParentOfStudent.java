package org.example.kreta.model;


public class ParentOfStudent {
    private long studentId;
    private long parentId;


    public ParentOfStudent(long studentId, long parentId) {
        this.studentId = studentId;
        this.parentId = parentId;
    }
}
