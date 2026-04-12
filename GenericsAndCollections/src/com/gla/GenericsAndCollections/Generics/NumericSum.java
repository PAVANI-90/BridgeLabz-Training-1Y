package com.gla.GenericsAndCollections.Generics;
import java.util.*;
public class NumericSum {
    public static double sumNumbers(List<? extends Number> list) {
        double sum = 0.0;
        for (Number n : list) {
            sum += n.doubleValue();
        }
        return sum;
    }
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(10, 20, 30);
        List<Double> doubleList = Arrays.asList(1.5, 2.5, 3.0);

        System.out.println("Sum Integers:   " + sumNumbers(intList));   // 60.0
        System.out.println("Sum Doubles:    " + sumNumbers(doubleList)); // 7.0
    }
}
