package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

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
        for (Map.Entry<String, String> pair : values.entrySet()) {
            System.out.println(pair.getKey() + " : " + pair.getValue());
        }
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public String value(String key) {
        String output = "Нет записи с таким ключом.";
        for (Map.Entry<String, String> pair : values.entrySet()) {
            if (pair.getKey().equals(key)) {
                output = pair.getValue();
                return output;
            }
        }
        throw new IllegalArgumentException();
    }

    public static void main(String[] args) {
        System.out.println(new Config("./data/pair_without_comment.properties"));
        System.out.println();
        System.out.println("=============================================");
        System.out.println();
        Config config = new Config("./data/pair_without_comment.properties");
        config.load();
        System.out.println("==============================================");
        System.out.println(config.value("hibernate.connection.url"));
    }
}
