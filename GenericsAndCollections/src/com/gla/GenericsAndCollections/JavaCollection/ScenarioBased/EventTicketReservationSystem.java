package com.gla.GenericsAndCollections.JavaCollection.ScenarioBased;
import java.util.*;
class Booking {
    private String bookingId;
    private String userId;
    private String eventName;
    private boolean vip; // true = VIP user

    public Booking(String bookingId, String userId, String eventName, boolean vip) {
        this.bookingId = bookingId;
        this.userId    = userId;
        this.eventName = eventName;
        this.vip       = vip;
    }

    public String getBookingId() { return bookingId; }
    public String getUserId()    { return userId; }
    public String getEventName() { return eventName; }
    public boolean isVip()       { return vip; }

    @Override
    public String toString() {
        return "Booking{" + bookingId +
                ", user=" + userId +
                ", event=" + eventName +
                ", VIP=" + vip + "}";
    }
}
public class EventTicketReservationSystem {
    private Set<String> registeredUsers;
    private List<Booking> allBookings;
    private Queue<Booking> bookingQueue;
    private PriorityQueue<Booking> vipPriorityQueue;

    public EventTicketReservationSystem() {
        this.registeredUsers = new HashSet<>();
        this.allBookings = new ArrayList<>();
        this.bookingQueue = new LinkedList<>();
        this.vipPriorityQueue = new PriorityQueue<>(
                (b1, b2) -> {
                    if (b1.isVip() && !b2.isVip()) return -1;
                    if (!b1.isVip() && b2.isVip()) return 1;
                    return 0;
                }
        );
    }

    public boolean registerUser(String userId) {
        if (registeredUsers.add(userId)) {
            System.out.println("Registered user: " + userId);
            return true;
        } else {
            System.out.println("Duplicate user registration ignored: " + userId);
            return false;
        }
    }

    public void addBookingRequest(Booking booking) {
        if (!registeredUsers.contains(booking.getUserId())) {
            System.out.println("Booking rejected (unregistered user): " + booking);
            return;
        }
        bookingQueue.add(booking);
        vipPriorityQueue.add(booking);
        System.out.println("Booking request added: " + booking);
    }

    public void processNextBookingVIP() {
        if (vipPriorityQueue.isEmpty()) {
            System.out.println("No pending bookings in VIP queue.");
            return;
        }

        Booking b = vipPriorityQueue.poll();
        bookingQueue.removeIf(booking -> booking.getBookingId().equals(b.getBookingId()));

        confirmBooking(b, "VIP priority");
    }

    public void processNextBookingFIFO() {
        if (bookingQueue.isEmpty()) {
            System.out.println("No pending bookings in FIFO queue.");
            return;
        }

        Booking b = bookingQueue.poll();
        vipPriorityQueue.removeIf(booking -> booking.getBookingId().equals(b.getBookingId()));

        confirmBooking(b, "FIFO");
    }

    private void confirmBooking(Booking booking, String mode) {
        System.out.println("\nConfirming booking (" + mode + "): " + booking);
        allBookings.add(booking);
        System.out.println(" Booking confirmed: " + booking.getBookingId());
    }

    public void printSummary() {
        System.out.println("\n Booking Summary ");
        System.out.println("Total registered users: " + registeredUsers.size());
        System.out.println("Total confirmed bookings: " + allBookings.size());
        System.out.println("Pending in FIFO queue: " + bookingQueue.size());
        System.out.println("Pending in VIP queue: " + vipPriorityQueue.size());

        System.out.println("\nConfirmed bookings:");
        for (Booking b : allBookings) {
            System.out.println("  " + b);
        }
    }

    public static void main(String[] args) {
        EventTicketReservationSystem system = new EventTicketReservationSystem();
        system.registerUser("U001");
        system.registerUser("U002");
        system.registerUser("U003");
        system.registerUser("U001");
        system.addBookingRequest(new Booking("B001", "U001", "Rock Concert", true));
        system.addBookingRequest(new Booking("B002", "U002", "Rock Concert", false));
        system.addBookingRequest(new Booking("B003", "U003", "Tech Conference", true));
        system.addBookingRequest(new Booking("B004", "U004", "Tech Conference", false));
        system.processNextBookingVIP();
        system.processNextBookingVIP();
        system.processNextBookingFIFO();
        system.processNextBookingFIFO();
        system.printSummary();
    }
}
