package com.gla.ClassesObjects.Level2;

public class PalindromeChecker {
    String text;

    void setText(String t) {
        text = t;
    }

    boolean isPalindrome() {
        String rev = "";
        for (int i = text.length() - 1; i >= 0; i--) {
            rev += text.charAt(i);
        }
        return text.equals(rev);
    }

    void displayResult() {
        if (isPalindrome())
            System.out.println("Palindrome");
        else
            System.out.println("Not Palindrome");
    }

    public static void main(String[] args) {
        PalindromeChecker p = new PalindromeChecker();
        p.setText("madam");
        p.displayResult();
    }

}
