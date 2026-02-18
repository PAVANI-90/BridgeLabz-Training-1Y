package com.gla.methods.Level2;
import java.util.Scanner;

public class YoungestFriendChecker {
    public static String findYoungest(int[] ages) {
        int minAge = Math.min(ages[0], Math.min(ages[1], ages[2]));
        if (minAge == ages[0]) return "Amar";
        if (minAge == ages[1]) return "Akbar";
        return "Anthony";
    }
    public static String findTallest(double[] heights) {
        double maxHeight = Math.max(heights[0], Math.max(heights[1], heights[2]));
        if (maxHeight == heights[0]) return "Amar";
        if (maxHeight == heights[1]) return "Akbar";
        return "Anthony";
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] ages = new int[3];
        double[] heights = new double[3];
        System.out.println("Enter details for Amar, Akbar, Anthony:");
        for (int i = 0; i < 3; i++) {
            String name = (i == 0) ? "Amar" : (i == 1) ? "Akbar" : "Anthony";
            System.out.print(name + " age: ");
            ages[i] = sc.nextInt();
            System.out.print(name + " height (cm): ");
            heights[i] = sc.nextDouble();
        }
        String youngest = findYoungest(ages);
        String tallest = findTallest(heights);
        System.out.println("\n=== Results ===");
        System.out.printf("Youngest: %s (%d years)\n", youngest,
                ages[0] == ages[1] ? ages[0] :
                        ages[0] == ages[2] ? ages[0] :
                                ages[1] == ages[2] ? ages[1] :
                                        Math.min(Math.min(ages[0], ages[1]), ages[2]));
        System.out.printf("Tallest: %s (%.1f cm)\n", tallest,
                Math.max(Math.max(heights[0], heights[1]), heights[2]));
        sc.close();
    }
}

