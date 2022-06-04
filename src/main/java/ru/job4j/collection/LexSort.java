package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        left = left.split("\\.")[0];
        right = right.split("\\.")[0];
        int leftNum = Integer.parseInt(left);
        int rightNum = Integer.parseInt(right);
        return Integer.compare(leftNum, rightNum);
    }
}