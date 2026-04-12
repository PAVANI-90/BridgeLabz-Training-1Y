package com.gla.GenericsAndCollections.JavaCollection.ListInterface;
import java.util.*;
public class NthFromEnd {
    public static <T> T findNthFromEnd(List<T> list, int n) {
        if (n <= 0 || list.isEmpty()) {
            throw new IllegalArgumentException("Invalid n or empty list.");
        }

        ListIterator<T> fast = list.listIterator();
        ListIterator<T> slow = list.listIterator();
        for (int i = 0; i < n; i++) {
            if (!fast.hasNext()) {
                throw new IllegalArgumentException("List has fewer than " + n + " elements.");
            }
            fast.next();
        }
        while (fast.hasNext()) {
            fast.next();
            slow.next();
        }
        return slow.next();
    }

    public static void main(String[] args) {
        List<Character> input = Arrays.asList('A', 'B', 'C', 'D', 'E');
        int n = 2;

        System.out.println("List: " + input); // [A, B, C, D, E]
        Character result = findNthFromEnd(input, n);
        System.out.println("Nth from end (N=" + n + "): " + result); // D
    }
}
