package com.gla.GenericsAndCollections.Map.ScenarioBased;
import java.util.*;

public class WordFrequencyInSentence {
    public static void main(String[] args) {
        String sentence = "Java is fun, and Java is powerful!";

        sentence = sentence.toLowerCase().replaceAll("[^a-z0-9\\s]", " ");
        String[] words = sentence.trim().split("\\s+");

        Map<String, Integer> freq = new HashMap<>();

        for (String w : words) {
            if (w.isEmpty()) continue;
            freq.put(w, freq.getOrDefault(w, 0) + 1);
        }

        for (Map.Entry<String, Integer> e : freq.entrySet()) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }
    }
}
