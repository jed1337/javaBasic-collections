package com.cultivation.javaBasic.showYourIntelligence;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;

public class DistinctIterable<T> implements Iterable<T> {
    private Iterable<T> iterable;

    public DistinctIterable(Iterable<T> iterable) {
        this.iterable = iterable;
    }

    @Override
    public Iterator<T> iterator() {
        return new DistinctIterator<>(iterable.iterator());
    }

    public List<T> toList() {
        ArrayList<T> result = new ArrayList<>();
        this.forEach(result::add);
        return result;
    }
}

class DistinctIterator<E> implements Iterator<E> {
    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    private final Iterator<E> iterator;

    DistinctIterator(Iterator<E> outerIterator) {
        // TODO: Implement the class to pass the test. Note that you cannot put all items into memory or you will fail.
        // <--start
        Set<E> distinctElements = new HashSet<>();

        while(outerIterator.hasNext()){
            distinctElements.add(outerIterator.next());
        }

        this.iterator = distinctElements.iterator();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public E next() {
        return iterator.next();
    }
    // --end->
}