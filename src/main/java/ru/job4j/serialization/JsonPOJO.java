package ru.job4j.serialization;

import org.json.JSONObject;

public class JsonPOJO {
    public static void main(String[] args) {
        Engine engine = new Engine("V4");
        Car car = new Car("FreeTrack", 5, true, new Engine("V4"),
                new String[]{"JPS", "TvSet"});

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("brand", car.getCarBrand());
        jsonObject.put("doors", car.getCountOfDoors());
        jsonObject.put("fourWheelDrive", car.isFourWheelDrive());
        jsonObject.put("engine", car.getEngine());
        jsonObject.put("futures", car.getFeature());

        System.out.println(jsonObject.toString());
        System.out.println(new JSONObject(car).toString());
    }
}
