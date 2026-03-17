package com.gla.JavaPackage;

public class Book {


    public String title;
    public String author;

    public Book(String t, String a) {
        title = t;
        author = a;
    }

    public void display() {
        System.out.println("Book: " + title + " by " + author);
    }
}