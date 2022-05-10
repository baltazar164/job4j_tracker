package ru.job4j.max;

public class Reduce {
    private int[] array;

    public void to(int[] numbers) {
        array = numbers;
    }

    public void print() {
        for (int index = 0; index < array.length; index++) {
            System.out.println(array[index]);
        }
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3};
        Reduce reduce = new Reduce();
        reduce.to(numbers);
        reduce.print();
    }
}