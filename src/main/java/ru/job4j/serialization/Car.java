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

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public int getCountOfDoors() {
        return countOfDoors;
    }

    public void setCountOfDoors(int countOfDoors) {
        this.countOfDoors = countOfDoors;
    }

    public boolean isFourWheelDrive() {
        return fourWheelDrive;
    }

    public void setFourWheelDrive(boolean fourWheelDrive) {
        this.fourWheelDrive = fourWheelDrive;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String[] getFeature() {
        return feature;
    }

    public void setFeature(String[] feature) {
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
