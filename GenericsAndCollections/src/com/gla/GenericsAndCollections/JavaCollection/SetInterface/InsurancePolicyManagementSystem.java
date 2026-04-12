package com.gla.GenericsAndCollections.JavaCollection.SetInterface;
import java.util.*;
public class InsurancePolicyManagementSystem {
    public static class Policy implements Comparable<Policy> {
        private String policyNumber;
        private String policyholderName;
        private LocalDate expiryDate;
        private String coverageType;   // e.g., "Health", "Auto", "Home"
        private double premiumAmount;

        public Policy(String policyNumber, String policyholderName,
                      LocalDate expiryDate, String coverageType, double premiumAmount) {
            this.policyNumber = policyNumber;
            this.policyholderName = policyholderName;
            this.expiryDate = expiryDate;
            this.coverageType = coverageType;
            this.premiumAmount = premiumAmount;
        }

        // Getters
        public String getPolicyNumber() { return policyNumber; }
        public String getPolicyholderName() { return policyholderName; }
        public LocalDate getExpiryDate() { return expiryDate; }
        public String getCoverageType() { return coverageType; }
        public double getPremiumAmount() { return premiumAmount; }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Policy)) return false;
            Policy p = (Policy) o;
            return policyNumber.equals(p.policyNumber);
        }

        @Override
        public int hashCode() {
            return policyNumber.hashCode();
        }

        @Override
        public int compareTo(Policy other) {
            // Sort by expiryDate first, then by policyNumber for stability
            int dateCmp = this.expiryDate.compareTo(other.expiryDate);
            if (dateCmp != 0) return dateCmp;
            return this.policyNumber.compareTo(other.policyNumber);
        }

        @Override
        public String toString() {
            return String.format(
                    "Policy{#%s, %s, Exp=%s, Type=%s, Premium=%.2f}",
                    policyNumber, policyholderName, expiryDate, coverageType, premiumAmount
            );
        }
    }

    // PolicyStore using HashSet, LinkedHashSet, TreeSet
    public static class PolicyStore {
        private Set<Policy> hashSet;      // for fast lookup
        private Set<Policy> linkedHashSet; // insertion order
        private Set<Policy> treeSet;       // sorted by expiry date

        public PolicyStore() {
            this.hashSet      = new HashSet<>();
            this.linkedHashSet = new LinkedHashSet<>();
            this.treeSet       = new TreeSet<>();
        }

        // Add a policy (only if policyNumber is unique)
        public boolean addPolicy(Policy p) {
            if (!hashSet.add(p)) {
                return false; // duplicate policy number
            }
            linkedHashSet.add(p);
            treeSet.add(p);
            return true;
        }

        // All unique policies
        public Set<Policy> getAllPolicies() {
            return new HashSet<>(hashSet);
        }

        // Policies expiring within next 30 days
        public Set<Policy> getExpiringSoon(LocalDate today, int daysThreshold) {
            Set<Policy> result = new HashSet<>();
            LocalDate threshold = today.plusDays(daysThreshold);
            for (Policy p : hashSet) {
                if (!p.getExpiryDate().isBefore(today) &&
                        p.getExpiryDate().compareTo(threshold) <= 0) {
                    result.add(p);
                }
            }
            return result;
        }

        // Policies with a specific coverage type
        public Set<Policy> getPoliciesByCoverage(String coverageType) {
            Set<Policy> result = new HashSet<>();
            for (Policy p : hashSet) {
                if (p.getCoverageType().equalsIgnoreCase(coverageType)) {
                    result.add(p);
                }
            }
            return result;
        }

        // Find duplicates by policy number (in external list)
        public Set<Policy> findDuplicates(Collection<Policy> candidates) {
            Set<String> seenNumbers = new HashSet<>();
            Set<Policy> duplicates = new HashSet<>();
            for (Policy p : candidates) {
                if (!seenNumbers.add(p.getPolicyNumber())) {
                    duplicates.add(p);
                }
            }
            return duplicates;
        }

        // Remove a policy by policyNumber
        public boolean removePolicy(String policyNumber) {
            Policy dummy = new Policy(policyNumber, "", LocalDate.now(), "", 0.0);
            if (!hashSet.contains(dummy)) return false;

            hashSet.remove(dummy);
            linkedHashSet.remove(dummy);
            treeSet.remove(dummy);
            return true;
        }

        // Find a policy by policyNumber
        public Policy findPolicy(String policyNumber) {
            Policy dummy = new Policy(policyNumber, "", LocalDate.now(), "", 0.0);
            for (Policy p : hashSet) {
                if (p.equals(dummy)) return p;
            }
            return null;
        }
    }

    // Simple performance‑benchmark class
    public static class PerformanceBenchmark {
        private Set<Policy> hashStore   = new HashSet<>();
        private Set<Policy> linkedStore = new LinkedHashSet<>();
        private Set<Policy> treeStore   = new TreeSet<>();

        public void add(Policy p) {
            hashStore.add(p);
            linkedStore.add(p);
            treeStore.add(p);
        }

        public void remove(String policyNumber) {
            Policy dummy = new Policy(policyNumber, "", LocalDate.now(), "", 0.0);
            hashStore.remove(dummy);
            linkedStore.remove(dummy);
            treeStore.remove(dummy);
        }

        public boolean contains(String policyNumber) {
            Policy dummy = new Policy(policyNumber, "", LocalDate.now(), "", 0.0);
            return hashStore.contains(dummy);
        }

        public void runBenchmark(int size) {
            List<Policy> policies = new ArrayList<>();
            Random rand = new Random();
            for (int i = 0; i < size; i++) {
                LocalDate exp = LocalDate.now().plusDays(100 + rand.nextInt(1000));
                Policy p = new Policy(
                        "P" + i,
                        "Holder" + i,
                        exp,
                        "Health",
                        1000.0 + rand.nextDouble() * 2000
                );
                policies.add(p);
            }

            // 1. Add
            long t1 = System.nanoTime();
            for (Policy p : policies) add(p);
            long t2 = System.nanoTime();
            System.out.printf("Add %d policies: %.2f ms\n", size, (t2 - t1) / 1_000_000.0);

            // 2. Search (find half of them)
            int count = 0;
            t1 = System.nanoTime();
            for (int i = 0; i < size / 2; i++) {
                if (contains("P" + i)) count++;
            }
            t2 = System.nanoTime();
            System.out.printf("Search %d policies: %.2f ms\n", size / 2, (t2 - t1) / 1_000_000.0);

            // 3. Remove half
            t1 = System.nanoTime();
            for (int i = 0; i < size / 2; i++) {
                remove("P" + i);
            }
            t2 = System.nanoTime();
            System.out.printf("Remove %d policies: %.2f ms\n", size / 2, (t2 - t1) / 1_000_000.0);
        }
    }

    // Main demo
    public static void main(String[] args) {
        PolicyStore store = new PolicyStore();

        // Add sample policies
        store.addPolicy(new Policy("P001", "Rohit Kumar",
                LocalDate.now().plusDays(10), "Health", 1200.0));
        store.addPolicy(new Policy("P002", "Amit Sharma",
                LocalDate.now().plusDays(35), "Auto", 2500.0));
        store.addPolicy(new Policy("P003", "Priya Singh",
                LocalDate.now().plusDays(20), "Home", 1800.0));
        store.addPolicy(new Policy("P004", "Vikas Patel",
                LocalDate.now().plusDays(5), "Health", 900.0));

        // 1. All policies
        System.out.println("\nAll policies:");
        store.getAllPolicies().forEach(System.out::println);

        // 2. Expiring soon (within next 30 days)
        System.out.println("\nExpiring within next 30 days:");
        store.getExpiringSoon(LocalDate.now(), 30).forEach(System.out::println);

        // 3. By coverage type
        System.out.println("\nPolicies of type 'Health':");
        store.getPoliciesByCoverage("Health").forEach(System.out::println);

        // 4. Performance benchmark (HashSet / LinkedHashSet / TreeSet)
        System.out.println("\n=== Performance benchmark (HashSet / LinkedHashSet / TreeSet) ===");
        PerformanceBenchmark bench = new PerformanceBenchmark();
        bench.runBenchmark(10_000);
    }
}
