package ru.job4j.io;

import java.io.File;

public class Dir {
    public static void main(String[] args) {
        if (args.length != 2) {
            throw new IllegalArgumentException("Root folder or extension is null. "
                    + "Usage java -jar dir.jar ROOT_FOLDER EXTENSION_FILE.");
        }
        File file = new File(args[0]);
        String ext = args[1];
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s", file.getAbsoluteFile()));
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(String.format("Not directory %s", file.getAbsoluteFile()));
        }
        for (File subfile : file.listFiles()) {
            if (subfile.isFile()) {
                System.out.println(subfile.getName() + " : " + subfile.length());
            }
        }
    }
}
