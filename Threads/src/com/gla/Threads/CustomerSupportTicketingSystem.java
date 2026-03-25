package com.gla.Threads;
import java.util.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicInteger;

class TicketProcessor extends Thread {
    private static AtomicInteger ticketCounter = new AtomicInteger(0);
    private final int ticketNumber;
    private final String type;
    private final int priority;
    private long startTime;
    private long endTime;


    private static double totalProcessingTime = 0;
    private static Map<Integer, Double> totalWaitByPriority = new HashMap<>();
    private static Map<Integer, Integer> countByPriority = new HashMap<>();

    public TicketProcessor(String type, int priority) {
        this.ticketNumber = ticketCounter.incrementAndGet();
        this.type = type;
        this.priority = priority;
        setName("Agent-" + ticketNumber);
        setPriority(priority);
    }

    @Override
    public void run() {
        startTime = System.currentTimeMillis();
        System.out.printf("[%s] Ticket %d (%s, Priority %d) - Assigned to %s - Processing START (Higher priority = earlier queue position)%n",
                LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")),
                ticketNumber, type, priority, getName());

        Random rand = new Random(ticketNumber);
        int processTime = (rand.nextInt(5) + 1) * 1000;  // 1-5 seconds
        try {
            Thread.sleep(processTime);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        endTime = System.currentTimeMillis();
        double processingTimeSec = (endTime - startTime) / 1000.0;
        synchronized (TicketProcessor.class) {
            totalProcessingTime += processingTimeSec;
            totalWaitByPriority.put(priority, totalWaitByPriority.getOrDefault(priority, 0.0) + processingTimeSec);
            countByPriority.put(priority, countByPriority.getOrDefault(priority, 0) + 1);
        }

        System.out.printf("[%s] Ticket %d (%s, Priority %d) - Assigned to %s - Processing COMPLETE (%.2fs)%n",
                LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")),
                ticketNumber, type, priority, getName(), processingTimeSec);
    }

    public static void printStatistics() {
        synchronized (TicketProcessor.class) {
            System.out.printf("%n STATISTICS %n");
            System.out.printf("Total Processing Time for all tickets: %.2fs%n", totalProcessingTime);

            System.out.println("Average Processing Time per Priority Level:");
            totalWaitByPriority.forEach((pri, total) -> {
                int count = countByPriority.get(pri);
                double avg = total / count;
                System.out.printf("  Priority %d (%s): %.2fs%n", pri, getTypeByPriority(pri), avg);
            });
        }
    }

    private static String getTypeByPriority(int pri) {
        return switch (pri) {
            case 10 -> "Critical Bug";
            case 4 -> "Feature Request";
            case 2 -> "General Query";
            case 1 -> "Feedback";
            default -> "Unknown";
        };
    }
}

public class CustomerSupportTicketingSystem {
    public static void main(String[] args) throws InterruptedException {
        String[] ticketTypes = {"Critical Bug", "Feature Request", "General Query", "Feedback"};
        int[] priorities = {10, 4, 2, 1};

        List<Thread> tickets = new ArrayList<>();
        Random rand = new Random();


        for (int i = 0; i < 10; i++) {
            int typeIdx = rand.nextInt(ticketTypes.length);
            TicketProcessor ticket = new TicketProcessor(ticketTypes[typeIdx], priorities[typeIdx]);
            tickets.add(ticket);
            ticket.start();
        }


        for (Thread t : tickets) {
            t.join();
        }

        TicketProcessor.printStatistics();
    }
}
