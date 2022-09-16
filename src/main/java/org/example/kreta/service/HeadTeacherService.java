package org.example.kreta.service;

import org.example.kreta.model.Teacher;
import org.example.kreta.repo.oldrepo.SchoolClassesRepo;
import org.example.kreta.repo.oldrepo.TeachersRepo;

public class HeadTeacherService {
    private SchoolClassesRepo schoolClassesRepo;
    private TeachersRepo teachersRepo;

    public HeadTeacherService() {
        schoolClassesRepo=new SchoolClassesRepo();
        teachersRepo=new TeachersRepo();
    }

    public Teacher getHeadTeacherOfClass(int schoolClass, char classType) {
        long headTeacherId=schoolClassesRepo.getHeadTeacherIdByClass(schoolClass,classType);
        return teachersRepo.getTeacherById(headTeacherId);

    }
}
