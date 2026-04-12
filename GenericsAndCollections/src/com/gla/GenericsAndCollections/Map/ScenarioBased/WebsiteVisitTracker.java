package com.gla.GenericsAndCollections.Map.ScenarioBased;
import java.util.*;

public class WebsiteVisitTracker {
    public static void main(String[] args) {
        Map<String, Integer> visits = new HashMap<>();

        String[] pagesVisited = {
                "home", "about", "products", "home", "products",
                "contact", "home", "home", "about", "products"
        };

        for (String page : pagesVisited) {
            visits.put(page, visits.getOrDefault(page, 0) + 1);
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(visits.entrySet());
        list.sort((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()));

        System.out.println("Pages sorted by visit count (descending):");
        for (Map.Entry<String, Integer> e : list) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }

        String mostVisitedPage = null;
        int maxVisits = -1;
        for (Map.Entry<String, Integer> e : visits.entrySet()) {
            if (e.getValue() > maxVisits) {
                maxVisits = e.getValue();
                mostVisitedPage = e.getKey();
            }
        }

        System.out.println("\nMost visited page: " + mostVisitedPage +
                " with " + maxVisits + " visits");
    }
}
