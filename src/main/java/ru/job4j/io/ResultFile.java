package ru.job4j.io;

import java.io.FileOutputStream;

public class ResultFile {
    public static void main(String[] args) {
        String outMultiply = "";
        try (FileOutputStream out = new FileOutputStream("result.txt")) {
            int[][] multiply = new int[10][10];
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    multiply[i][j] = (i + 1) * (j + 1);
                    outMultiply = multiply[i][j] + " ";
                    out.write(outMultiply.getBytes());
                }
                out.write(System.lineSeparator().getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
