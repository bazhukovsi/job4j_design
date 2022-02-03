package ru.job4j.set;

import java.util.Iterator;

public class TestSet {
    public static void main(String[] args) {
        SimpleSet<String> simpleSet = new SimpleSet<>();
        simpleSet.add("Serg");
        simpleSet.add("Elena");
        simpleSet.add("Serg");
        simpleSet.add("Sasha");
        simpleSet.add("Elena");
        Iterator iterator = simpleSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
