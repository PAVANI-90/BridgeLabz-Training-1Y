package com.gla.WrapperClass.ScenarioBased;
import java.util.Arrays;
public class GameScoreboard {
    public static void main(String[] args){
        Integer[] scores = {1500, null, 2200, 800, null, 1200};

        int notPlayedCount = 0;
        int totalScore = 0;

        System.out.println("Scoreboard: " +Arrays.toString(scores));

        for (Integer score : scores) {
            if (score == null) {
                notPlayedCount++;
            } else {
                totalScore += score;
            }
        }

        System.out.println("Players not played: " + notPlayedCount);
        System.out.println("Total valid scores: " + totalScore);
        System.out.println("Active players avg: " + (totalScore / (scores.length - notPlayedCount)));
    }
}
