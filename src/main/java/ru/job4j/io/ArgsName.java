package ru.job4j.io;

import java.util.HashMap;
import java.util.Map;

public class ArgsName {
    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        return values.get(key);
    }

    private void parse(String[] args) {
        /* TODO parse args to values. */
        if (args.length == 0) {
            throw new IllegalArgumentException("Нет параметров");
        }
        for (int i = 0; i < args.length; i++) {
            validateEqualsAndPrefix(args[i]);
            String[] param = args[i].split("=", 2);
            if ("".equals(param[1])) {
                throw new IllegalArgumentException("Значение параметра не задано.");
            } else {
                values.put(param[0].substring(1), param[1]);
            }
        }
    }

    private void validateEqualsAndPrefix(String value) {
        if (!value.contains("=") || !value.startsWith("-") || value.startsWith("-=")) {
            throw new IllegalArgumentException("Неправильная сигнатура параметра");
        }
    }

    public static ArgsName of(String[] args) {
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[]{"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));

        ArgsName zip = ArgsName.of(new String[]{"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("out"));
    }
}
