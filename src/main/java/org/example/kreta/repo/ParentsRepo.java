package org.example.kreta.repo;


import org.example.kreta.model.Parent;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.GregorianCalendar;
import java.util.List;

public class ParentsRepo {
    private List<Parent> parents;

    public ParentsRepo() {
        parents = new ArrayList<>();
        MakeTestData();
    }

    private void MakeTestData() {
        parents.add(new Parent(1, "Kis", "Szonja", true, new GregorianCalendar(1974, 1, 13)));
        parents.add(new Parent(2, "Nagy", "Imre", false, new GregorianCalendar(1974, 7, 7)));
        parents.add(new Parent(3, "Szabó", "Ida", true, new GregorianCalendar(1974, 8, 9)));
        parents.add(new Parent(4, "Szabó", "Sándor", false, new GregorianCalendar(1974, 11, 24)));
        parents.add(new Parent(5, "Kis", "Éva", true, new GregorianCalendar(1974, 9, 9)));
        parents.add(new Parent(6, "Kertész", "Zoltán", false, new GregorianCalendar(1974, 10, 19)));
        parents.add(new Parent(7, "Olajos", "Magdolna", true, new GregorianCalendar(1974, 8, 30)));
        parents.add(new Parent(8, "Izgalmas", "Márk", false, new GregorianCalendar(1974, 5, 9)));
        parents.add(new Parent(9, "Faégető", "Vilmos", false, new GregorianCalendar(1974, 3, 2)));
        parents.add(new Parent(10, "Törödő", "Tekla", true, new GregorianCalendar(1974, 2, 19)));
        parents.add(new Parent(11, "Magyar", "Helga", true, new GregorianCalendar(1974, 7, 8)));
        parents.add(new Parent(12, "Kertész", "László", false, new GregorianCalendar(1974, 3, 12)));
    }

    public List<Parent> getParents(boolean wooman) {
        return parents
                .stream()
                .filter(x -> x.isWooman() == wooman)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    public List<String> getParentsLastAndFirstName(boolean wooman) {
        return null;
    }

}