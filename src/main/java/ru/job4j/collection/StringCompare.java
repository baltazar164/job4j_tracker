package ru.job4j.collection;

import java.util.Comparator;

import static java.lang.reflect.Array.getChar;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int rsl = 0;
        int lim = Math.min(left.length(), right.length());
        for (int i = 0; i < lim; i++) {
            rsl = Character.compare(left.charAt(i), right.charAt(i));
            if (rsl != 0) {
                return rsl;
            }
        }
        return Integer.compare(left.length(), right.length());
    }
}