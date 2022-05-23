package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ItemDescByNameTest {

    @Test
    public void compare() {
        List<Item> actual = new ArrayList<>();
        actual.add(new Item("Ted"));
        actual.add(new Item("Alex"));
        actual.add(new Item("Devid"));
        List<Item> expected = new ArrayList<>();
        expected.add(new Item("Ted"));
        expected.add(new Item("Devid"));
        expected.add(new Item("Alex"));
        Collections.sort(actual, new ItemDescByName());
        assertThat(expected, is(actual));
    }
}