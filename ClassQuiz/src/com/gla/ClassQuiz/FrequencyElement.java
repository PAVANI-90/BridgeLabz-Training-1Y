package com.gla.ClassQuiz;
import java.util.*;

public class FrequencyElement {
    public static void countfreq(int[] arr, int n) {
        boolean[] num = new boolean[n];
        Arrays.fill(num, false);
        for (int i = 0; i < n; i++) {
            if (num[i]) continue;
            int count = 1;
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j]) {
                    num[j] = true;
                    count++;
                }
            }
            System.out.println(arr[i] + " occurs " + count + " times");
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 10, 20, 30};
        countfreq(arr, arr.length);
    }
}
