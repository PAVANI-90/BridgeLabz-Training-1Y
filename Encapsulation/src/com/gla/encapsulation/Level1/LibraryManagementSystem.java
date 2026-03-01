package com.gla.encapsulation.Level1;
import java.util.*;

// Reservable interface
interface Reservable {
    boolean reserveItem(String borrowerId);
    boolean checkAvailability();
}

// Abstract LibraryItem class with encapsulation
abstract class LibraryItem {
    private int itemId;
    private String title;
    private String author;
    protected boolean isAvailable = true;
    private String currentBorrower = null;

    public LibraryItem(int itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    // Encapsulation: getters/setters (limited borrower access)
    public int getItemId() { return itemId; }
    public void setItemId(int itemId) { this.itemId = itemId; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    public boolean isAvailable() { return isAvailable; }
    public String getCurrentBorrower() { return currentBorrower != null ? currentBorrower : "None"; }

    // Abstract loan duration
    public abstract int getLoanDuration();

    // Concrete details method
    public void getItemDetails() {
        System.out.printf("ID: %d, %s by %s | Available: %s | Duration: %d days | Borrower: %s%n",
                itemId, title, author, isAvailable ? "Yes" : "No",
                getLoanDuration(), getCurrentBorrower());
    }

    // Protected method for subclasses to update status
    protected void setBorrowed(String borrowerId) {
        this.isAvailable = false;
        this.currentBorrower = borrowerId;
    }

    protected void setReturned() {
        this.isAvailable = true;
        this.currentBorrower = null;
    }
}

// Book subclass (reservable)
class Book extends LibraryItem implements Reservable {
    public Book(int itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 14;
    }

    @Override
    public boolean reserveItem(String borrowerId) {
        if (checkAvailability()) {
            setBorrowed(borrowerId);
            return true;
        }
        return false;
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable();
    }
}

// Magazine subclass (reservable)
class Magazine extends LibraryItem implements Reservable {
    public Magazine(int itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 7;
    }

    @Override
    public boolean reserveItem(String borrowerId) {
        if (checkAvailability()) {
            setBorrowed(borrowerId);
            return true;
        }
        return false;
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable();
    }
}

// DVD subclass (non-reservable)
class DVD extends LibraryItem {
    public DVD(int itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 3;
    }
}

// Main class - polymorphism demo
public class LibraryManagementSystem {
    public static void main(String[] args) {
        // List of LibraryItem references
        List<LibraryItem> items = new ArrayList<>();

        items.add(new Book(1, "Java Programming", "James Gosling"));
        items.add(new Magazine(2, "Tech Weekly", "Editorial Team"));
        items.add(new DVD(3, "Java Tutorial", "Oracle"));
        items.add(new Book(4, "Design Patterns", "Gang of Four"));
        items.add(new Magazine(5, "Science Today", "Science Staff"));

        System.out.println("Library Management System\n");

        // Demo reservation (polymorphic calls)
        System.out.println(" Initial Status ");
        for (LibraryItem item : items) {
            item.getItemDetails();
        }

        System.out.println("\nReserving Items");
        if (items.get(0) instanceof Reservable) {
            ((Reservable) items.get(0)).reserveItem("BORR001");
        }
        if (items.get(1) instanceof Reservable) {
            ((Reservable) items.get(1)).reserveItem("BORR002");
        }

        System.out.println("\nUpdated Status");
        for (LibraryItem item : items) {
            item.getItemDetails();
        }
    }
}

