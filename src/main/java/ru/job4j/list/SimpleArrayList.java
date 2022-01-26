package ru.job4j.list;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

public class SimpleArrayList<T> implements List<T> {

    private T[] container;

    private int size;

    private int modCount;

    private int expectedModCount;

    public SimpleArrayList(int capacity) {
        this.container = (T[]) new Object[capacity];
    }

    @Override
    public void add(T value) {
        modCount++;
        if (size == container.length) {
            container = Arrays.copyOf(container, container.length * 2);
        }
        container[size()] = value;
        size = size + 1;
    }

    @Override
    public T set(int index, T newValue) {
        Objects.checkIndex(index, size);
        container[index] = newValue;
        return container[index];
    }

    @Override
    public T remove(int index) {
        Objects.checkIndex(index, size);
        modCount++;
        System.arraycopy(container, index + 1,
                container, index, container.length - index - 1);
        container[container.length - 1] = null;
        return container[index];
    }

    @Override
    public T get(int index) {
        Objects.checkIndex(index, size);
        return container[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public T next() {
                return container[0];
            }

        };
    }
}
