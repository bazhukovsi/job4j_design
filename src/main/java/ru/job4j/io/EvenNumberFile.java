package ru.job4j.io;

import java.awt.*;
import java.io.FileInputStream;

public class EvenNumberFile {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("even.txt")) {
            StringBuilder text = new StringBuilder();
            while (in.available() > 0) {
                text.append((char) in.read());
            }
            String[] out = text.toString().split(System.lineSeparator());
            for (int i = 0; i < out.length; i++) {
                if (Integer.parseInt(out[i]) % 2 == 0) {
                    System.out.println(out[i]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
