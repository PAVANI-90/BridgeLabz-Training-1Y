package com.gla.GenericsAndCollections.JavaCollection.SetInterface;
import java.util.*;
public class HashSetToSortedList {
    public static void main(String[] args) {
        Set<Integer> inputSet = new HashSet<>(Arrays.asList(5, 3, 9, 1));
        System.out.println("Input set: " + inputSet);


        List<Integer> sortedList = new ArrayList<>(inputSet);
        Collections.sort(sortedList);

        System.out.println("Sorted list: " + sortedList);
    }
}
