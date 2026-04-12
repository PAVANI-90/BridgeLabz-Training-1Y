package com.gla.GenericsAndCollections.JavaCollection.ScenarioBased;
import java.util.*;

public class CustomerFeedbackAnaly {
    private List<String> allFeedback;
    private Set<String> uniqueFeedback;
    private Queue<String> processingQueue;
    private Stack<String> recentFeedback;

    public CustomerFeedbackAnaly() {
        this.allFeedback = new ArrayList<>();
        this.uniqueFeedback = new HashSet<>();
        this.processingQueue = new LinkedList<>();
        this.recentFeedback = new Stack<>();
    }

    public void addFeedback(String feedback) {
        allFeedback.add(feedback);
        if (uniqueFeedback.add(feedback)) {
            processingQueue.add(feedback);
        }
        recentFeedback.push(feedback);
        System.out.println("Added feedback: " + feedback);
    }

    public void processFeedback() {
        System.out.println("\nProcessing feedback sequentially:");
        while (!processingQueue.isEmpty()) {
            String fb = processingQueue.poll();
            System.out.println("  Processing: " + fb);
        }
    }

    public void showLastNFeedbacks(int n) {
        System.out.println("\nLast " + n + " feedback(s):");
        int count = 0;
        Iterator<String> it = recentFeedback.iterator();
        List<String> temp = new ArrayList<>();
        while (it.hasNext()) {
            temp.add(it.next());
        }
        for (int i = temp.size() - 1; i >= 0 && count < n; i--) {
            System.out.println("  " + temp.get(i));
            count++;
        }
    }

    public static void main(String[] args) {
        CustomerFeedbackAnaly system = new CustomerFeedbackAnaly();

        system.addFeedback("App is very user friendly.");
        system.addFeedback("Need dark mode feature.");
        system.addFeedback("Customer support is slow.");
        system.addFeedback("App is very user friendly.");
        system.addFeedback("Great performance and UI.");

        system.processFeedback();
        system.showLastNFeedbacks(3);
    }
}
