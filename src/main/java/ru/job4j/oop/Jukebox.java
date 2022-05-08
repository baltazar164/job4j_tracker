package ru.job4j.oop;

public class Jukebox {
    public String music(int position) {
        return switch (position) {
            case 1 -> "Пусть бегут неуклюже";
            case 2 -> "Спокойной ночи";
            default -> "Песня не найдена";
        };
    }

    public static void main(String[] args) {
        Jukebox song = new Jukebox();
        System.out.println(song.music(1));
        System.out.println(song.music(2));
        System.out.println(song.music(3));
    }
}
