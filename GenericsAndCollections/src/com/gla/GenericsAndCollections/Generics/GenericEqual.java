package com.gla.GenericsAndCollections.Generics;

public class GenericEqual {
    public static <T> boolean isEqual(T a, T b) {
        if (a == null && b == null) {
            return true;
        }
        if (a == null || b == null) {
            return false;
        }
        return a.equals(b);
    }
    public static void main(String[] args) {
        System.out.println(isEqual(10, 10));
        System.out.println(isEqual("Hello", "Hello"));
        System.out.println(isEqual("a", "b"));
    }
}
