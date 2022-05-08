package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {
    @Test
    public void when00to20then2() {
        Point a = new Point(0, 0);
        Point b = new Point(2, 0);
        double out = a.distance(b);
        double expected = 2;
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void whenM1M1to22then4dot24() {
        Point a = new Point(-1, -1);
        Point b = new Point(2, 2);
        double out = a.distance(b);
        double expected = 4.24;
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when0And4toM3And6then3dot6() {
        Point a = new Point(0, 4);
        Point b = new Point(-3, 6);
        double out = a.distance(b);
        double expected = 3.6;
        Assert.assertEquals(expected, out, 0.1);
    }

    @Test
    public void when4And3to2And6then3dot6() {
        Point a = new Point(4, 3);
        Point b = new Point(2, 6);
        double out = a.distance(b);
        double expected = 3.6;
        Assert.assertEquals(expected, out, 0.1);
    }

    @Test
    public void when4And3And2to2And6And4then() {
        Point a = new Point(4, 3, 2);
        Point b = new Point(2, 6, 4);
        double out = a.distance3d(b);
        double expected = 4.1;
        Assert.assertEquals(expected, out, 0.1);
    }

    @Test
    public void when2And3And2to2And6And4then() {
        Point a = new Point(2, 3, 2);
        Point b = new Point(2, 6, 4);
        double out = a.distance3d(b);
        double expected = 3.6;
        Assert.assertEquals(expected, out, 0.1);
    }

}