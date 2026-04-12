package com.gla.GenericsAndCollections.JavaCollection.QueueInterface;
import java.util.*;
public class StackUsingQueues {
    public static class MyStack {
        private Queue<Integer> mainQueue;
        private Queue<Integer> helperQueue;
        private int size;

        public MyStack() {
            mainQueue = new LinkedList<>();
            helperQueue = new LinkedList<>();
            size = 0;
        }


        public void push(int x) {
            helperQueue.add(x);

            while (!mainQueue.isEmpty()) {
                helperQueue.add(mainQueue.remove());
            }

            Queue<Integer> temp = mainQueue;
            mainQueue = helperQueue;
            helperQueue = temp;
            size++;
        }


        public int pop() {
            if (isEmpty()) {
                throw new RuntimeException("Stack is empty");
            }
            size--;
            return mainQueue.remove();
        }


        public int top() {
            if (isEmpty()) {
                throw new RuntimeException("Stack is empty");
            }
            return mainQueue.peek();
        }

        // Check if stack is empty
        public boolean isEmpty() {
            return mainQueue.isEmpty();
        }

        // Optional: show internal state for debugging
        public String toString() {
            return "Stack: " + mainQueue.toString();
        }
    }


    public static void main(String[] args) {
        MyStack stack = new MyStack();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack);

        System.out.println("Top: " + stack.top());
        System.out.println("Pop: " + stack.pop());
        System.out.println("New top: " + stack.top());
    }
}
