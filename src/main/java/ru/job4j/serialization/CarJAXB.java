package ru.job4j.serialization;

import javax.xml.bind.annotation.*;
import java.util.Arrays;

@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarJAXB {
    @XmlAttribute
    private String carBrand;
    @XmlAttribute
    private int countOfDoors;
    @XmlAttribute
    private boolean fourWheelDrive;
    private EngineJAXB engine;
    @XmlElementWrapper(name = "features")
    @XmlElement(name = "feature")
    private String[] features;

    public CarJAXB() {
    }

    public CarJAXB(String carBrand, int countOfDoors, boolean fourWheelDrive, EngineJAXB engine, String... features) {
        this.carBrand = carBrand;
        this.countOfDoors = countOfDoors;
        this.fourWheelDrive = fourWheelDrive;
        this.engine = engine;
        this.features = features;
    }

    @Override
    public String toString() {
        return "Car{"
                + "carBrand='" + carBrand + '\''
                + ", countOfDoors=" + countOfDoors
                + ", fourWheelDrive=" + fourWheelDrive
                + ", engine=" + engine
                + ", feature=" + Arrays.toString(features)
                + '}';
    }
}
