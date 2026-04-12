package com.gla.GenericsAndCollections.Map.MapInterface;
import java.util.*;

public class InvertMapExample {
    public static <K, V> Map<V, List<K>> invertMap(Map<K, V> original) {
        Map<V, List<K>> inverted = new HashMap<>();
        for (Map.Entry<K, V> entry : original.entrySet()) {
            V value = entry.getValue();
            K key = entry.getKey();
            inverted.computeIfAbsent(value, k -> new ArrayList<>()).add(key);
        }
        return inverted;
    }

    public static void main(String[] args) {
        Map<String, Integer> original = new HashMap<>();
        original.put("A", 1);
        original.put("B", 2);
        original.put("C", 1);

        Map<Integer, List<String>> inverted = invertMap(original);
        System.out.println(inverted); // {1=[A, C], 2=[B]}
    }
}
