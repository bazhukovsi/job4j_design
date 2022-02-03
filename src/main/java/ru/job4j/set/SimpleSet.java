package ru.job4j.set;

import ru.job4j.list.SimpleArrayList;

import java.util.Iterator;
import java.util.Objects;

public class SimpleSet<T> implements Set<T> {

    private SimpleArrayList<T> set = new SimpleArrayList<>(10);

    @Override
    public boolean add(T value) {
        if (!contains(value)) {
            set.add(value);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean contains(T value) {
        boolean findValue = false;
        for (T t : set) {
            if (Objects.equals(t, value)) {
                findValue = true;
                break;
            }
        }
        return findValue;
    }

    @Override
    public Iterator<T> iterator() {
        return set.iterator();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SimpleSet<?> simpleSet = (SimpleSet<?>) o;
        return Objects.equals(set, simpleSet.set);
    }

    @Override
    public int hashCode() {
        return Objects.hash(set);
    }
}
