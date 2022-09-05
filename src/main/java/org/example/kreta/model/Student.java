package org.example.kreta.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Calendar;

//https://www.baeldung.com/intro-to-project-lombok

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

// https://www.baeldung.com/jpa-entities
@Entity
@Table(name="student")
public class Student {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    @Column(name="name", length=30, nullable=false, unique=false)
    private String fullName;
    @Column(name = "birthday",nullable = true,unique = false)
    private Calendar birthday;
    @Column(name = "iswoman",nullable = false,unique = false)
    private boolean isWoman;

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
