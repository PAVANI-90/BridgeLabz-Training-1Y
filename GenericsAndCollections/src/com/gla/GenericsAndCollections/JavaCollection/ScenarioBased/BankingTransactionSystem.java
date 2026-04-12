package com.gla.GenericsAndCollections.JavaCollection.ScenarioBased;
import java.util.*;
class Account {
    private String accountId;
    private double balance;

    public Account(String accountId, double balance) {
        this.accountId = accountId;
        this.balance   = balance;
    }

    public String getAccountId() { return accountId; }
    public double getBalance()   { return balance; }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount > balance) return false;
        balance -= amount;
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account a = (Account) o;
        return accountId.equals(a.accountId);
    }

    @Override
    public int hashCode() {
        return accountId.hashCode();
    }

    @Override
    public String toString() {
        return "Account{" + accountId + ", balance=" + balance + "}";
    }
}

enum TransactionType {
    DEPOSIT, WITHDRAW
}

class Transaction {
    private String txId;
    private String accountId;
    private TransactionType type;
    private double amount;

    public Transaction(String txId, String accountId, TransactionType type, double amount) {
        this.txId      = txId;
        this.accountId = accountId;
        this.type      = type;
        this.amount    = amount;
    }

    public String getTxId()      { return txId; }
    public String getAccountId() { return accountId; }
    public TransactionType getType() { return type; }
    public double getAmount()    { return amount; }

    @Override
    public String toString() {
        return "Transaction{" + txId + ", " + type +
                ", account=" + accountId + ", amount=" + amount + "}";
    }
}
public class BankingTransactionSystem {
    private List<Transaction> transactionHistory;


    private Queue<Transaction> pendingTransactions;


    private Set<Account> validAccounts;


    private Stack<Transaction> rollbackStack;

    public BankingTransactionSystem() {
        this.transactionHistory   = new ArrayList<>();
        this.pendingTransactions  = new LinkedList<>();
        this.validAccounts        = new HashSet<>();
        this.rollbackStack        = new Stack<>();
    }


    public void addAccount(Account account) {
        validAccounts.add(account);
    }


    private Account findAccount(String accountId) {
        for (Account a : validAccounts) {
            if (a.getAccountId().equals(accountId)) return a;
        }
        return null;
    }


    public void addTransaction(Transaction tx) {
        pendingTransactions.add(tx);
        System.out.println("Added to queue: " + tx);
    }


    public void processAllTransactions() {
        System.out.println("\n Processing pending transactions ");
        while (!pendingTransactions.isEmpty()) {
            Transaction tx = pendingTransactions.poll();
            executeTransaction(tx);
        }
    }


    private void executeTransaction(Transaction tx) {
        Account acc = findAccount(tx.getAccountId());
        if (acc == null) {
            System.out.println("❌ Invalid account for transaction: " + tx);
            return;
        }

        boolean success = false;

        switch (tx.getType()) {
            case DEPOSIT:
                acc.deposit(tx.getAmount());
                success = true;
                break;
            case WITHDRAW:
                success = acc.withdraw(tx.getAmount());
                break;
        }

        if (success) {
            System.out.println(" Executed: " + tx + " | New balance: " + acc.getBalance());
            transactionHistory.add(tx);
            rollbackStack.push(tx);
        } else {
            System.out.println(" Failed to execute: " + tx + " (insufficient funds?)");
        }
    }


    public void rollbackLastTransaction() {
        if (rollbackStack.isEmpty()) {
            System.out.println("\nNo transaction to rollback.");
            return;
        }

        Transaction tx = rollbackStack.pop();
        Account acc = findAccount(tx.getAccountId());
        if (acc == null) {
            System.out.println("Cannot rollback: account not found for " + tx);
            return;
        }

        System.out.println("\n Rolling back transaction ");
        System.out.println("Undoing: " + tx);


        switch (tx.getType()) {
            case DEPOSIT:
                acc.withdraw(tx.getAmount());
                break;
            case WITHDRAW:
                acc.deposit(tx.getAmount());
                break;
        }

        System.out.println("Rollback complete. New balance: " + acc.getBalance());

    }

    public void printAccounts() {
        System.out.println("\n Accounts ");
        for (Account a : validAccounts) {
            System.out.println(a);
        }
    }

    public void printHistory() {
        System.out.println("\n Transaction History ");
        for (Transaction tx : transactionHistory) {
            System.out.println(tx);
        }
    }


    public static void main(String[] args) {
        BankingTransactionSystem system = new BankingTransactionSystem();


        Account a1 = new Account("ACC001", 1000.0);
        Account a2 = new Account("ACC002", 500.0);

        system.addAccount(a1);
        system.addAccount(a2);


        system.addTransaction(new Transaction("TX1", "ACC001", TransactionType.DEPOSIT, 200.0));
        system.addTransaction(new Transaction("TX2", "ACC002", TransactionType.WITHDRAW, 100.0));
        system.addTransaction(new Transaction("TX3", "ACC003", TransactionType.DEPOSIT, 300.0));
        system.addTransaction(new Transaction("TX4", "ACC001", TransactionType.WITHDRAW, 1500.0));
        system.addTransaction(new Transaction("TX5", "ACC001", TransactionType.WITHDRAW, 300.0));


        system.processAllTransactions();

        system.printAccounts();
        system.printHistory();


        system.rollbackLastTransaction();

        system.printAccounts();
    }
}
