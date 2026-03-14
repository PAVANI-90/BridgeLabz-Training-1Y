package com.gla.ClassesObjects.Level2;

public class BankAccount {
    String accountHolder;
    int accountNumber;
    double balance;

    void setDetails(String name, int number, double bal) {
        accountHolder = name;
        accountNumber = number;
        balance = bal;
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient Balance");
        }
    }

    void displayBalance() {
        System.out.println("Current Balance: " + balance);
    }

    public static void main(String[] args) {
        BankAccount b = new BankAccount();
        b.setDetails("Anushka", 12345, 10000);
        b.deposit(2000);
        b.withdraw(5000);
        b.displayBalance();
    }

}

