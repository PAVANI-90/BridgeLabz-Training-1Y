package com.gla.String.Level1;
import java.util.Scanner;
class SubstringComparison {
    public static String createSubstring(String text, int start, int end) {
        String result = "";
        for (int i = start; i <= end && i < text.length(); i++) {
            result += text.charAt(i);
        }
        return result;
    }
    public static boolean compareWithCharAt(String str1, String str2) {
        if (str1.length() != str2.length()) return false;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter main string: ");
        String text = sc.nextLine();
        System.out.print("Enter start index: ");
        int start = sc.nextInt();
        System.out.print("Enter end index: ");
        int end = sc.nextInt();
        String customSub = createSubstring(text, start, end);
        String builtInSub = text.substring(start, end + 1);
        boolean match = compareWithCharAt(customSub, builtInSub);
        System.out.println("\nOriginal: '" + text + "'");
        System.out.println("Custom charAt(): '" + customSub + "'");
        System.out.println("Built-in substring(): '" + builtInSub + "'");
        System.out.println("They match: " + match);

        sc.close();
    }
}

