package com.gla.GenericsAndCollections.JavaCollection.ScenarioBased;
import java.util.*;
class Book {
    private String id;
    private String title;
    private String author;
    private boolean issued;

    public Book(String id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.issued = false;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isIssued() { return issued; }
    public void setIssued(boolean issued) { this.issued = issued; }

    @Override
    public String toString() {
        return "Book{" + id + ", " + title + ", " + author + ", issued=" + issued + "}";
    }
}
public class LibraryManagementSystem {
    private List<Book> books;
    private Set<String> memberIds;
    private Queue<Book> issueQueue;
    private Stack<Book> returnedStack;

    public LibraryManagementSystem() {
        this.books = new ArrayList<>();
        this.memberIds = new HashSet<>();
        this.issueQueue = new LinkedList<>();
        this.returnedStack = new Stack<>();
    }

    public void addBook(Book b) {
        books.add(b);
        System.out.println("Added book: " + b);
    }

    public boolean registerMember(String memberId) {
        if (memberIds.add(memberId)) {
            System.out.println("Registered member: " + memberId);
            return true;
        } else {
            System.out.println("Duplicate member ignored: " + memberId);
            return false;
        }
    }

    public Book findBookById(String id) {
        for (Book b : books) {
            if (b.getId().equals(id)) return b;
        }
        return null;
    }

    public void requestIssue(String memberId, String bookId) {
        if (!memberIds.contains(memberId)) {
            System.out.println("Issue rejected, unregistered member: " + memberId);
            return;
        }
        Book b = findBookById(bookId);
        if (b == null) {
            System.out.println("Book not found: " + bookId);
            return;
        }
        if (b.isIssued()) {
            System.out.println("Book already issued: " + b);
            return;
        }
        issueQueue.add(b);
        System.out.println("Book added to issue queue for member " + memberId + ": " + b);
    }

    public void processNextIssue() {
        if (issueQueue.isEmpty()) {
            System.out.println("No books waiting to be issued.");
            return;
        }
        Book b = issueQueue.poll();
        if (b.isIssued()) {
            System.out.println("Book already issued, skipping: " + b);
            return;
        }
        b.setIssued(true);
        System.out.println("Book issued: " + b);
    }

    public void returnBook(String bookId) {
        Book b = findBookById(bookId);
        if (b == null) {
            System.out.println("Book not found: " + bookId);
            return;
        }
        if (!b.isIssued()) {
            System.out.println("Book is not currently issued: " + b);
            return;
        }
        b.setIssued(false);
        returnedStack.push(b);
        System.out.println("Book returned and pushed to stack: " + b);
    }

    public void reissueLastReturned(String memberId) {
        if (!memberIds.contains(memberId)) {
            System.out.println("Re-issue rejected, unregistered member: " + memberId);
            return;
        }
        if (returnedStack.isEmpty()) {
            System.out.println("No recently returned books to re-issue.");
            return;
        }
        Book b = returnedStack.pop();
        if (b.isIssued()) {
            System.out.println("Book already issued, cannot re-issue: " + b);
            return;
        }
        b.setIssued(true);
        System.out.println("Re-issued last returned book to member " + memberId + ": " + b);
    }

    public void printSummary() {
        System.out.println("\n Library Summary");
        System.out.println("Total books: " + books.size());
        System.out.println("Registered members: " + memberIds.size());
        System.out.println("Books in issue queue: " + issueQueue.size());
        System.out.println("Recently returned stack size: " + returnedStack.size());

        System.out.println("\nAll books:");
        for (Book b : books) {
            System.out.println("  " + b);
        }
    }

    public static void main(String[] args) {
        LibraryManagementSystem system = new LibraryManagementSystem();

        system.addBook(new Book("B001", "Effective Java", "Joshua Bloch"));
        system.addBook(new Book("B002", "Clean Code", "Robert C. Martin"));
        system.addBook(new Book("B003", "Java Concurrency in Practice", "Brian Goetz"));

        system.registerMember("M001");
        system.registerMember("M002");
        system.registerMember("M001");

        system.requestIssue("M001", "B001");
        system.requestIssue("M002", "B002");
        system.requestIssue("M003", "B003");

        system.processNextIssue();
        system.processNextIssue();
        system.processNextIssue();

        system.returnBook("B001");
        system.returnBook("B002");

        system.reissueLastReturned("M001");
        system.reissueLastReturned("M002");

        system.printSummary();
    }
}
