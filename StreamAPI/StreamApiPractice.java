package com.gla.streamapi;

interface Sum{
    int add(int a , int b);
}
interface StringLength{
    int length(String s);
}
public class StreamApiPractice {
    // public int stringLength(){
    // }

    // (String s) -> {
    // return s.length();
    // };
    // (int a , int b ) ->{
     // int c = a+b ;
    // return c ;
    // };
    public static void main(String[] args){
        // lambda expression for sum of two number .
        Sum s = (int a,int b)->(a+b);
        System.out.println(s.add(10,20));
        // lambda expression fpr string length .
        StringLength sl = (String a)->{return a.length();};
        System.out.println(sl.length("Hello"));
    }
}
