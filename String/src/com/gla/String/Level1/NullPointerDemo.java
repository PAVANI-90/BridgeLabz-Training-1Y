package com.gla.String.Level1;

public class NullPointerDemo {


    static void generateException() {
        String text = null;
        System.out.println(text.length());
    }


    static void handleException() {
        String text = null;

        try {
            System.out.println(text.length());
        }
        catch (NullPointerException e) {
            System.out.println("NullPointerException handled!");
            System.out.println("You are trying to use a null object.");
        }
    }

    public static void main(String[] args) {


    }
}