package ru.job4j.collection.linkedlisttest;

import java.util.Iterator;

public class TestSimpleLinkedList {
    public static void main(String[] args) {
        SimpleLinkedList<String> list = new SimpleLinkedList<>();
        list.add("Serg");
        list.add("Elena");
        list.add("Sasha");
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
