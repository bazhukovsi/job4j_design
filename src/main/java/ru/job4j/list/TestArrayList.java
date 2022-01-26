package ru.job4j.list;

public class TestArrayList {
    public static void main(String[] args) {
        SimpleArrayList<String> simple = new SimpleArrayList<>(10);
        simple.add("Сергей");
        simple.add("Елена");
        System.out.println(simple.size());
        System.out.println(simple.get(1));
    }
}
