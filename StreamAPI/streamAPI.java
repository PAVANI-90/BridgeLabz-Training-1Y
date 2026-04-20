package com.gla.streamapi;
import java.util.ArrayList;
import java.util.stream.Stream;
public class streamAPI {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6);
        stream.forEach(a -> System.out.println(a));
        Stream<String> stm = Stream.of("aa", "bb", "cc");
        stm.forEach(System.out::println);

        // Second way to create stream using stream()
        ArrayList<Integer> al = new ArrayList<>();
        al.add(11);
        al.add(22);
        al.add(33);
        al.add(44);
        al.add(55);
        System.out.println("======Using stream() method=====");
        Stream<Integer> stream1 = al.stream();
        // stream1.forEach(a->System.out.println(a));
        stream1.forEach(System.out::println);


        Stream<String> stream2 = Stream.of("Anubhav", "Anushka", "Virat", "Rohit", "Hardik");
        stream2.filter(n->n.startsWith("A")).forEach(System.out::println);
        // task 1
        ArrayList<Integer> num = new ArrayList<>();
        num.add(10);
        num.add(20);
        num.add(30);
        num.add(40);
        num.add(50);
        Stream<Integer> stream3 = num.stream();
        Stream<Integer> FilterStream = stream3.filter(i->i%2==0);
        FilterStream.forEach(System.out::println);
        num.stream().filter(i->i%2==0).forEach(System.out::println);
    }
}
