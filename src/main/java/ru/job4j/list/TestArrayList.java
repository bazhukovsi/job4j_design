package ru.job4j.list;

public class TestArrayList {
    public static void main(String[] args) {
        SimpleArrayList<String> simple = new SimpleArrayList<>(0);
        simple.add("Сергей");
        simple.add("Елена");
        simple.add("Саша");
        System.out.println("*************************");
        for (String str : simple) {
            System.out.println(str);
        }
        System.out.println("*************************");
        System.out.println(simple.size());
        System.out.println(simple.get(2));
        simple.set(2, "Маша");
        System.out.println(simple.get(2));
        simple.remove(2);
        for (int i = 0; i < simple.size(); i++) {
            System.out.print(simple.get(i) + " ");
        }
        for (String str : simple) {
            System.out.println(str);
        }
    }
}
