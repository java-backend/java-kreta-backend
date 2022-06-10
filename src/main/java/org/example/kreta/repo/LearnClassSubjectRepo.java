package org.example.kreta.repo;


import org.example.kreta.model.LearnClassSubject;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class LearnClassSubjectRepo {
    private List<LearnClassSubject> learnClassSubject;

    public LearnClassSubjectRepo() {
        learnClassSubject = new ArrayList<LearnClassSubject>();
        MakeTestData();
    }

    public void MakeTestData() {
        learnClassSubject.add(new LearnClassSubject(1, 1));
        learnClassSubject.add(new LearnClassSubject(1, 2));
        learnClassSubject.add(new LearnClassSubject(3, 1));
        learnClassSubject.add(new LearnClassSubject(4, 2));
        learnClassSubject.add(new LearnClassSubject(4, 3));
    }

    public List<Long> getSubjectIdsLearnBySchoolClass(long schoolClassId) {
        return learnClassSubject
                .stream()
                .filter(lcs -> lcs.getClassId() == schoolClassId)
                .map(LearnClassSubject::getSubjectId)
                .collect(toList());
    }
}

