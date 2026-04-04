package com.gla.WrapperClass.ScenarioBased;
import java.util.*;
import java.util.Objects;

public class ProductRatingsAnalyzer {
    public static void main(String[] args){
        int[] oldRatings = {4, 5, 3, 2};


        ArrayList<Integer> newRatings = new ArrayList<>();
        newRatings.add(4);
        newRatings.add(null);
        newRatings.add(5);
        newRatings.add(3);

        ArrayList<Integer> allRatings = new ArrayList<>();

        for (int rating : oldRatings) {
            allRatings.add(rating);
        }
        allRatings.addAll(newRatings.stream()
                .filter(Objects::nonNull)
                .toList());
        double sum = 0;
        for (Integer rating : allRatings) {
            sum += rating;  // Integer → int
        }
        double average = sum / allRatings.size();

        System.out.println("All ratings: " + allRatings);
        System.out.printf("Average rating: %.2f ★%n", average);
    }
}
