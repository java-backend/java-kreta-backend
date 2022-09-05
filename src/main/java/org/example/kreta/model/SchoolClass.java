package org.example.kreta.model;

import javax.persistence.*;


@Entity
@Table (name="schoolClass")
public class SchoolClass {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column (name = "schoolClass",unique = false)
    private int schoolClass;
    @Column(name = "classType",nullable = false)
    private char classType;
    @Column (name = "teacherId", nullable = false)
    private int teacherId;


    public SchoolClass() {
        this.id=Long.valueOf(-1);
        this.schoolClass=1;
        this.classType='c';
        this.teacherId=-1;

    }

    public SchoolClass(long id, int schoolClass, char classType, int teacherId) {
        this.id = id;
        this.schoolClass = schoolClass;
        this.classType = classType;
        this.teacherId = teacherId;
    }



    public long getId() {
        return id;
    }

    public int getSchoolClass() {
        return schoolClass;
    }

    public char getClassType() {
        return classType;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSchoolClass(int schoolClass) {
        this.schoolClass = schoolClass;
    }

    public void setClassType(char classType) {
        this.classType = classType;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public String toString() {
        return "SchoolClass{" +
                "id=" + id +
                ", schoolClass=" + schoolClass +
                ", classType=" + classType +
                ", teacherId=" + teacherId +
                '}';
    }
}


