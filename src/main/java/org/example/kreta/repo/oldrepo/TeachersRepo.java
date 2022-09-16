package org.example.kreta.repo.oldrepo;

import org.example.kreta.model.Teacher;
import org.example.kreta.model.TeacherInfo;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import static java.util.stream.Collectors.toList;

public  class TeachersRepo {

    public List<Teacher> teachers;


    public TeachersRepo() {
        teachers = new ArrayList<Teacher>();
        MakeTestData();
    }


    public void MakeTestData() {
        teachers.add(new Teacher(1, "Számoló", "Szonja", true, new GregorianCalendar(1974, 10, 24)));
        teachers.add(new Teacher(2, "Buktató", "Béla", false, new GregorianCalendar(1974, 10, 24)));
        teachers.add(new Teacher(3, "Aritmetika", "Antal", false, new GregorianCalendar(1974, 10, 24)));
        teachers.add(new Teacher(4, "Arany", "András", false, new GregorianCalendar(1974, 10, 24)));
        teachers.add(new Teacher(5, "Sportoló", "Jenő", false, new GregorianCalendar(1974, 10, 24)));
        teachers.add(new Teacher(6, "Visszanéző", "Viola", true, new GregorianCalendar(1974, 10, 24)));
    }

    public List<TeacherInfo> getTeacherInfo(boolean isWoman) {
        return this.teachers
                .stream()
                .filter(t -> t.isWooman() == isWoman)
                .map(t -> new TeacherInfo(t.getId(),t.getFirstName(),t.getLastName()))
                .collect(toList());
    }

    public Teacher getTeacherById(long id) {
        return this.teachers.stream()
                .filter(t -> t.getId() == id)
                .collect(toList())
                .get(0);
    }

}