package ru.job4j.io;

import org.hamcrest.Matchers;
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

    @Test(expected =  IllegalArgumentException.class)
    public void whenPairNotValue() {
        String path = "./data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        config.value("surname");
    }
}