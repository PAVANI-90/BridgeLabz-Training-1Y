package com.gla.methods.Level3;
public class FootballTeamPlayersHeight {
    public static int[] generateTeamHeights() {
        int[] heights = new int[11];
        for (int i = 0; i < 11; i++) {
            heights[i] = (int) (Math.random() * 101) + 150;  // 150-250 cm
        }
        return heights;
    }
    public static int findSum(int[] heights) {
        int sum = 0;
        for (int height : heights) {
            sum += height;
        }
        return sum;
    }
    public static double findMeanHeight(int[] heights) {
        return (double) findSum(heights) / heights.length;
    }
    public static int findShortest(int[] heights) {
        int shortest = heights[0];
        for (int height : heights) {
            shortest = Math.min(shortest, height);
        }
        return shortest;
    }
    public static int findTallest(int[] heights) {
        int tallest = heights[0];
        for (int height : heights) {
            tallest = Math.max(tallest, height);
        }
        return tallest;
    }
    public static void main(String[] args) {
        int[] teamHeights = generateTeamHeights();
        System.out.print("Team Heights (cm): ");
        for (int height : teamHeights) {
            System.out.printf("%d ", height);
        }
        System.out.println();
        System.out.printf("\nFootball Team Stats\n");
        System.out.printf("Shortest: %d cm\n", findShortest(teamHeights));
        System.out.printf("Tallest: %d cm\n", findTallest(teamHeights));
        System.out.printf("Mean Height: %.1f cm\n", findMeanHeight(teamHeights));
        System.out.printf("Total Sum: %d cm\n", findSum(teamHeights));
    }
}
