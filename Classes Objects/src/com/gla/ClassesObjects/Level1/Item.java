package com.gla.ClassesObjects.Level1;

public class Item {
    int itemCode;
    String itemName;
    double price;

    void setItem(int code, String name, double p) {
        itemCode = code;
        itemName = name;
        price = p;
    }

    void displayItem() {
        System.out.println("Item Code: " + itemCode);
        System.out.println("Item Name: " + itemName);
        System.out.println("Price: " + price);
    }

    void calculateTotal(int quantity) {
        double total = price * quantity;
        System.out.println("Total Cost: " + total);
    }

    public static void main(String[] args) {
        Item i = new Item();
        i.setItem(1, "Pen", 10);
        i.displayItem();
        i.calculateTotal(5);
    }
}

