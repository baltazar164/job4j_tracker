package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] deps1 = o1.split("/");
        String[] deps2 = o2.split("/");
        int rsl = deps1[0].compareTo(deps2[0]);
        return rsl == 0 ? o1.compareTo(o2) : o2.compareTo(o1);
    }
}