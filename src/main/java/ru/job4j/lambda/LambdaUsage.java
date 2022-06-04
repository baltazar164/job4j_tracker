package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class LambdaUsage {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("eeeee", "a",  "ccc", "dddd", "bb");
        Comparator<String> comparator = (left, right) -> Integer.compare(right.length(), left.length());
        strings.sort(comparator);
        Consumer<String> print = (s) -> System.out.println(s);
        for (String str : strings) {
            print.accept(str);
        }
    }
}