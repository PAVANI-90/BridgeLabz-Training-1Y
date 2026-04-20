package com.gla.StreamAPI.LambdaExpressions.MethodReferences;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class Invoice {
    String transactionId;
    double amount;
    String date;
    int invoiceNumber;

    public Invoice(String transId, double amt, String dt) {
        this.transactionId = transId;
        this.amount = amt;
        this.date = dt;
        this.invoiceNumber = (int)(Math.random() * 10000);
    }

    @Override
    public String toString() {
        return String.format("Invoice #%d: %s | $%.2f | %s",
                invoiceNumber, transactionId, amount, date);
    }
}

public class InvoiceGenerator {
    public static void main(String[] args) {
        List<String[]> transactions = Arrays.asList(
                new String[]{"TXN001", "1500.50", "2026-04-20"},
                new String[]{"TXN002", "2500.00", "2026-04-21"},
                new String[]{"TXN003", "875.75", "2026-04-22"},
                new String[]{"TXN004", "3200.25", "2026-04-23"}
        );

        System.out.println("=== Generated Invoices ===");
        List<Invoice> invoices = transactions.stream()
                .map(arr -> new Invoice(arr[0], Double.parseDouble(arr[1]), arr[2]))  // Lambda first
                .collect(Collectors.toList());


        invoices.forEach(System.out::println);

        System.out.println("\nHigh Value Invoices (>$2000):");
        invoices.stream()
                .filter(inv -> inv.amount > 2000)
                .forEach(System.out::println);
    }
}
