package com.gla.GenericsAndCollections.Map.MapInterface;
import java.io.*;
import java.util.*;

public class WordFrequencyCounter {
    public static Map<String, Integer> countWords(File file) throws IOException {
        Map<String, Integer> freq = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.toLowerCase().replaceAll("[^a-z0-9]+", " ");
                String[] words = line.trim().split("\\s+");
                for (String w : words) {
                    if (w.isEmpty()) continue;
                    freq.put(w, freq.getOrDefault(w, 0) + 1);
                }
            }
        }
        return freq;
    }

    public static void main(String[] args) throws IOException {
        File file = new File("input.txt");
        Map<String, Integer> freq = countWords(file);
        System.out.println(freq);
    }
}
