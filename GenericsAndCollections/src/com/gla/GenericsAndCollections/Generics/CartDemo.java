package com.gla.GenericsAndCollections.Generics;
import java.util.*;
class ElectronicsItem {
    private String name;

    public ElectronicsItem(String name) {
        this.name = name;
    }

    public String toString() {
        return "Electronics: " + name;
    }
}

class Clothing {
    private String name;

    public Clothing(String name) {
        this.name = name;
    }

    public String toString() {
        return "Clothing: " + name;
    }
}

class Book {
    private String name;

    public Book(String name) {
        this.name = name;
    }

    public String toString() {
        return "Book: " + name;
    }
}

// Generic Cart Class
class Cart<T> {
    private List<T> items = new ArrayList<>();

    // Add item
    public void addItem(T item) {
        items.add(item);
    }

    // Remove item
    public void removeItem(T item) {
        items.remove(item);
    }


    public void displayItems() {
        if (items.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }

        for (T item : items) {
            System.out.println(item);
        }
    }
}

public class CartDemo {
    public static void main(String[] args) {

        // Electronics Cart
        Cart<Electronics> electronicsCart = new Cart<>();
        electronicsCart.addItem(new Electronics("Laptop"));
        electronicsCart.addItem(new Electronics("Mobile"));

        System.out.println("Electronics Cart:");
        electronicsCart.displayItems();

        // Clothing Cart
        Cart<Clothing> clothingCart = new Cart<>();
        clothingCart.addItem(new Clothing("T-Shirt"));
        clothingCart.addItem(new Clothing("Jeans"));

        System.out.println("\nClothing Cart:");
        clothingCart.displayItems();


        Cart<Book> bookCart = new Cart<>();
        bookCart.addItem(new Book("Java Programming"));

        System.out.println("\nBook Cart:");
        bookCart.displayItems();
    }

}
