package com.gla.GenericsAndCollections.JavaCollection.ListInterface;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
public class ReverseList {
    public static void reverseList(List<Integer> list) {
        int size = list.size();
        for (int i = 0; i < size / 2; i++) {
            Integer temp = list.get(i);
            list.set(i, list.get(size - 1 - i));
            list.set(size - 1 - i, temp);
        }
    }
    public static List<Integer> reversedList(List<Integer> list) {
        List<Integer> reversed = new ArrayList<>(list.size());
        for (int i = list.size() - 1; i >= 0; i--) {
            reversed.add(list.get(i));
        }
        return reversed;
    }
    public static void main(String[] args) {
        // Example: ArrayList
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);

        System.out.println("ArrayList before: " + arrayList);
        reverseList(arrayList);
        System.out.println("ArrayList after: " + arrayList);

        // Example: LinkedList
        List<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);

        System.out.println("LinkedList before: " + linkedList);
        reverseList(linkedList);
        System.out.println("LinkedList after: " + linkedList);


        List<Integer> original = List.of(1, 2, 3, 4, 5);
        List<Integer> reversed = reversedList(original);
        System.out.println("Original: " + original);
        System.out.println("Reversed: " + reversed);
    }
}
