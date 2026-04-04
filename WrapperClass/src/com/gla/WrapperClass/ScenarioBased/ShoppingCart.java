package com.gla.WrapperClass.ScenarioBased;

public class ShoppingCart {
    public static void main(String[] args){
        String[] priceStrings = {"250", "499", "99", "abc", "150"};

        int total = 0;
        int validCount = 0;

        System.out.println("Processing prices:");
        for (String priceStr : priceStrings) {
            try {
                int price = Integer.parseInt(priceStr);
                total += price;
                validCount++;
                System.out.println("  ✓ " + priceStr + " → " + price);
            } catch (NumberFormatException e) {
                System.out.println("  ✗ " + priceStr + " → Invalid (skipped)");
            }
        }

        System.out.println("\nTotal price: ₹" + total);
        System.out.println("Valid items: " + validCount);
    }
}
