package com.gla.Threads;
class BankAccount implements Runnable {
    private String accountHolder;
    private String accountType;
    private int priority;

    public BankAccount(String accountHolder, String accountType, int priority) {
        this.accountHolder = accountHolder;
        this.accountType = accountType;
        this.priority = priority;
    }

    @Override
    public void run() {
        Thread.currentThread().setPriority(priority);
        for (int i = 1; i <= 3; i++) {
            System.out.println(Thread.currentThread().getName() + " (" + accountType + ", Priority: " + priority + ") - Balance Check " + i);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
public class BankAccountSimulation {
    public static void main(String[] args) {

        BankAccount premium = new BankAccount("VIP Customer", "Premium", Thread.MAX_PRIORITY);  // 10
        BankAccount regular = new BankAccount("John Doe", "Regular", Thread.NORM_PRIORITY);    // 5
        BankAccount basic = new BankAccount("Jane Smith", "Basic", Thread.MIN_PRIORITY);       // 1


        Thread t1 = new Thread(premium, "PremiumUser");
        Thread t2 = new Thread(regular, "RegularUser");
        Thread t3 = new Thread(basic, "BasicUser");

        t1.start();
        t2.start();
        t3.start();
    }
}
