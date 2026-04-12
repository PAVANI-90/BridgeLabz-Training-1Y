package com.gla.GenericsAndCollections.Generics;
import java.util.*;
public class CopyList {
    public static void copyList(List<? super Number> dest, List<? extends Number> src) {
        dest.clear();
        for (Number n : src) {
            dest.add(n);
        }
    }

    public static void main(String[] args) {
        List<Integer> srcInt = Arrays.asList(10, 20, 30);
        List<Double> srcDouble = Arrays.asList(1.5, 2.5, 3.0);

        List<Number> dest = new ArrayList<>();
        copyList(dest, srcInt);
        System.out.println("After copying Integer list: " + dest);
        dest.clear();
        copyList(dest, srcDouble);
        System.out.println("After copying Double list:  " + dest);
    }
}
