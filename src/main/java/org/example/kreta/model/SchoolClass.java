package org.example.kreta.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.kreta.model.baseclass.ModelWithIdAndAnnotation;

import javax.persistence.*;


@Entity
@Table(name="schoolclass")
@Setter
@Getter
@AllArgsConstructor
public class SchoolClass extends ModelWithIdAndAnnotation {
    @Column (name = "schoolClass",unique = false)
    private int schoolClass;
    @Column(name = "classType",nullable = false)
    private char classType;
    @Column (name = "teacherId", nullable = false)
    private long teacherId;

    public SchoolClass() {
        this.id=Long.valueOf(-1);
        this.schoolClass=-1;
        this.classType='a';
        this.teacherId=-1;

    }

    public SchoolClass(long id, int schoolClass, char classType, int teacherId) {
        this.id = id;
        this.schoolClass = schoolClass;
        this.classType = classType;
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


