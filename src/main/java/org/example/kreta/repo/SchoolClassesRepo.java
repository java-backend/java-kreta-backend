package org.example.kreta.repo;

import org.example.kreta.model.SchoolClass;

import java.util.ArrayList;
import java.util.List;

public class SchoolClassesRepo {
    private List<SchoolClass> schoolClasses;


    public SchoolClassesRepo() {
        schoolClasses = new ArrayList<SchoolClass>();
        MakeTestData();
    }

    public void MakeTestData() {
        schoolClasses.add(new SchoolClass(1, 9, 'a', 4));
        schoolClasses.add(new SchoolClass(2, 9, 'b', 1));
        schoolClasses.add(new SchoolClass(3, 10, 'a', 6));
        schoolClasses.add(new SchoolClass(4, 10, 'b', 3));
        schoolClasses.add(new SchoolClass(5, 10, 'c', 0));
        schoolClasses.add(new SchoolClass(6, 11, 'a', 0));
    }

    public long getNumberOfSchoolClass(long schoolClass) {
        return this.schoolClasses
                .stream()
                .filter(sc -> sc.getSchoolClass() == schoolClass)
                .count();
    }

    public long getNumberOfSchoolType(long classType) {
        long num = schoolClasses.stream()
                .filter(s -> s.getClassType() == classType)
                .count();
        return num;
    }

    public long getHeadTeacherIdByClass(int schoolClass,char classType) {
        return schoolClasses
                .stream()
                .filter(sc -> sc.getSchoolClass()==schoolClass &&
                              sc.getClassType()==classType)
                .findFirst()
                .get()
                .getTeacherId();
    }

    public long getId(int schoolClass, char classType) {
        return schoolClasses
                .stream()
                .filter(sc -> sc.getSchoolClass()==schoolClass &&
                              sc.getClassType()==classType )
                .findFirst()
                .get()
                .getId();
    }
}

