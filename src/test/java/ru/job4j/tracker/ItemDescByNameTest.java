package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

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
        actual.sort(new ItemDescByName());
        assertThat(expected, is(actual));
    }
}