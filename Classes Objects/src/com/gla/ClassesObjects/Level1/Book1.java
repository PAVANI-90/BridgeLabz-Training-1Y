package com.gla.ClassesObjects.Level1;

public class Book1 {
    String title;
    String author;
    double price;
    boolean available;

    Book1(String t, String a, double p) {
        title = t;
        author = a;
        price = p;
        available = true;
    }

    void borrowBook() {
        if (available) {
            available = false;
            System.out.println("Borrowed");
        } else {
            System.out.println("Not available");
        }
    }

    void display() {
        System.out.println(title);
        System.out.println(author);
        System.out.println(price);
        System.out.println(available);
    }

    public static void main(String[] args) {
        Book1 b = new Book1("Java", "James Gosling", 500);
        b.display();
        b.borrowBook();
        b.display();

    }
}
