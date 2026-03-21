package com.gla.ExceptionHandling.NestedTryCatchBlock;

public class ArrayDivisionHandler {
    public static void main(String[] args) {
        int[] array = {10, 20, 30, 40, 50};
        int index = 5;
        int divisor = 0;

        try {

            int result = array[index] / divisor;
            System.out.println("Division result: " + result);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid array index!");
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero!");
        }
    }
}
