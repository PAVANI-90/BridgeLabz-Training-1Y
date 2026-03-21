package com.gla.ExceptionHandling.BankTransactionSystem;

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        // Check for negative amount
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }

        // Check for insufficient balance
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance");
        }

        balance -= amount;
        System.out.println("Withdrawal successful! Remaining balance: " + balance);
    }
}

public class BankSystem {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);

        try {
            // Test cases
            account.withdraw(500);   // valid
            account.withdraw(600);   // insufficient balance
            account.withdraw(-100);  // negative amount

        } catch (InsufficientBalanceException e) {
            System.out.println("Error: " + e.getMessage());

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
