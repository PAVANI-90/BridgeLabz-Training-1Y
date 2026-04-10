package com.gla.Generics;
// unbounded generic
public class GenericSwap {
    public static <T> void swap(T a, T b){
        System.out.println("Before swapping : "+a+" "+b);
        T temp = a;
        a = b;
        b = temp;
        System.out.println("After swapping : "+a+" "+b);
    }
    public static void main(String[] args){
        swap(5, 10);
        swap("Jay", "Veeru");
    }
}
