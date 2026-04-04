package com.gla.WrapperClass.ConceptBased;

public class WrapperToPrimitive {
    public static void main(String[] args){
        Double doubleObj = Double.valueOf(45.67);


        double primitiveDouble = doubleObj.doubleValue();
        int primitiveInt = (int) doubleObj.doubleValue();

        System.out.println("Original Double object: " + doubleObj);
        System.out.println("Primitive double: " + primitiveDouble);
        System.out.println("Primitive int (cast): " + primitiveInt);
    }
}
