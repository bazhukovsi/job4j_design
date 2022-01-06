package ru.job4j.serialization;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "engine")
@XmlAccessorType(XmlAccessType.FIELD)
public class EngineJAXB {
    @XmlAttribute
    private String type;

    public EngineJAXB() {
    }

    public EngineJAXB(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Engine{"
                + "type='" + type + '\''
                + '}';
    }
}
