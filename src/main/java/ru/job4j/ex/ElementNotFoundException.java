package ru.job4j.ex;

public class ElementNotFoundException extends java.lang.Exception {
    public static void main(String[] args) {
        try {
            FindEl.indexOf(new String[]{"first", "second"}, "third");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
