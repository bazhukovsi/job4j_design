package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LogFilter {
    public static List<String> filter(String file) {
        List<String> output = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            for (String line = in.readLine(); line != null; line = in.readLine()) {
                String[] temp = line.split(" ");
                if ("404".equals(temp[temp.length - 2])) {
                    output.add(line);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return output;
    }

    public static void save(List<String> log, String file) {
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(file)
                ))) {
            for (String strLog : log) {
                out.println(strLog);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        List<String> log = filter("log.txt");
        for (String out : log) {
            System.out.println(out);
        }
        List<String> logFile = filter("log.txt");
        save(logFile, "404.txt");
    }
}
