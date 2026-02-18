package com.gla.methods.Level2;
public class GenerateRandomValues{
    public static int[] generate4DigitRandomArray(int size) {
        int[] randomNumbers = new int[size];
        for (int i = 0; i < size; i++) {
            randomNumbers[i] = (int) (Math.random() * 9000) + 1000;
        }
        return randomNumbers;
    }
    public static double[] findAverageMinMax(int[] numbers) {
        if (numbers.length == 0) {
            return new double[]{0, 0, 0};
        }
        int min = numbers[0];
        int max = numbers[0];
        double sum = 0;
        for (int num : numbers) {
            min = Math.min(min, num);
            max = Math.max(max, num);
            sum += num;
        }
        double average = sum / numbers.length;
        return new double[]{average, min, max};
    }
    public static void main(String[] args) {
        int[] randomNums = generate4DigitRandomArray(5);
        System.out.print("Generated 4-digit numbers: ");
        for (int num : randomNums) {
            System.out.printf("%d ", num);
        }
        System.out.println();
        double[] stats = findAverageMinMax(randomNums);
        double average = stats[0];
        int min = (int) stats[1];
        int max = (int) stats[2];
        System.out.printf("Average: %.2f\n", average);
        System.out.printf("Minimum: %d\n", min);
        System.out.printf("Maximum: %d\n", max);
    }
}

