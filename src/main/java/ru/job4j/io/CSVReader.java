package ru.job4j.io;

public class CSVReader {
    public static void handle(ArgsName argsName) throws Exception {
    }

    /**
     * метод для валидации параметров метода handle
     * @param args - -path, -delimiter, -out (stdout или путь), -filter(поля для отбора столбцов)
     */
    public static void validateScanner(String[] args) {
        if (args.length != 4) {
            throw new IllegalArgumentException("Неправильное количество параметров метода.");
        }

    }

    public static void main(String[] args) {
        validateScanner(args);
    }
}
