package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
                if (!temp.startsWith("#") && !temp.equals("")) {
                    String[] addMap = temp.split("=");
                    values.put(addMap[0], addMap[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String value(String key) {
        String output = "";
        for (Map.Entry<String, String> pair : values.entrySet()) {
            if (pair.getKey().equals(key)) {
                output = pair.getValue();
                return output;
            }
        }
        throw new IllegalArgumentException();
    }

    public static void main(String[] args) {
        Config config = new Config("./data/pair_without_comment.properties");
        config.load();
        System.out.println(config.value("name"));
    }
}
