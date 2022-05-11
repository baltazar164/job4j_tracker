package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book bible = new Book("The Bible", 2100);
        Book pen = new Book("Pitter Pen", 100);
        Book ginies = new Book("Ginies book record", 5500);
        Book code = new Book("Clean code", 700);
        Book[] books = {bible, pen, ginies, code};
        for (Book book:books) {
            System.out.println(book.getName() + " - " + book.getCount());
        }
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (Book book:books) {
            if ("Clean code".equals(book.getName())) {
                System.out.println(book.getName() + " - " + book.getCount());
            }
        }
    }
}
