package com.gla.WrapperClass.ScenarioBased;

public class ShoppingCart2 {
    public static void main(String[] args){
        String[] cartItems = {"250", "499", "99", "abc", "150", "75.5"};

        int totalPrice = 0;
        int validItems = 0;

        System.out.println("🛒 Shopping Cart Processing:");
        for (String priceStr : cartItems) {
            try {
                int price = Integer.parseInt(priceStr);
                totalPrice += price;
                validItems++;
                System.out.println("  ✓ " + priceStr + " = ₹" + price);
            } catch (NumberFormatException e) {
                System.out.println("  ✗ " + priceStr + " - Invalid price (skipped)");
            }
        }

        System.out.println(" Total: ₹" + totalPrice);
        System.out.println(" Valid items: " + validItems);
    }
}
