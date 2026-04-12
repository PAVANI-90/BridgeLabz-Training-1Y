package com.gla.GenericsAndCollections.Generics;
class Box<T> {
    private T value;

    public void set(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }
}

public class GenericBoxTest {
    public static void main(String[] args) {
        // Integer storing
        Box<Integer> intBox = new Box<>();
        intBox.set(42);
        System.out.println("Integer: " + intBox.get());

        // String storing
        Box<String> stringBox = new Box<>();
        stringBox.set("Hello");
        System.out.println("String: " + stringBox.get());

        // Double storing
        Box<Double> doubleBox = new Box<>();
        doubleBox.set(3.14);
        System.out.println("Double: " + doubleBox.get());
    }
}
