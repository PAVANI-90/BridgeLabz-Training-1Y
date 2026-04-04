package com.gla.WrapperClass.ScenarioBased;
import java.util.ArrayList;
public class WrapperPerformanceBenchmark {
    private static final int N = 1_000_000;
    public static void main(String[] args){
        benchmarkArray();
        benchmarkArrayList();
    }

    public static void benchmarkArray() {
        long start = System.nanoTime();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = i % 100;
        }

        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += arr[i];
        }

        long end = System.nanoTime();
        System.out.printf("int[] - Time: %.2f ms, Sum: %d%n",
                (end - start) / 1_000_000.0, sum);
    }
    public static void benchmarkArrayList() {
        long start = System.nanoTime();

        ArrayList<Integer> list = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            list.add(i % 100);
        }

        int sum = 0;
        for (Integer val : list) {
            sum += val;
        }

        long end = System.nanoTime();
        System.out.printf("ArrayList<Integer> - Time: %.2f ms, Sum: %d%n",
                (end - start) / 1_000_000.0, sum);
    }
}
