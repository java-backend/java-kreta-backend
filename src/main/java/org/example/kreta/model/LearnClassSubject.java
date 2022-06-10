package org.example.kreta.model;


public class LearnClassSubject {
    private long classId;
    private long SubjectId;

    public LearnClassSubject(long classId, long subjectId) {
        this.classId = classId;
        SubjectId = subjectId;
    }

    public void setClassId(long classId) {
        this.classId = classId;
    }

    public void setSubjectId(long subjectId) {
        SubjectId = subjectId;
    }

    public long getClassId() {
        return classId;
    }

    public long getSubjectId() {
        return SubjectId;
    }
}

