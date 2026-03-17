package com.gla.JavaPackage;

public class BankTest {
    public static void main(String[] args) {

        // Example loan details
        double principal = 1000; // Principal amount
        double rate = 5;          // Annual interest rate (%)
        double time = 2;          // Time in years

        // Calculate Simple Interest
        double si = InterestCalculator.calculateSimpleInterest(principal, rate, time);

        // Calculate Compound Interest
        double ci = InterestCalculator.calculateCompoundInterest(principal, rate, time);

        // Display results
        System.out.println("Principal: " + principal);
        System.out.println("Rate: " + rate + "%");
        System.out.println("Time: " + time + " years\n");

        System.out.println("Simple Interest: " + si);
        System.out.println("Compound Interest: " + ci);
    }

}

