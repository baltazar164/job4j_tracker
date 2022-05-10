package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int y) {
        return y - x;
    }

    public int multiply(int a) {
        return x * a;
    }

    public int divide(int y) {
        return y / x;
    }

    public int sumAllOperation(int y) {
        return sum(y) + minus(y) + this.multiply(y) + this.divide(y);
    }

    public static void main(String[] args) {
        int y = 10;
        System.out.println(sum(y));
        System.out.println(minus(y));
        Calculator operations = new Calculator();
        System.out.println(operations.multiply(y));
        System.out.println(operations.divide(y));
        System.out.println(operations.sumAllOperation(y));
    }
}