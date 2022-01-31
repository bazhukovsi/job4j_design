package ru.job4j.collection.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleLinkedList<E> implements ru.job4j.collection.list.List<E> {

    private int modCount;
    int size = 0;
    private Node<E> first;
    private Node<E> last;

    private static class Node<E> {
        Node<E> prev;
        E element;
        Node<E> next;

        Node(Node<E> prev, E element, Node<E> next) {
            this.prev = prev;
            this.element = element;
            this.next = next;
        }
    }

    public void add(E value) {
        Node<E> l = last;
        Node<E> newNode = new Node<>(l, value, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
        modCount++;
    }

    public E get(int index) {
        Objects.checkIndex(index, size);
        Node<E> current = first;
        int count = 0;
        while (count != index) {
            current = current.next;
            count++;
        }
        return current.element;
    }

    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private final int expectedModCount = modCount;
            private int count = 0;
            Node<E> current = first;

            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return count < size;
            }

            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (count == 0) {
                    current = first;
                } else {
                    current = current.next;
                }
                count++;
                return current.element;
            }
        };
    }

}

