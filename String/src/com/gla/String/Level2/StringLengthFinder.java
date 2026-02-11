package com.gla.String.Level2;
import java.util.Scanner;

class StringLengthFinder {
    public static int getLengthWithoutLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            return count;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string: ");
        String text = sc.next();
        int customLength = getLengthWithoutLength(text);
        int builtInLength = text.length();
        System.out.println("\nString: '" + text + "'");
        System.out.println("Custom length: " + customLength);
        System.out.println("Built-in length: " + builtInLength);
        System.out.println("They match: " + (customLength == builtInLength));

        sc.close();
    }
}
