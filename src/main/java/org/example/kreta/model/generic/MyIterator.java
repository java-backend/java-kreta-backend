package org.example.kreta.model.generic;

import lombok.AllArgsConstructor;

import java.util.Iterator;

// https://www.geeksforgeeks.org/java-implementing-iterator-and-iterable-interface/

public class MyIterator <T> implements Iterator<T> {

    Node<T> current;

    public MyIterator(PagedList<T> tPagedList) {
    }

    @Override
    public boolean hasNext() {
        return current!=null;
    }

    @Override
    public T next() {
        T data = current.getData();
        current = current.getNext();
        return data;
    }
}
