package com.gla.GenericsAndCollections.Map.ScenarioBased;
import java.util.*;

public class LibraryBookCatalog {
    private Map<String, String> catalog;

    public LibraryBookCatalog() {
        this.catalog = new HashMap<>();
    }

    public void addBook(String isbn, String title) {
        catalog.put(isbn, title);
        System.out.println("Added: " + isbn + " -> " + title);
    }

    public void searchByIsbn(String isbn) {
        String title = catalog.get(isbn);
        if (title == null) {
            System.out.println("Book not found for ISBN: " + isbn);
        } else {
            System.out.println("Found: " + isbn + " -> " + title);
        }
    }

    public void removeBook(String isbn) {
        String removed = catalog.remove(isbn);
        if (removed == null) {
            System.out.println("No book with ISBN: " + isbn);
        } else {
            System.out.println("Removed: " + isbn + " -> " + removed);
        }
    }

    public void printSortedByIsbn() {
        System.out.println("\nBooks sorted by ISBN:");
        Map<String, String> sorted = new TreeMap<>(catalog);
        for (Map.Entry<String, String> e : sorted.entrySet()) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }
    }

    public void searchByTitle(String titlePart) {
        System.out.println("\nSearching by title containing: \"" + titlePart + "\"");
        boolean found = false;
        for (Map.Entry<String, String> e : catalog.entrySet()) {
            if (e.getValue().toLowerCase().contains(titlePart.toLowerCase())) {
                System.out.println(e.getKey() + " -> " + e.getValue());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No book found with title containing: " + titlePart);
        }
    }

    public static void main(String[] args) {
        LibraryBookCatalog lib = new LibraryBookCatalog();

        lib.addBook("978-1234567890", "Java Fundamentals");
        lib.addBook("978-9876543210", "Data Structures in Java");
        lib.addBook("978-1111111111", "Algorithms Made Easy");

        lib.searchByIsbn("978-1234567890");
        lib.searchByIsbn("978-0000000000");

        lib.removeBook("978-1111111111");
        lib.removeBook("978-0000000000");

        lib.printSortedByIsbn();

        lib.searchByTitle("java");
        lib.searchByTitle("python");
    }
}
