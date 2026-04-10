package com.gla.Collectionframework;
import java.util.*;
public class LinkedListExample {
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(11);
        ll.add(22);
        ll.add(33);
        ll.add(44);
        System.out.println(ll);
        LinkedList<Integer> ll2 = new LinkedList<>();
        ll2.add(10);
        ll2.add(20);
        ll2.add(30);
        ll.addAll(ll2);
        System.out.println(ll);
    }
}
