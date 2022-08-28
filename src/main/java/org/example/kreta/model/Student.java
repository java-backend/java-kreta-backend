package org.example.kreta.model;

import javax.persistence.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

// https://www.baeldung.com/jpa-entities
@Entity
@Table(name="student")
public class Student {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name="name", length=30, nullable=false, unique=false)
    private String fullName;
    @Column(name = "birthday",nullable = false,unique = false)
    private Calendar birthday;
    @Column(name = "iswoman",nullable = false,unique = false)
    private boolean isWoman;

    public void setId(Long id) {
        this.id = id;
    }

    public Student() {
        this.id = Long.valueOf(-1);
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
