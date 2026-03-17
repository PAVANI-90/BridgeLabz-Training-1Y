package com.gla.JavaPackage;

public class DerivedTester extends Base {

    public void testAccess() {
        System.out.println("Accessing methods from Base class:");

        publicMethod();
        protectedMethod();

    }

    public static void main(String[] args) {
        DerivedTester obj = new DerivedTester();
        obj.testAccess();
    }
}
