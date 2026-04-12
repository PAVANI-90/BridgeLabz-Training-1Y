package com.gla.GenericsAndCollections.JavaCollection.QueueInterface;
import java.util.*;
public class GenerateBinaryNumbers {
    public static List<String> generateBinary(int n) {
        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();


        queue.add("1");

        while (n-- > 0) {
            String s = queue.poll();
            result.add(s);


            queue.add(s + "0");
            queue.add(s + "1");
        }

        return result;
    }

    public static void main(String[] args) {
        int n = 5;
        List<String> binaries = generateBinary(n);

        System.out.println("First " + n + " binary numbers:");
        System.out.println(binaries);
    }
}
