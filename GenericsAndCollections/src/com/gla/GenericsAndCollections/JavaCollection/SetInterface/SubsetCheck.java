package com.gla.GenericsAndCollections.JavaCollection.SetInterface;
import java.util.*;
public class SubsetCheck {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3, 4));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(2, 3));

        System.out.println("Set1: " + set1);
        System.out.println("Set2: " + set2);

        boolean isSubset = set1.containsAll(set2);

        System.out.println("Is Set2 a subset of Set1? " + isSubset);
    }
}
