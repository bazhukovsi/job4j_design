package ru.job4j.map;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class TestUser {
    public static void main(String[] args) {
        Map<User, Object> users = new HashMap<>();
        User user1 = new User("Sergey", 1, new GregorianCalendar(1970, 10, 6));
        User user2 = new User("Sergey", 1, new GregorianCalendar(1970, 10, 6));
        users.put(user1, new Object());
        users.put(user2, new Object());
        for (Map.Entry<User, Object> printUsers : users.entrySet()) {
            System.out.println("Key: " + printUsers.getKey() + " - Value: " + printUsers.getValue());
        }
    }
}
