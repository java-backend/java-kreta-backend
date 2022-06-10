package org.example.kreta.model;

import java.util.Date;

public class Student {
    private long id;
    private String fullName;
    private Date birthday;
    private boolean isWoman;

    public Student() {
        this.id = -1;
        this.fullName = "";
        this.birthday = new Date();
        this.isWoman = true;
    }

    public Student(long iD, String fullName, Date birthday, boolean isWoman) {
        this.id = iD;
        this.fullName = fullName;
        this.birthday = birthday;
        this.isWoman = isWoman;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public boolean isWoman() {
        return isWoman;
    }

    public void setWoman(boolean woman) {
        isWoman = woman;
    }

    public boolean getIsWooman() {
        return isWoman;
    }

    public boolean getIsMan() {
        return !isWoman;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", birthday=" + birthday +
                ", isWoman=" + isWoman +
                '}';
    }
}
