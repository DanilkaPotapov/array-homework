package com.edu;

import java.util.ArrayList;
import java.util.Iterator;

public class DefaultCustomArrayList<E> implements CustomArrayList<E> {

    private ArrayList<E> array;

    public DefaultCustomArrayList() {
        array = new ArrayList<E>();
    }

    @Override
    public boolean add(E element) {
        array.add(element);

        return true;
    }

    @Override
    public boolean remove(E element) {
        int index = -1;
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i).equals(element)) {
                index = i;
            }
        }

        if (index == -1) {
            return false;
        }

        array.remove(index);

        return true;
    }

    private void remove(int index) {
        if (index >= array.size() || index < 0) {
            throw new IndexOutOfBoundsException("Index out of range");
        }

        array.remove(index);
    }

    @Override
    public E get(int index) {
        if (index >= array.size() || index < 0) {
            throw new IndexOutOfBoundsException("Index out of range");
        }

        return array.get(index);
    }

    @Override
    public int size() {
        return array.size();
    }

    @Override
    public boolean isEmpty() {
        return array.size() == 0;
    }

    @Override
    public void clear() {
        array = new ArrayList<E>();
    }

    @Override
    public boolean contains(E element) {
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i).equals(element)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<E> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < array.size();
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new IndexOutOfBoundsException("No more elements");
            }
            E result = array.get(currentIndex);
            currentIndex++;
            return result;
        }

    }
}
