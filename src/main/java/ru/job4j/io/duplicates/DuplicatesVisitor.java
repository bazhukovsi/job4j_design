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
    List<Path> duplicates;
    Map<FileProperty, List<Path>> filesOfDir = new HashMap<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        FileProperty fileProperty = new FileProperty(attrs.size(), file.toFile().getName());

        if (filesOfDir.containsKey(fileProperty)) {
            duplicates = new ArrayList<>(filesOfDir.get(fileProperty));
            duplicates.add(file);
            filesOfDir.put(fileProperty, duplicates);
        } else {
            List<Path> firstValueFile = new ArrayList<>();
            firstValueFile.add(file);
            filesOfDir.put(fileProperty, firstValueFile);
        }
        return super.visitFile(file, attrs);
    }

    public List<Path> getDuplicates() {
        return duplicates;
    }
}
