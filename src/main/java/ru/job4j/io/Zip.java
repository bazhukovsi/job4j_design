package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {
    public static void packFiles(List<Path> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (Path source : sources) {
                zip.putNextEntry(new ZipEntry(source.toFile().getAbsolutePath()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(String.valueOf(source)))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        if (args.length != 3) {
            throw new IllegalArgumentException("Неправильное количество аргументов." + System.lineSeparator()
                    + " Usage java -jar pack.jar -d=ROOT_FOLDER -e=EXCLUDE_EXT -o=NAME_ZIP");
        }
        ArgsName zipFile = ArgsName.of(args);
        Path dirZip = Path.of(zipFile.get("d"));
        if (!dirZip.toFile().isDirectory()) {
            throw new IllegalArgumentException("Параметр -d не является директорией. Проверьте параметры.");
        }
        String excludeZip = zipFile.get("e");
        File nameZip = new File(zipFile.get("o"));
        List<Path> sourceZip = Search.search(dirZip, p -> !p.toFile().getName().endsWith(excludeZip));
        Zip.packFiles(sourceZip, nameZip);
    }
}
