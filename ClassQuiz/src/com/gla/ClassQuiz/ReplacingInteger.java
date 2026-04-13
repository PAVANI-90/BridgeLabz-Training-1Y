package com.gla.ClassQuiz;
import java.util.Scanner;
public class ReplacingInteger {
    public static void main(String[] args {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num = sc.nextInt();
        String str =Integer.toString(num);
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '0'){
            result += '1';
        }
    else{
            result += str.charAt(i);
        }
    }
    System.out.println("New number is: "+ result);
    sc.close();
}
