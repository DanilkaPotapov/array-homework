package com.edu;

import java.util.Iterator;

public class DefaultCustomArrayList<E> implements CustomArrayList<E> {

    private Object[] array;

    public DefaultCustomArrayList() {
        array = new Object[0];
    }

    @Override
    public boolean add(E element) {
        int newSize = array.length + 1;
        Object[] newArray = new Object[newSize];
        System.arraycopy(array, 0, newArray, 0, array.length);
        newArray[array.length] = element;

        array = newArray;

        return true;
    }

    @Override
    public boolean remove(E element) {
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if ((E) array[i] == element) {
                index = i;
            }
        }

        if (index == -1) {
            return false;
        }

        int newSize = array.length - 1;
        Object[] newArray = new Object[newSize];
        System.arraycopy(array, 0, newArray, 0, index);
        System.arraycopy(array, index + 1, newArray, index, array.length - 1 - index);
        array = newArray;
        return true;
    }

    private void remove(int index) {
        if (index >= array.length || index < 0) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        int newSize = array.length - 1;
        Object[] newArray = new Object[newSize];
        System.arraycopy(array, 0, newArray, 0, index);
        System.arraycopy(array, index + 1, newArray, index, array.length - 1 - index);
        array = newArray;
    }

    @Override
    public E get(int index) {
        return (E) array[index];
    }

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public boolean isEmpty() {
        return array.length == 0;
    }

    @Override
    public void clear() {
        array = new Object[0];
    }

    @Override
    public boolean contains(E element) {
        for (int i = 0; i < array.length; i++) {
            if ((E) array[i] == element) {
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
            return currentIndex < array.length;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new IndexOutOfBoundsException("No more elements");
            }
            
            return (E) array[currentIndex++];
        }

    }
}