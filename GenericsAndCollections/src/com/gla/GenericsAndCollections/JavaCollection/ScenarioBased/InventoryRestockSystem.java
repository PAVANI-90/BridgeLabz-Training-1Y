package com.gla.GenericsAndCollections.JavaCollection.ScenarioBased;
import java.util.*;
class Product {
private String name;
private double price;
private int stock;

public Product(String name, double price, int stock) {
    this.name  = name;
    this.price = price;
    this.stock = stock;
}

public String getName()  { return name; }
public double getPrice() { return price; }
public int getStock()    { return stock; }

public void setStock(int stock) {
    this.stock = stock;
}

public void addStock(int qty) {
    this.stock += qty;
}

public void reduceStock(int qty) {
    this.stock -= qty;
    if (this.stock < 0) this.stock = 0;
}

@Override
public String toString() {
    return "Product{" + name + ", price=" + price + ", stock=" + stock + "}";
}
}
public class InventoryRestockSystem {
    private Set<String> productNames;

    private List<Product> products;

    private Queue<Product> restockQueue;

    private Stack<Product> restockedStack;

    private int lowStockThreshold = 5;

    private int restockAmount = 10;

    public InventoryRestockSystem() {
        this.productNames   = new HashSet<>();
        this.products       = new ArrayList<>();
        this.restockQueue   = new LinkedList<>();
        this.restockedStack = new Stack<>();
    }

    public boolean addProduct(Product p) {
        if (productNames.add(p.getName())) {
            products.add(p);
            System.out.println("Added product: " + p);
            return true;
        } else {
            System.out.println("Duplicate product ignored: " + p.getName());
            return false;
        }
    }

    public Product findProduct(String name) {
        for (Product p : products) {
            if (p.getName().equalsIgnoreCase(name)) return p;
        }
        return null;
    }


    public void enqueueLowStockProducts() {
        System.out.println("\n Checking for low-stock products (<= " + lowStockThreshold + ") ");
        for (Product p : products) {
            if (p.getStock() <= lowStockThreshold) {
                restockQueue.add(p);
                System.out.println("Enqueued for restock: " + p);
            }
        }
    }

    public void processRestockQueue() {
        System.out.println("\nProcessing restock queue ");
        while (!restockQueue.isEmpty()) {
            Product p = restockQueue.poll();
            System.out.println("Restocking: " + p.getName() +
                    " (+" + restockAmount + ")");
            p.addStock(restockAmount);
            System.out.println("New stock: " + p.getStock());
            restockedStack.push(p);
        }
    }

    public void undoLastRestock() {
        if (restockedStack.isEmpty()) {
            System.out.println("\nNo restock operation to undo.");
            return;
        }
        Product p = restockedStack.pop();
        System.out.println("\nUndoing last restock for: " + p.getName());
        p.reduceStock(restockAmount);
        System.out.println("Stock after undo: " + p.getStock());
    }

    public void printInventory() {
        System.out.println("\n Current Inventory ");
        for (Product p : products) {
            System.out.println(p);
        }
    }

    public static void main(String[] args) {
        InventoryRestockSystem system = new InventoryRestockSystem();

        system.addProduct(new Product("Milk", 50.0, 3));
        system.addProduct(new Product("Bread", 30.0, 10));
        system.addProduct(new Product("Eggs", 6.0, 2));
        system.addProduct(new Product("Milk", 55.0, 4));

        system.printInventory();

        system.enqueueLowStockProducts();

        system.processRestockQueue();
        system.printInventory();

        system.undoLastRestock();
        system.printInventory();
    }
}
