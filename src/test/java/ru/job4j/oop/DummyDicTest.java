package ru.job4j.oop;

import junit.framework.TestCase;

public class DummyDicTest extends TestCase {

    public void testEngToRus() {
        String actual = DummyDic.engToRus("Chess");
        String expected = "Unknown word.Chess";
        TestCase.assertEquals(expected, actual);
    }
}