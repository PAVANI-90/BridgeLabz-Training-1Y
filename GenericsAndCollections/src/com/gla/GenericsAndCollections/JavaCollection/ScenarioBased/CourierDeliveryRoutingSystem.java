package com.gla.GenericsAndCollections.JavaCollection.ScenarioBased;
import java.util.*;
class Parcel {
    private String id;
    private String destination;
    private int priority;

    public Parcel(String id, String destination, int priority) {
        this.id = id;
        this.destination = destination;
        this.priority = priority;
    }

    public String getId() { return id; }
    public String getDestination() { return destination; }
    public int getPriority() { return priority; }

    @Override
    public String toString() {
        return "Parcel{" + id + ", dest=" + destination + ", priority=" + priority + "}";
    }
}

public class CourierDeliveryRoutingSystem {
    private PriorityQueue<Parcel> priorityParcels;
    private Queue<Parcel> normalParcels;
    private Set<String> assignedIds;
    private List<Parcel> completedDeliveries;

    public CourierDeliveryRoutingSystem() {
        this.priorityParcels = new PriorityQueue<>(
                (p1, p2) -> Integer.compare(p2.getPriority(), p1.getPriority())
        );
        this.normalParcels = new LinkedList<>();
        this.assignedIds = new HashSet<>();
        this.completedDeliveries = new ArrayList<>();
    }

    public boolean addParcel(Parcel p, boolean isHighPriority) {
        if (!assignedIds.add(p.getId())) {
            System.out.println("Duplicate delivery ID ignored: " + p.getId());
            return false;
        }
        if (isHighPriority) {
            priorityParcels.add(p);
            System.out.println("Added HIGH priority parcel: " + p);
        } else {
            normalParcels.add(p);
            System.out.println("Added normal parcel: " + p);
        }
        return true;
    }

    public void assignNextParcel() {
        Parcel p;
        if (!priorityParcels.isEmpty()) {
            p = priorityParcels.poll();
            System.out.println("Assigning HIGH priority delivery: " + p);
        } else if (!normalParcels.isEmpty()) {
            p = normalParcels.poll();
            System.out.println("Assigning normal delivery: " + p);
        } else {
            System.out.println("No pending deliveries.");
            return;
        }
        completeDelivery(p);
    }

    private void completeDelivery(Parcel p) {
        System.out.println("Delivery completed: " + p);
        completedDeliveries.add(p);
    }

    public void printSummary() {
        System.out.println("\n Courier Delivery Summary ");
        System.out.println("Total unique delivery IDs: " + assignedIds.size());
        System.out.println("Completed deliveries: " + completedDeliveries.size());
        System.out.println("Pending high-priority parcels: " + priorityParcels.size());
        System.out.println("Pending normal parcels: " + normalParcels.size());

        System.out.println("\nCompleted deliveries list:");
        for (Parcel p : completedDeliveries) {
            System.out.println("  " + p);
        }
    }

    public static void main(String[] args) {
        CourierDeliveryRoutingSystem system = new CourierDeliveryRoutingSystem();

        system.addParcel(new Parcel("D001", "Delhi", 5), true);
        system.addParcel(new Parcel("D002", "Mumbai", 2), false);
        system.addParcel(new Parcel("D003", "Bangalore", 9), true);
        system.addParcel(new Parcel("D001", "Duplicate-Delhi", 7), true);

        system.assignNextParcel();
        system.assignNextParcel();
        system.assignNextParcel();
        system.assignNextParcel();

        system.printSummary();
    }
}
