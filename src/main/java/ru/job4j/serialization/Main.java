package ru.job4j.serialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) {
        Car car = new Car("Seat", 5, true,
                new Engine("TFSI"), new String[] {"Red", "TVSet", "GPS"});
        /**
         * Преобразование класса Car в строку
         */
        Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(car));
        String carText = gson.toJson(car);
        System.out.println(carText);
        /**
         * Модифицируем JSON строку
         */
        String carJson =
                "{"
                        + "\"carBrand\":Seat,"
                        + "\"countOfDoors\":5,"
                        + "\"fourWheelDrive\":true,"
                        + "\"engine\":"
                        + "{"
                        + "\"type\":\"TFSI\""
                        + "},"
                        + "\"feature\":"
                        + "[\"Red\",\"TVSet\",\"GPS\"]"
                        + "}";

        Car carMod = gson.fromJson(carJson, Car.class);
        System.out.println(carMod);
    }
}

