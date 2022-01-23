package ru.job4j.io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleChat {
    private final String path;
    private final String botAnswers;
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";

    /**
     * @param path       - путь к лог файлу
     * @param botAnswers - файл с ответами бота
     */

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        List<String> log = new ArrayList<>();
        String addLog = "";
        boolean check = true;
        boolean runCheck = true;

        Scanner userInput = new Scanner(System.in);
        List<String> phrases = readPhrases();
        while (check) {
            String message = userInput.nextLine();
            log.add(message);
            if (OUT.equals(message)) {
                String finalChat = "Чат закончил свою работу. By - by.";
                log.add(finalChat);
                runCheck = false;
                check = false;
            }
            if (STOP.equals(message)) {
                runCheck = false;
            }
            if (runCheck) {
                addLog = phrases.get((int) (Math.random() * phrases.size()));
                log.add(addLog);
                System.out.println(addLog);
            }
            if (CONTINUE.equals(message)) {
                runCheck = true;
                addLog = phrases.get((int) (Math.random() * phrases.size()));
                System.out.println(addLog);
                log.add(addLog);
            }
        }
        System.out.println("********************* вывод лога **********************");
        for (int i = 0; i < log.size(); i++) {
            System.out.println(log.get(i));
        }
        System.out.println("********************* end *****************************");
        saveLog(log);
    }

    /**
     * @return
     * @throws IOException
     */
    private List<String> readPhrases()  {
        List<String> phrases = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(this.botAnswers, StandardCharsets.UTF_8))) {
            while (reader.ready()) {
                phrases.add(reader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return phrases;
    }

    private void saveLog(List<String> log) {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(this.path, StandardCharsets.UTF_8, true))) {
            log.forEach(printWriter::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)  {
        ConsoleChat cc = new ConsoleChat(".\\io\\chat.log", ".\\io\\answer.txt");
        cc.run();
    }
}
