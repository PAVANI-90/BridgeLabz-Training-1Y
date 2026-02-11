package com.gla.String.Level1;

import java.util.Scanner;
class TwoStringComparison {

    public static boolean compareWithCharAt(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first string: ");
        String str1 = sc.next();
        System.out.print("Enter second string: ");
        String str2 = sc.next();
        boolean charAtResult = compareWithCharAt(str1, str2);
        boolean equalsResult = str1.equals(str2);

        System.out.println("\nResults:");
        System.out.println("String 1: '" + str1 + "'");
        System.out.println("String 2: '" + str2 + "'");
        System.out.println("charAt() method: " + charAtResult);
        System.out.println("equals() method: " + equalsResult);
        System.out.println("Match? " + (charAtResult == equalsResult));

        sc.close();
    }
}
