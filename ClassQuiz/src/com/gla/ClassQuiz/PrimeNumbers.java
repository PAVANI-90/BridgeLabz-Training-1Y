package com.gla.ClassQuiz;
import java.util.*;

public class PrimeNumbers {
    public static void main(String[] args){
        ArrayList<Integer> primenum = new ArrayList<>();
        for(int num = 2; num<=100;num++){
            boolean isPrime = true ;
        }
        for(int i = 2; i<= Math.sqrt(num); i++){
            if(num % i==0){
                 isPrime = false;
                 break;
            }
        }
        if(isPrime){
            primenum.add(num){

            }
        }
        System.out.println("Numbers which are prime: "+ primenum);
    }
}
