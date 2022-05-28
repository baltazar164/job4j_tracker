package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        if (left == right) {
            return 0;
        }
        left = left.substring(0, left.indexOf('.'));
        right = right.substring(0, right.indexOf('.'));
        int leftNum = Integer.parseInt(left);
        int rightNum = Integer.parseInt(right);
        return Integer.compare(leftNum, rightNum);
    }
}