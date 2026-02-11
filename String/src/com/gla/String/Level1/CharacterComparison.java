package com.gla.String.Level1;
import java.util.Scanner;

class CharacterComparison {
    public static char[] getChars(String text) {
        char[] result = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
            result[i] = text.charAt(i);
        }
        return result;
    }
    public static boolean compareCharArrays(char[] arr1, char[] arr2) {
        if (arr1.length != arr2.length) return false;

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string: ");
        String text = sc.next();

        char[] customChars = getChars(text);
        char[] builtInChars = text.toCharArray();

        boolean match = compareCharArrays(customChars, builtInChars);
        System.out.println("\nOriginal: '" + text + "'");
        System.out.print("Custom chars: ");
        for (char c : customChars) System.out.print("'" + c + "' ");
        System.out.println();

        System.out.print("toCharArray(): ");
        for (char c : builtInChars) System.out.print("'" + c + "' ");
        System.out.println();

        System.out.println("Arrays match: " + match);

        sc.close();
    }
}
