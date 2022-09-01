package org.example.kreta.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table (name="subject")
public class Subject {
    @Id
    private long id;
    private String subjectName;

    public Subject() {
        this.id=-1;
        this.subjectName="";
    }
    public Subject(long id, String subjectName) {
        this.id = id;
        this.subjectName = subjectName;
    }

    public long getId() {
        return id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", subjectName='" + subjectName + '\'' +
                '}';
    }
}
