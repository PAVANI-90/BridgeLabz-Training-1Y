package com.gla.GenericsAndCollections.Map.ScenarioBased;
import java.util.*;

public class StoreInventoryManager {
    private Map<String, Integer> inventory;

    public StoreInventoryManager() {
        this.inventory = new HashMap<>();
    }

    public void addProduct(String product, int quantity) {
        inventory.put(product, quantity);
        System.out.println("Added/updated product: " + product + " = " + quantity);
    }

    public void sellProduct(String product, int quantitySold) {
        Integer currentQty = inventory.get(product);
        if (currentQty == null) {
            System.out.println("Product not stocked: " + product);
            return;
        }
        int newQty = currentQty - quantitySold;
        if (newQty <= 0) {
            inventory.put(product, 0);
            System.out.println(product + " is now out of stock.");
        } else {
            inventory.put(product, newQty);
            System.out.println("Sold " + quantitySold + " of " + product +
                    ", remaining: " + newQty);
        }
    }

    public void restockProduct(String product, int quantityAdded) {
        int currentQty = inventory.getOrDefault(product, 0);
        int newQty = currentQty + quantityAdded;
        inventory.put(product, newQty);
        System.out.println("Restocked " + product + " by " + quantityAdded +
                ", total: " + newQty);
    }

    public void queryProduct(String product) {
        Integer qty = inventory.get(product);
        if (qty == null) {
            System.out.println(product + " is not stocked.");
        } else if (qty == 0) {
            System.out.println(product + " is out of stock.");
        } else {
            System.out.println(product + " in stock: " + qty);
        }
    }

    public void printOutOfStock() {
        System.out.println("\nOut of stock products:");
        boolean any = false;
        for (Map.Entry<String, Integer> e : inventory.entrySet()) {
            if (e.getValue() == 0) {
                System.out.println(" " + e.getKey());
                any = true;
            }
        }
        if (!any) {
            System.out.println(" None");
        }
    }

    public void printInventory() {
        System.out.println("\nCurrent inventory:");
        for (Map.Entry<String, Integer> e : inventory.entrySet()) {
            System.out.println(" " + e.getKey() + " -> " + e.getValue());
        }
    }

    public static void main(String[] args) {
        StoreInventoryManager store = new StoreInventoryManager();

        store.addProduct("Apples", 50);
        store.addProduct("Bananas", 30);
        store.addProduct("Oranges", 20);

        store.printInventory();

        store.sellProduct("Apples", 10);
        store.sellProduct("Bananas", 35);
        store.sellProduct("Mangoes", 5);

        store.printInventory();

        store.restockProduct("Bananas", 40);
        store.restockProduct("Grapes", 25);

        store.printInventory();

        store.queryProduct("Apples");
        store.queryProduct("Bananas");
        store.queryProduct("Oranges");
        store.queryProduct("Mangoes");

        store.printOutOfStock();
    }
}
