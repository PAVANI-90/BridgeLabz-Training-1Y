package com.gla.String.Level2;
import java.util.Scanner;

public class TextSplit {
    public static int findLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (Exception e) {
        }
        return count;
    }
    public static String[] manualSplit(String text) {
        int len = findLength(text);
        int wordCount = 1;
        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ' ') {
                wordCount++;
            }
        }
        int[] spaceIndexes = new int[wordCount - 1];
        int k = 0;
        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ' ') {
                spaceIndexes[k++] = i;
            }
        }
        String[] words = new String[wordCount];
        int start = 0;

        for (int i = 0; i < wordCount - 1; i++) {
            int end = spaceIndexes[i];
            words[i] = text.substring(start, end);
            start = end + 1;
        }

        words[wordCount - 1] = text.substring(start, len);

        return words;
    }
    public static boolean compareArrays(String[] a, String[] b) {
        if (a.length != b.length)
            return false;

        for (int i = 0; i < a.length; i++) {
            if (!a[i].equals(b[i]))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a sentence:");
        String text = sc.nextLine();
        String[] manualWords = manualSplit(text);
        String[] splitWords = text.split(" ");
        boolean result = compareArrays(manualWords, splitWords);
        System.out.println("\nWords using manual method:");
        for (String word : manualWords) {
            System.out.println(word);
        }

        System.out.println("\nWords using split() method:");
        for (String word : splitWords) {
            System.out.println(word);
        }

        System.out.println("\nAre both results same? " + result);
    }
}