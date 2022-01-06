package ru.job4j.serialization;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

public class MainJAXB {
    public static void main(String[] args) throws Exception {
        CarJAXB car = new CarJAXB("Seat", 5, true,
                new EngineJAXB("TFSI"), "Red", "TVSEt", "GPS");
        /**
         * Получаем контекст
         */
        JAXBContext context = JAXBContext.newInstance(CarJAXB.class);
        /**
         * Создаем сериализатор
         */
        Marshaller marshaller = context.createMarshaller();
        /**
         * Указываем, что нам нужно форматирование
         */
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            /**
             * Сериализуем
             */
            marshaller.marshal(car, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        }
        /**
         * Создаем десериализатор
         */
        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            /**
             * Десериализуем
             */
            CarJAXB result = (CarJAXB) unmarshaller.unmarshal(reader);
            System.out.println(result);
        }

    }
}
