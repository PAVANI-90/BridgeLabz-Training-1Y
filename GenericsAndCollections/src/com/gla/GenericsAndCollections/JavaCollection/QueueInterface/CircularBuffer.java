package com.gla.GenericsAndCollections.JavaCollection.QueueInterface;
import java.util.*;
public class CircularBuffer {
    private int[] arr;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public CircularBuffer(int capacity) {
        this.capacity = capacity;
        this.arr = new int[capacity];
        this.front = 0;
        this.rear = 0;
        this.size = 0;
    }


    public void insert(int x) {
        if (size == capacity) {

            arr[rear] = x;
            front = (front + 1) % capacity;

        } else {

            arr[rear] = x;
            rear = (rear + 1) % capacity;
            size++;
        }
    }


    public List<Integer> toList() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int idx = (front + i) % capacity;
            list.add(arr[idx]);
        }
        return list;
    }


    public boolean isEmpty() { return size == 0; }
    public boolean isFull()  { return size == capacity; }

    @Override
    public String toString() {
        return "CircularBuffer{" + toList() + "}";
    }


    public static void main(String[] args) {
        CircularBuffer buf = new CircularBuffer(3);

        buf.insert(1);
        buf.insert(2);
        buf.insert(3);
        System.out.println("After 1,2,3: " + buf);

        buf.insert(4);
        System.out.println("After 4:     " + buf);
    }
}
