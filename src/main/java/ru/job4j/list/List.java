package ru.job4j.list;

import java.util.ArrayList;

public interface List<T> extends Iterable<T> {

    int size();

    void add(T value);

    T set(int index, T newValue);

    T remove(int index);

    T get(int index);

}
