package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;

public class Search {
    public static void main(String[] args) throws IOException {
        validateSearch(args);
        Path start = Paths.get(args[0]);
        List<Path> out = search(start, p -> p.toFile().getName().endsWith(args[1]));
        for (Path path : out) {
            System.out.println(path);
        }
    }

    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }

    private static String[] validateSearch(String[] args) {
        if (args.length != 2) {
            throw new IllegalArgumentException("Неправильное количество аргументов. "
                    + "Используй  java -jar search.jar ROOT_FOLDER FIND_EXTENSION.");
        }
        Path start = Paths.get(args[0]);
        if (!start.toFile().isDirectory()) {
            throw new IllegalArgumentException(String.format("ROOT_FOLDER is not directory %s",
                    start.toFile().getAbsoluteFile()));
        }
        return args;
    }
}

