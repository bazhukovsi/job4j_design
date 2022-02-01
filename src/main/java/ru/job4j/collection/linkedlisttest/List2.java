package ru.job4j.collection.linkedlisttest;

public interface List2<E> extends Iterable<E> {
    void add(E value);

    E get(int index);
}
