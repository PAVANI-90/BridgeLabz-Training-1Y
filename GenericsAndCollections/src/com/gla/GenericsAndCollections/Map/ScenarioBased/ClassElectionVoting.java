package com.gla.GenericsAndCollections.Map.ScenarioBased;
import java.util.*;

public class ClassElectionVoting {
    public static void main(String[] args) {
        Map<String, Integer> voteCount = new HashMap<>();

        String[] votes = {
                "Alice", "Bob", "Alice", "Carol", "Bob",
                "Alice", "Bob", "Bob", "Carol", "David"
        };

        for (String candidate : votes) {
            voteCount.put(candidate, voteCount.getOrDefault(candidate, 0) + 1);
        }

        String winner = null;
        int maxVotes = -1;

        for (Map.Entry<String, Integer> entry : voteCount.entrySet()) {
            String candidate = entry.getKey();
            int count = entry.getValue();
            if (count > maxVotes) {
                maxVotes = count;
                winner = candidate;
            }
        }

        System.out.println("Final vote counts:");
        for (Map.Entry<String, Integer> entry : voteCount.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        System.out.println("\nWinner: " + winner + " with " + maxVotes + " votes");
    }
}
