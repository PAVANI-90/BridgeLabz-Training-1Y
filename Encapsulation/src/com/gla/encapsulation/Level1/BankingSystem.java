package com.gla.encapsulation.Level1;
import java.util.*;

// Loanable interface
interface Loanable {
    boolean applyForLoan(double amount);
    String calculateLoanEligibility();
}

// Abstract BankAccount class with encapsulation
abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    protected double balance;

    public BankAccount(String accountNumber, String holderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = initialBalance;
    }

    // Encapsulation: getters/setters
    public String getAccountNumber() { return accountNumber; }
    public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }
    public String getHolderName() { return holderName; }
    public void setHolderName(String holderName) { this.holderName = holderName; }
    public double getBalance() { return balance; }

    // Concrete deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.printf("Deposited $%.2f. New balance: $%.2f%n", amount, balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Concrete withdraw method
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.printf("Withdrew $%.2f. New balance: $%.2f%n", amount, balance);
        } else {
            System.out.println("Insufficient funds or invalid amount.");
        }
    }

    // Abstract interest method
    public abstract double calculateInterest();

    // Display account summary
    public void displaySummary() {
        System.out.printf("%s (%s) - Balance: $%.2f, Interest: $%.2f%n",
                accountNumber, holderName, balance, calculateInterest());
    }
}

// SavingsAccount subclass
class SavingsAccount extends BankAccount implements Loanable {
    private double interestRate = 0.04;

    public SavingsAccount(String accountNumber, String holderName, double initialBalance) {
        super(accountNumber, holderName, initialBalance);
    }

    @Override
    public double calculateInterest() {
        return getBalance() * interestRate;
    }

    @Override
    public boolean applyForLoan(double amount) {
        return getBalance() >= 5000 && amount <= getBalance() * 2;
    }

    @Override
    public String calculateLoanEligibility() {
        return "Eligible up to 2x savings balance (min $5,000 balance)";
    }
}

// CurrentAccount subclass
class CurrentAccount extends BankAccount implements Loanable {
    private double interestRate = 0.02;
    private double overdraftLimit = 1000;

    public CurrentAccount(String accountNumber, String holderName, double initialBalance) {
        super(accountNumber, holderName, initialBalance);
    }

    @Override
    public double calculateInterest() {
        return Math.max(getBalance(), -overdraftLimit) * interestRate;
    }

    @Override
    public boolean applyForLoan(double amount) {
        return amount <= 50000;  // Fixed limit
    }

    @Override
    public String calculateLoanEligibility() {
        return "Eligible up to $50,000 (business accounts)";
    }
}

// Main class - polymorphism demo
public class BankingSystem {
    public static void main(String[] args) {
        // List of BankAccount references
        List<BankAccount> accounts = new ArrayList<>();

        SavingsAccount savings1 = new SavingsAccount("SAV001", "Alice Johnson", 10000);
        CurrentAccount current1 = new CurrentAccount("CUR001", "Bob Smith", 5000);
        SavingsAccount savings2 = new SavingsAccount("SAV002", "Carol White", 8000);
        CurrentAccount current2 = new CurrentAccount("CUR002", "David Lee", 20000);

        accounts.add(savings1);
        accounts.add(current1);
        accounts.add(savings2);
        accounts.add(current2);

        System.out.println("Banking System Demo\n");

        // Demo deposit/withdraw on first account
        System.out.println("--- Transaction Demo ---");
        savings1.deposit(1000);
        savings1.withdraw(500);
        System.out.println();

        // Polymorphic process
        System.out.println("--- Account Summary (Interest Calculation) ---");
        for (BankAccount acc : accounts) {
            acc.displaySummary();

            // Loan check if applicable
            if (acc instanceof Loanable) {
                Loanable loan = (Loanable) acc;
                System.out.println("Loan: " + loan.calculateLoanEligibility());
            }
            System.out.println();
        }
    }
}

