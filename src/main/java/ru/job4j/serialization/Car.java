package ru.job4j.serialization;

import java.util.Arrays;

public class Car {
    private String carBrand;
    private int countOfDoors;
    private boolean fourWheelDrive;
    private Engine engine;
    private String[] feature;

    public Car(String carBrand, int countOfDoors, boolean fourWheelDrive, Engine engine, String[] feature) {
        this.carBrand = carBrand;
        this.countOfDoors = countOfDoors;
        this.fourWheelDrive = fourWheelDrive;
        this.engine = engine;
        this.feature = feature;
    }

    @Override
    public String toString() {
        return "Car{"
                + "carBrand='" + carBrand + '\''
                + ", countOfDoors=" + countOfDoors
                + ", fourWheelDrive=" + fourWheelDrive
                + ", engine=" + engine
                + ", feature=" + Arrays.toString(feature)
                + '}';
    }
}
