package com.gla.Threads;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

class ExamActivity extends Thread {
    private String activityName;
    private long initialDelayMs;
    private long cycleIntervalMs;
    private int priorityLevel;
    private int cycles;
    private boolean isContinuous;

    public ExamActivity(String name, long initialDelay, long interval, int priority, int cycles, boolean continuous) {
        this.activityName = name;
        this.initialDelayMs = initialDelay;
        this.cycleIntervalMs = interval;
        this.priorityLevel = priority;
        this.cycles = cycles;
        this.isContinuous = continuous;
        setPriority(priorityLevel);
    }

    @Override
    public void run() {
        Thread current = Thread.currentThread();
        System.out.printf("[%s] %s (%s) - NEW state, Priority: %d%n",
                LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")),
                activityName, current.getName(), priorityLevel);

        try {
            Thread.sleep(initialDelayMs);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }

        System.out.printf("[%s] %s (%s) - RUNNABLE -> Starting (Pri: %d)%n",
                LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")),
                activityName, current.getName(), priorityLevel);

        int cycleCount = 0;
        while ((isContinuous || cycleCount < cycles) && !isInterrupted()) {
            System.out.printf("[%s] %s (%s) - RUNNABLE -> Cycle %d (Pri: %d)%n",
                    LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")),
                    activityName, current.getName(), ++cycleCount, priorityLevel);

            try {
                System.out.printf("[%s] %s (%s) - TIMED_WAITING (sleeping)%n",
                        LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")),
                        activityName, current.getName());
                Thread.sleep(cycleIntervalMs);
            } catch (InterruptedException e) {
                System.out.printf("[%s] %s (%s) - INTERRUPTED%n",
                        LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")),
                        activityName, current.getName());
                return;
            }
        }

        System.out.printf("[%s] %s (%s) - TERMINATED (Completed %d cycles)%n",
                LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")),
                activityName, current.getName(), cycleCount);
    }
}
public class UniversityExamHallManagement {
    public static void main(String[] args) throws InterruptedException {

        ExamActivity entryMonitor = new ExamActivity("Student Entry Monitor", 0, 2000, 5, 15, true);
        ExamActivity paperDist = new ExamActivity("Question Paper Distribution", 5000, 1000, 10, 3, false);
        ExamActivity attendance = new ExamActivity("Attendance Marking", 10000, 1500, 8, 4, false);
        ExamActivity sheetCollection = new ExamActivity("Answer Sheet Collection", 30000, 500, 7, 2, false);

        entryMonitor.start();
        paperDist.start();
        attendance.start();
        sheetCollection.start();


        entryMonitor.join();
        paperDist.join();
        attendance.join();
        sheetCollection.join();

        System.out.println("\n[All activities completed properly.]");
    }
}
