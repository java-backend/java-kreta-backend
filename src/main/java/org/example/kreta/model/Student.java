package org.example.kreta.model;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Student {
    private long id;
    private String fullName;
    private Calendar birthday;
    private boolean isWoman;

    public Student() {
        this.id = -1;
        this.fullName = "";
        this.birthday = new GregorianCalendar();
        this.isWoman = true;
    }

    public Student(long iD, String fullName, Calendar birthday, boolean isWoman) {
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

    public Calendar getBirthday() {
        return birthday;
    }

    public void setBirthday(Calendar birthday) {
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
