package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    List<Path> duplicates = new ArrayList<>();
    Map<FileProperty, Path> filesOfDir = new HashMap<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (file.toFile().isFile()) {
            FileProperty fileProperty = new FileProperty(file.toFile().length(), file.getFileName().toString());
            if (filesOfDir.containsKey(fileProperty)) {
                duplicates.add(file.toAbsolutePath());
            } else {
                filesOfDir.put(fileProperty, file.getFileName());
            }
            System.out.println(file.toAbsolutePath());
        }

        return FileVisitResult.CONTINUE;
    }

    public List<Path> getDuplicates() {
        return duplicates;
    }

}
