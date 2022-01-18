package ru.job4j.io;

import java.io.*;

public class Analizy {
    String csvOut = "";
    boolean checkError = true;
    boolean checkWork = false;

    public void unavailable(String source, String target) {
        try (BufferedReader reader = new BufferedReader(new FileReader(source));
             BufferedWriter writer = new BufferedWriter(new FileWriter(target))) {
            while (reader.ready()) {
                String[] pairLog = reader.readLine().split(" ");
                if ((pairLog[0].equals("400") || pairLog[0].equals("500")) && checkError) {
                    csvOut += pairLog[1].concat(";");
                    checkError = false;
                    checkWork = true;
                }
                if ((pairLog[0].equals("200") || pairLog[0].equals("300")) && checkWork) {
                    checkError = true;
                    checkWork = false;
                    csvOut += pairLog[1].concat(";");
                    System.out.println(csvOut);
                    writer.write(csvOut);
                    writer.write(System.lineSeparator());
                    csvOut = "";
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analizy analizServerLog = new Analizy();
        analizServerLog.unavailable("io/server.log", "io/unavailable.csv");
    }
}
