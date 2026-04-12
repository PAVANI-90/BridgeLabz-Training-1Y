package com.gla.GenericsAndCollections.JavaCollection.ScenarioBased;
import java.util.*;
class Package {
    private String id;
    private String destination;
    private String status;

    public Package(String id, String destination) {
        this.id = id;
        this.destination = destination;
        this.status = "PENDING";
    }

    public String getId()           { return id; }
    public String getDestination()  { return destination; }
    public String getStatus()       { return status; }
    public void setStatus(String s) { this.status = s; }

    @Override
    public String toString() {
        return "Package{" + id + ", dest=" + destination + ", status=" + status + "}";
    }
}
public class WarehouseDeliverySystem {
    private Queue<Package> pendingQueue;
    private Set<String> packageIds;
    private List<Package> deliveredList;
    private Stack<Package> returnedStack;

    public WarehouseDeliverySystem() {
        this.pendingQueue  = new LinkedList<>();
        this.packageIds    = new HashSet<>();
        this.deliveredList = new ArrayList<>();
        this.returnedStack = new Stack<>();
    }
    public boolean addDeliveryRequest(Package p) {
        if (packageIds.add(p.getId())) {
            pendingQueue.add(p);
            System.out.println("Added delivery request: " + p);
            return true;
        } else {
            System.out.println("Duplicate package ID ignored: " + p.getId());
            return false;
        }
    }
    public void processDeliveries() {
        System.out.println("\nProcessing pending deliveries (FIFO)");
        Random rand = new Random();

        while (!pendingQueue.isEmpty()) {
            Package p = pendingQueue.poll();
            System.out.println("Processing: " + p);

            boolean delivered = rand.nextDouble() < 0.7;
            if (delivered) {
                p.setStatus("DELIVERED");
                deliveredList.add(p);
                System.out.println("   Delivered: " + p.getId());
            } else {
                p.setStatus("RETURNED");
                returnedStack.push(p);
                System.out.println("   Returned: " + p.getId());
            }
        }
    }
    public void undoLastReturn() {
        if (returnedStack.isEmpty()) {
            System.out.println("\nNo returned package to undo.");
            return;
        }
        Package p = returnedStack.pop();
        System.out.println("\nUndoing last return for: " + p.getId());
        p.setStatus("PENDING");
        pendingQueue.add(p);
        System.out.println("Moved back to pending queue: " + p);
    }
    public void printSummary() {
        System.out.println("\nDelivery Summary");
        System.out.println("Total unique packages: " + packageIds.size());
        System.out.println("Delivered: " + deliveredList.size());
        System.out.println("Returned: " + returnedStack.size());
        System.out.println("Pending: " + pendingQueue.size());

        System.out.println("\nDelivered packages:");
        for (Package p : deliveredList) {
            System.out.println("  " + p);
        }

        System.out.println("\nReturned packages (stack top is most recent):");
        for (Package p : returnedStack) {
            System.out.println("  " + p);
        }

        System.out.println("\nPending packages in queue:");
        for (Package p : pendingQueue) {
            System.out.println("  " + p);
        }
    }
    public static void main(String[] args) {
        WarehouseDeliverySystem system = new WarehouseDeliverySystem();
        system.addDeliveryRequest(new Package("PKG001", "Delhi"));
        system.addDeliveryRequest(new Package("PKG002", "Mumbai"));
        system.addDeliveryRequest(new Package("PKG003", "Bangalore"));
        system.addDeliveryRequest(new Package("PKG001", "Duplicate-Delhi"));
        system.processDeliveries();
        system.printSummary();
        system.undoLastReturn();
        system.printSummary();
    }
}
