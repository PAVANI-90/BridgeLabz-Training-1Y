package com.gla.String.Level1;
import java.util.Scanner;

class UpperCaseConverter {
    public static String toUpperCaseCustom(String text) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                result += (char) (ch - 32);
            } else {
                result += ch;
            }
        }
        return result;
    }
    public static boolean compareWithCharAt(String str1, String str2) {
        if (str1.length() != str2.length()) return false;

        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();
        String customUpper = toUpperCaseCustom(text);
        String builtInUpper = text.toUpperCase();
        boolean match = compareWithCharAt(customUpper, builtInUpper);
        System.out.println("\nOriginal:  '" + text + "'");
        System.out.println("Custom:    '" + customUpper + "'");
        System.out.println("Built-in:  '" + builtInUpper + "'");
        System.out.println("They match: " + match);

        sc.close();
    }
}

