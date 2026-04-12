package com.gla.GenericsAndCollections.JavaCollection.ListInterface;
import java.util.*;
public class RemoveDuplicates {
    public static List<Integer> removeDuplicates(List<Integer> list) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();

        for (Integer x : list) {
            if (!seen.contains(x)) {
                seen.add(x);
                result.add(x);
            }
        }

        return result;
    }

    public static void main(String[] args) {

        List<Integer> input = Arrays.asList(3, 1, 2, 2, 3, 4);
        System.out.println("Input:  " + input);
        List<Integer> output = removeDuplicates(input);
        System.out.println("Output: " + output);
    }
}
