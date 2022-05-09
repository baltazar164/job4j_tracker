package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {
    @Test
    public void when00to20then2() {
        ru.job4j.oop.Point a = new ru.job4j.oop.Point(0, 0);
        ru.job4j.oop.Point b = new ru.job4j.oop.Point(2, 0);
        double out = a.distance(b);
        double expected = 2;
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void whenM1M1to22then4dot24() {
        ru.job4j.oop.Point a = new ru.job4j.oop.Point(-1, -1);
        ru.job4j.oop.Point b = new ru.job4j.oop.Point(2, 2);
        double out = a.distance(b);
        double expected = 4.24;
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when0And4toM3And6then3dot6() {
        ru.job4j.oop.Point a = new ru.job4j.oop.Point(0, 4);
        ru.job4j.oop.Point b = new ru.job4j.oop.Point(-3, 6);
        double out = a.distance(b);
        double expected = 3.6;
        Assert.assertEquals(expected, out, 0.1);
    }

    @Test
    public void when4And3to2And6then2dot3dot6() {
        ru.job4j.oop.Point a = new ru.job4j.oop.Point(4, 3);
        ru.job4j.oop.Point b = new Point(2, 6);
        double out = a.distance(b);
        double expected = 3.6;
        Assert.assertEquals(expected, out, 0.1);
    }

}