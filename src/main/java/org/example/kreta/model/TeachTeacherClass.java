package org.example.kreta.model;

import java.util.Date;

public class TeachTeacherClass {
        private long teacherId;
        private long classId;
        private int numberOfTeachingHours;

    public long getTeacherId() {
        return teacherId;
    }

    public long getClassId() {
        return classId;
    }

    public int getNumberOfTeachingHours() {
        return numberOfTeachingHours;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public void setNumberOfTeachingHours(int numberOfTeachingHours) {
        this.numberOfTeachingHours = numberOfTeachingHours;
    }
}

