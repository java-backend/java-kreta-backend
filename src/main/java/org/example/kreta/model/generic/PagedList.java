package org.example.kreta.model.generic;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@Getter
@Setter
public class PagedList<T> implements Iterable,IPagedList {
    private long numberOfItem;
    private int pageSize;
    private int currentPage;
    private int numberOfPage;
    private List<T> list;

    public PagedList() {
        numberOfItem=0;
        pageSize=0;
        currentPage=0;
        numberOfPage=0;
        list = new ArrayList<T>();
    }



    @Override
    public int size() {
        return list.size();
    }

    @Override
    public Iterator iterator() {
        return new MyIterator<T>(this);
    }
}

