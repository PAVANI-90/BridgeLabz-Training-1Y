package com.gla.GenericsAndCollections.Generics;
import java.util.*;

interface BookCategory {
    void category();
}

interface ClothingCategory {
    void category();
}

interface GadgetCategory {
    void category();
}


//  Product Class (Generic with Bounded Type)
class Product<T> {
    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public T getCategory() {
        return category;
    }

    public void showProduct() {
        System.out.println(name + " | Price: " + price);
    }
}


// Product Types
class Book implements BookCategory {
    private String genre;

    public Book(String genre) {
        this.genre = genre;
    }

    public void category() {
        System.out.println("Book Category: " + genre);
    }
}

class Clothing implements ClothingCategory {
    private String type;

    public Clothing(String type) {
        this.type = type;
    }

    public void category() {
        System.out.println("Clothing Category: " + type);
    }
}

class Gadget implements GadgetCategory {
    private String type;

    public Gadget(String type) {
        this.type = type;
    }

    public void category() {
        System.out.println("Gadget Category: " + type);
    }
}


//  Generic Utility Method
class DiscountUtil {

    // Generic method with bounded type
    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double newPrice = product.getPrice() - (product.getPrice() * percentage / 100);
        product.setPrice(newPrice);

        System.out.println("Discount applied: " + percentage + "%");
        product.showProduct();
    }
}

public class OnlineMarketDemo {
    public static void main(String[] args) {

        // Create products
        Product<Book> book = new Product<>("Java Book", 500, new Book("Programming"));
        Product<Clothing> shirt = new Product<>("T-Shirt", 1000, new Clothing("Casual"));
        Product<Gadget> phone = new Product<>("Smartphone", 20000, new Gadget("Electronics"));

        // Show categories
        book.getCategory().category();
        shirt.getCategory().category();
        phone.getCategory().category();

        System.out.println("\n Products ");
        book.showProduct();
        shirt.showProduct();
        phone.showProduct();

        System.out.println("\n Applying Discount ");

        // Generic method usage
        DiscountUtil.applyDiscount(book, 10);
        DiscountUtil.applyDiscount(shirt, 20);
        DiscountUtil.applyDiscount(phone, 5);
    }
}
