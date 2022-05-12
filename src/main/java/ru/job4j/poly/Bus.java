package ru.job4j.poly;

public class Bus implements Transport, Vehicle {

    @Override
    public void move() {
        System.out.println("Bus rides");
    }

    @Override
    public void drive() {
    }

    @Override
    public void passengers(int count) {
    }

    @Override
    public int cost(int fuel) {
        return 0;
    }
}
