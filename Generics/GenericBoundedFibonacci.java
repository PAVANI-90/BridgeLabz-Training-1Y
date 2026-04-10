package com.gla.Generics;

import java.lang.Number;

public class GenericBoundedFibonacci {
    public static<T extends Number> void fiboo(T n){
        int num = n.intValue();
        int a = 0,b = 1;
        System.out.println(a+"\n"+b);
        for (int i=0;i<num;i++ ) {
            int sum = a + b;
            System.out.println(sum);
            a = b;
            b = sum;
        }
    }
    public static void main(String[] args){
        // fiboo("7");
        fiboo(6);
    }

}
