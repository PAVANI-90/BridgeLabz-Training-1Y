package com.gla.GenericsAndCollections.Generics;
import java.util.*;

abstract class WarehouseItem {
protected String name;

public WarehouseItem(String name) {
        this.name = name;
    }

@Override
public String toString() {
    return name;
}
}

class Electronics extends WarehouseItem {
public Electronics(String name) {
        super("Electronics: " + name);
        }
        }

class Groceries extends WarehouseItem {
public Groceries(String name) {
        super("**Groceries**: " + name);
        }
        }

class Furniture extends WarehouseItem {
public Furniture(String name) {
        super("**Furniture**: " + name);
        }
        }

class Storage<T extends WarehouseItem> {
private List<T> items = new ArrayList<>();

public void addItem(T item) {
    items.add(item);
}

public void displayItems() {
    System.out.println("**Storage** items:");
    for (T item : items) {
        System.out.println("  " + item);
    }
}

public List<T> getItems() {
    return new ArrayList<>(items);
}
}

public class SmartWarehouseDemo {
    public static void main(String[] args) {
        Storage<Electronics> electronicsStorage = new Storage<>();
        electronicsStorage.addItem(new Electronics("Laptop"));
        electronicsStorage.addItem(new Electronics("Headphones"));
        electronicsStorage.displayItems();

        System.out.println();

        Storage<Groceries> groceriesStorage = new Storage<>();
        groceriesStorage.addItem(new Groceries("Rice"));
        groceriesStorage.addItem(new Groceries("Pulses"));
        groceriesStorage.displayItems();

        System.out.println();

        List<WarehouseItem> allItems = new ArrayList<>();
        allItems.add(new Electronics("Mobile"));
        allItems.add(new Groceries("Oil"));
        allItems.add(new Furniture("Chair"));
        WarehouseUtils.displayAllItems(allItems);
    }
}
