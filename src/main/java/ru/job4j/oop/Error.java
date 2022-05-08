package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void show() {
        System.out.println(this.active);
        System.out.println(this.status);
        System.out.println(this.message);
    }

    public static void main(String[] args) {
        Error empty = new Error();
        Error criticError = new Error(true, 1, "Need immediate action");
        Error oldError = new Error(false, 19, "Solved");

        empty.show();
        criticError.show();
        oldError.show();
    }
}
