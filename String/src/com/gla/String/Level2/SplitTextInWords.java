package com.gla.String.Level2;
import java.util.Scanner;

public class SplitTextInWords {


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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a sentence:");
        String text = sc.nextLine();


        String[] words = manualSplit(text);


        String[][] data = wordWithLength(words);


        System.out.println("\nWord\tLength");
        System.out.println("----------------");

        for (int i = 0; i < data.length; i++) {
            String word = data[i][0];
            int length = Integer.parseInt(data[i][1]); // convert String to Integer
            System.out.println(word + "\t" + length);
        }
    }
}