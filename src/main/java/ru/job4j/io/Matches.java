package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Игра 11.");
        boolean turn = true;
        int count = 11;
        do {
            String player = turn ? "Первый игрок" : "Второй игрок";
            System.out.println(player + " введите число от 1 до 3:");
            int matches = Integer.parseInt(input.nextLine());
            turn = !turn;
            count = count - matches;
            if (count < 1) {
                if (!turn) {
                    System.out.println("Выиграл первый игрок");
                } else {
                    System.out.println("Выиграл второй игрок");
                }
            }
            System.out.println("Осталось спичек: " + count);
        } while (count > 0);

    }
}