package com.gla.WrapperClass.ConceptBased;
import java.util.Scanner;
public class PrimitiveToWrapper {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int primitive = sc.nextInt();   // this is primitive int i/p
        // Integer wrapper = Integer.valueOf(primitive); // internally conversion through compiler
        Integer wrapper = primitive ;
        System.out.println("Primitive form (int): " + primitive);
        System.out.println("Wrapper form (Integer): " + wrapper);
        System.out.println("Wrapper class name: " + wrapper.getClass().getSimpleName());
        sc.close();

    }
}
