package ru.job4j.io;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ConfigTest {

    @Test
    public void whenPairWithoutComment() {
        String path = "./data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name"), is("Bazhukov"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenPairNotKey() {
        String path = "./data/pair_no_key.properties";
        Config config = new Config(path);
        config.load();
        config.value("name");
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenPairNotValue() {
        String path = "./data/pair_no_value.properties";
        Config config = new Config(path);
        config.load();
        config.value("name");
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenPairmManyEqually() {
        String path = "./data/pair_many_equally.properties";
        Config config = new Config(path);
        config.load();
        config.value("name");
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenPairNoEqually() {
        String path = "./data/pair_no_equally.properties";
        Config config = new Config(path);
        config.load();
        config.value("name");
    }

}