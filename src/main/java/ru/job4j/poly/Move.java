package ru.job4j.poly;

public class Move {
    public static void main(String[] args) {
        Plane plane = new Plane();
        Train train = new Train();
        VehicleBus bus = new VehicleBus();
        Vehicle[] vehicles = {plane, train, bus};
        for (Vehicle vehicle : vehicles) {
            vehicle.move();
        }
    }
}
