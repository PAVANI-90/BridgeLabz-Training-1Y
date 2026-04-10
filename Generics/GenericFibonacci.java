package com.gla.Generics;
// another unbounded example
public class GenericFibonacci {
    public static <T> void fibo(T n){
        int num = Integer.parseInt(n.toString());
        int a = 0,b = 1;
        System.out.println(a+"\n"+b);
        for (int i=0;i<num;i++ ){
             int sum = a+b;
             System.out.println(sum);
             a = b;
             b = sum;
        }
    }
    public static void main(String[] args){
        fibo(5);
        fibo("7");
    }
}
