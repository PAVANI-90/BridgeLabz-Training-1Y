package com.gla.GenericsAndCollections.Generics;

public class MaximumGeneric {
    public static <T extends Comparable<T>> T maximum(T x, T y, T z) {
        T max = x;

        if (y.compareTo(max) > 0) {
            max = y;
        }
        if (z.compareTo(max) > 0) {
            max = z;
        }

        return max;
    }
    public static void main(String[] args) {
        System.out.println(maximum(10, 20, 15));
        System.out.println(maximum(3.5, 2.1, 4.8));
        System.out.println(maximum("apple", "banana", "cherry"));
    }
}
