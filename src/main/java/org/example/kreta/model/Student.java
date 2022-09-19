package org.example.kreta.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.kreta.model.baseclass.ModelWithIdAndAnnotation;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

//https://www.baeldung.com/intro-to-project-lombok

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

// https://www.baeldung.com/jpa-entities
@Entity
@Table(name="student")
public class Student extends ModelWithIdAndAnnotation {
    @NotBlank(message = "Name is mandatory")
    @Column(name="name", length=30, nullable=false, unique=false)
    private String fullName;
    @Column(name = "birthday",nullable = true,unique = false)
    @JsonFormat(pattern="yyyy.MM.dd", timezone = "Europe/Budapest")
    private Date birthday;
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
