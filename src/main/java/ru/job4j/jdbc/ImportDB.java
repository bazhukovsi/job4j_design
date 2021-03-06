package ru.job4j.jdbc;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ImportDB {
    private Properties cfg;
    private String dump;

    public ImportDB(Properties cfg, String dump) {
        this.cfg = cfg;
        this.dump = dump;
    }

    public List<User> load() throws IOException {
        List<User> users = new ArrayList<>();
        int count = 0;
        try (BufferedReader rd = new BufferedReader(new FileReader(dump))) {
            while (rd.ready()) {
                count++;
                String user = rd.readLine();
                String[] userDb = user.split(";", 0);
                if (userDb.length == 2 && !userDb[0].equals("") && !userDb[1].equals("")) {
                    users.add(new User(userDb[0], userDb[1]));
                } else {
                    throw new IllegalArgumentException("Неправильный формат входных данных в строке " + count);
                }
            }
        }
        return users;
    }

    public void save(List<User> users) throws ClassNotFoundException, SQLException {
        Class.forName(cfg.getProperty("jdbc.driver"));
        try (Connection cnt = DriverManager.getConnection(
                cfg.getProperty("jdbc.url"),
                cfg.getProperty("jdbc.username"),
                cfg.getProperty("jdbc.password")
        )) {
            for (User user : users) {
                try (PreparedStatement ps = cnt.prepareStatement(
                        "insert into users (name, email) values (? , ?)")) {
                    ps.setString(1, user.name);
                    ps.setString(2, user.email);
                    ps.execute();
                }
            }
        }
    }

    private static class User {
        String name;
        String email;

        public User(String name, String email) {
            this.name = name;
            this.email = email;
        }
    }

    public static void main(String[] args) throws Exception {
        Properties cfg = new Properties();
        try (FileInputStream in = new FileInputStream("./data/spammer.properties")) {
            cfg.load(in);
        }
        ImportDB db = new ImportDB(cfg, "./dump.txt");
        db.save(db.load());
    }
}

