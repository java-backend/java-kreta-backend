package org.example.kreta.model;

import java.util.Date;

public class TeachTeacherSubject {
    private long teacherID;
    private long subjectID;

    public TeachTeacherSubject(long teacherID, long subjectID) {
        this.teacherID = teacherID;
        this.subjectID = subjectID;
    }

    public long getTeacherID() {
        return teacherID;
    }

    public long getSubjectID() {
        return subjectID;
    }

    public void setTeacherID(long teacherID) {
        this.teacherID = teacherID;
    }

    public void setSubjectID(long subjectID) {
        this.subjectID = subjectID;
    }
}
