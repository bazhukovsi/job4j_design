package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class DuplicatesFinder {
    public static void main(String[] args) throws IOException {
        DuplicatesVisitor visitor = new DuplicatesVisitor();
        Files.walkFileTree(Path.of("c:\\test"), visitor);
        System.out.println("****************** Выведем дубликаты **********************");
        List<Path> out = visitor.getDuplicates();
        for (Path path : out) {
            System.out.println(path.toAbsolutePath());
        }

    }
}
