package ru.job4j.collection.list;

public class TestSimpleLinkedList {
    public static void main(String[] args) {
        SimpleLinkedList<String> list = new SimpleLinkedList<>();
        list.add("Serg");
        list.add("Elena");
        list.add("Sasha");
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println("-----------------------------------------");
        for (String el : list) {
            System.out.println(el);
        }
    }
}
