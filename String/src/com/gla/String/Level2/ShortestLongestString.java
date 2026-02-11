package com.gla.String.Level2;
import java.util.Scanner;

public class ShortestLongestString {
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
            if (text.charAt(i) == ' ')
                wordCount++;
        }

        int[] spaces = new int[wordCount - 1];
        int k = 0;

        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ' ')
                spaces[k++] = i;
        }

        String[] words = new String[wordCount];
        int start = 0;

        for (int i = 0; i < wordCount - 1; i++) {
            int end = spaces[i];
            words[i] = text.substring(start, end);
            start = end + 1;
        }

        words[wordCount - 1] = text.substring(start, len);

        return words;
    }
    public static String[][] wordWithLength(String[] words) {
        String[][] result = new String[words.length][2];

        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            int len = findLength(words[i]);
            result[i][1] = String.valueOf(len);
        }

        return result;
    }
    public static int[] findShortestLongest(String[][] data) {

        int minIndex = 0;
        int maxIndex = 0;

        int minLength = Integer.parseInt(data[0][1]);
        int maxLength = Integer.parseInt(data[0][1]);

        for (int i = 1; i < data.length; i++) {

            int length = Integer.parseInt(data[i][1]);

            if (length < minLength) {
                minLength = length;
                minIndex = i;
            }

            if (length > maxLength) {
                maxLength = length;
                maxIndex = i;
            }
        }

        return new int[]{minIndex, maxIndex};
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a sentence:");
        String text = sc.nextLine();
        String[] words = manualSplit(text);
        String[][] data = wordWithLength(words);
        int[] result = findShortestLongest(data);

        int shortIndex = result[0];
        int longIndex = result[1];
        System.out.println("\nWord\tLength");
        System.out.println("----------------");

        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i][0] + "\t" + data[i][1]);
        }

        System.out.println("\nShortest Word: " + data[shortIndex][0] +
                " (Length: " + data[shortIndex][1] + ")");

        System.out.println("Longest Word: " + data[longIndex][0] +
                " (Length: " + data[longIndex][1] + ")");
    }
}