package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<String, String>();

    public Config(final String path) {
        this.path = path;
    }

    /**
     * Метод с проверкой на
     * - пустые строки в файле
     * - наличие комментария (#)
     */
    public void load() {
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            while (read.ready()) {
                String temp = read.readLine();
                examination(temp);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void examination(String temp) {
        String[] strings = temp.split("=");
        String value = "";
        if (!temp.startsWith("#") && !temp.equals("")) {
            if (temp.startsWith("=") || temp.endsWith("=") || !temp.contains("=") || temp.contains("==")) {
                throw new IllegalArgumentException();
            }
            if (strings.length > 2) {
                value = temp.substring(temp.indexOf("=") + 1);
            } else {
                value = strings[1];
            }
            if (!("null".equals(value))) {
                values.put(strings[0], value);
            }
        }
    }

    public String value(String key) {
        return values.get(key);
    }

    public static void main(String[] args) {
        Config config = new Config("./data/pair_no_value_null.properties");
        config.load();
        System.out.println(config.value("name"));
    }
}
