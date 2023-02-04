package ru.job4j.csvreader;

import ru.job4j.io.ArgsName;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVReader {
    /**
     * Управление выборкой и фильтрацией записей
     *
     * @param argsName
     */
    public static void handle(ArgsName argsName) throws FileNotFoundException {
        String fileInput = argsName.get("path");
        String delimiter = argsName.get("delimiter");
        String destination = argsName.get("out");
        String filter = argsName.get("filter");
        List<String> dataFromInputFile = readFile(fileInput);
        writeFilteredData(dataFromInputFile, filter, destination, delimiter);
    }

    /**
     * indexFields - список индексов полей для фильтрации
     * fields - все поля исходного файла для фильтрации
     *
     * @param dataFromInputFile - данные
     * @param filter            - поля для вывода(записи в файл)
     * @param destination       - место назначения для фильтрации
     * @param delimiter         - разделитель
     */

    private static void writeFilteredData(List<String> dataFromInputFile, String filter,
                                          String destination, String delimiter) throws FileNotFoundException {
        List<Integer> indexFields = new ArrayList<>();
        String[] argsFields = filter.split(",");
        String[] fields = dataFromInputFile.get(0).split(delimiter);
        for (int i = 0; i < argsFields.length; i++) {
            for (int j = 0; j < fields.length; j++) {
                if (argsFields[i].trim().equals(fields[j].trim())) {
                    indexFields.add(j);
                }
            }
        }
        String[] temp;
        String output = "";
        StringBuilder builderOutput = new StringBuilder();
        for (String str : dataFromInputFile) {
            temp = str.split(delimiter);
            for (int i = 0; i < indexFields.size(); i++) {
                output += temp[indexFields.get(i)] + delimiter;
            }
            builderOutput.append(output.substring(0, output.length() - 1)).append(System.lineSeparator());
            output = "";
        }

        /**
         * Вывод на консоль или запись в файл
         */

        if (destination.equals("stdout")) {
            System.out.println(builderOutput);
        } else {
            try (PrintWriter printWriter = new PrintWriter(new FileWriter(destination))) {
                printWriter.write(builderOutput.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static List<String> readFile(String path) {
        List<String> list = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(path))) {
            while (scanner.hasNext()) {
                list.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * Валидация параметров командной строки
     * наличие -path=file.csv с данными для вывода(записи) и фильтрации
     * наличие файла для вывода, если для вывода не указан stdout
     *
     * @param argsName
     */

    private static void validation(ArgsName argsName) {
        Path fileInput = Path.of(argsName.get("path"));
        if (!Files.exists(fileInput)) {
            throw new IllegalArgumentException("File for load data not found.");
        }
        if (!"stdout".equals(argsName.get("out"))) {
            Path fileOutput = Path.of(argsName.get("out"));
            if (!Files.exists(fileOutput)) {
                throw new IllegalArgumentException("File for save data not found.");
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        if (args.length != 4) {
            throw new IllegalArgumentException(System.lineSeparator() + "Неправильное количество аргументов. " + System.lineSeparator()
                    + "Используй  параметры -path=file.csv -delimiter=;  -out=stdout -filter=name,age" + System.lineSeparator()
                    + "параметр out - stdout или указание файла для вывода" + System.lineSeparator()
                    + "-filter - поля для вывода или записи в файл");
        }
        ArgsName argsName = ArgsName.of(args);
        validation(argsName);
        handle(argsName);
    }
}
