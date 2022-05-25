package ru.job4j.tracker;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ItemAscByNameTest {

    @Test
    public void compare() {
        List<Item> actual = new ArrayList<>();
        actual.add(new Item("Ted"));
        actual.add(new Item("Alex"));
        actual.add(new Item("Devid"));
        List<Item> expected = new ArrayList<>();
        expected.add(new Item("Alex"));
        expected.add(new Item("Devid"));
        expected.add(new Item("Ted"));
        actual.sort(new ItemAscByName());
        assertThat(expected, is(actual));
    }
}