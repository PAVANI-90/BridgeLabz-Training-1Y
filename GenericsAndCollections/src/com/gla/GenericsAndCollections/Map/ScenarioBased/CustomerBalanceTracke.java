package com.gla.GenericsAndCollections.Map.ScenarioBased;
import java.util.*;

public class CustomerBalanceTracke {
    private Map<String, Double> accounts;

    public CustomerBalanceTracke() {
        this.accounts = new HashMap<>();
    }

    public void addAccount(String accountNumber, double initialBalance) {
        accounts.put(accountNumber, initialBalance);
    }

    public void deposit(String accountNumber, double amount) {
        Double balance = accounts.get(accountNumber);
        if (balance == null) {
            System.out.println("Account not found: " + accountNumber);
            return;
        }
        balance += amount;
        accounts.put(accountNumber, balance);
        System.out.println("Deposited " + amount + " to " + accountNumber +
                ", new balance = " + balance);
    }

    public void withdraw(String accountNumber, double amount) {
        Double balance = accounts.get(accountNumber);
        if (balance == null) {
            System.out.println("Account not found: " + accountNumber);
            return;
        }
        if (amount > balance) {
            System.out.println("Insufficient funds for account " + accountNumber +
                    ". Balance = " + balance + ", requested = " + amount);
            return;
        }
        balance -= amount;
        accounts.put(accountNumber, balance);
        System.out.println("Withdrew " + amount + " from " + accountNumber +
                ", new balance = " + balance);
    }

    public List<Map.Entry<String, Double>> getAccountsSortedByBalanceDesc() {
        List<Map.Entry<String, Double>> list = new ArrayList<>(accounts.entrySet());
        list.sort((e1, e2) -> Double.compare(e2.getValue(), e1.getValue()));
        return list;
    }

    public void printAllSortedByBalanceDesc() {
        System.out.println("\nAll customers sorted by descending balance:");
        for (Map.Entry<String, Double> e : getAccountsSortedByBalanceDesc()) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }
    }

    public void printTopNCustomers(int n) {
        List<Map.Entry<String, Double>> sorted = getAccountsSortedByBalanceDesc();
        System.out.println("\nTop " + n + " customers by balance:");
        for (int i = 0; i < Math.min(n, sorted.size()); i++) {
            Map.Entry<String, Double> e = sorted.get(i);
            System.out.println((i + 1) + ". " + e.getKey() + " -> " + e.getValue());
        }
    }

    public static void main(String[] args) {
        CustomerBalanceTracke bank = new CustomerBalanceTracke();

        bank.addAccount("ACC001", 15000.0);
        bank.addAccount("ACC002", 32000.0);
        bank.addAccount("ACC003", 8000.0);
        bank.addAccount("ACC004", 45000.0);
        bank.addAccount("ACC005", 22000.0);

        bank.deposit("ACC001", 5000.0);
        bank.deposit("ACC003", 2000.0);

        bank.withdraw("ACC004", 10000.0);
        bank.withdraw("ACC003", 12000.0);
        bank.withdraw("ACC003", 5000.0);

        bank.withdraw("ACC999", 1000.0);

        bank.printAllSortedByBalanceDesc();
        bank.printTopNCustomers(3);
    }
}
