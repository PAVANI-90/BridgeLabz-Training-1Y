package com.gla.String.Level2;
import java.util.Scanner;

public class SpacesTrim {
    public static int[] findTrimIndices(String str) {
        int n = str.length();
        int start = 0;
        int end = n - 1;
        while (start < n && str.charAt(start) == ' ') {
            start++;
        }
        while (end >= 0 && str.charAt(end) == ' ') {
            end--;
        }

        return new int[]{start, end};
    }
    public static String manualSubstring(String str, int start, int end) {
        StringBuilder result = new StringBuilder();

        for (int i = start; i <= end; i++) {
            result.append(str.charAt(i));
        }
        return result.toString();
    }
    public static boolean stringsEqual(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string with spaces: ");
        String input = sc.nextLine();
        int[] indices = findTrimIndices(input);
        String manualTrim = manualSubstring(input, indices[0], indices[1]);
        String builtInTrim = input.trim();
        System.out.println("\n--- String Trimming Results ---");
        System.out.println("Original:   '" + input + "'");
        System.out.println("Manual trim: '" + manualTrim + "'");
        System.out.println("Built-in:   '" + builtInTrim + "'");
        boolean match = stringsEqual(manualTrim, builtInTrim);
        System.out.println("\nManual trim == Built-in trim: " + match);

        sc.close();
    }
}

