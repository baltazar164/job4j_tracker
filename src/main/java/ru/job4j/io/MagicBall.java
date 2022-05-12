package ru.job4j.io;
import java.util.Scanner;
import java.util.Random;

public class MagicBall {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Я великий Оракул. Что ты хочешь узнать? ");
        String question = input.nextLine();
        String answer = switch (new Random().nextInt(3)) {
            case 0 -> "Да";
            case 1 -> "Нет";
            default -> "Может быть";
        };
        System.out.print(answer);
    }

}
