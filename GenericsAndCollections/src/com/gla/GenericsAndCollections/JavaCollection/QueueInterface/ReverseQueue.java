package com.gla.GenericsAndCollections.JavaCollection.QueueInterface;
import java.util.*;
public class ReverseQueue {
    public static void reverseQueue(Queue<Integer> q) {
        Stack<Integer> stack = new Stack<>();


        while (!q.isEmpty()) {
            stack.push(q.remove());
        }


        while (!stack.isEmpty()) {
            q.add(stack.pop());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);

        System.out.println("Before reverse: " + queue); // [10, 20, 30]

        reverseQueue(queue);

        System.out.println("After reverse:  " + queue); // [30, 20, 10]
    }
}
