package com.gla.GenericsAndCollections.Map.ScenarioBased;
import java.util.*;

public class CountryCapitalLookup {
    public static void main(String[] args) {
        Map<String, String> countryCapital = new HashMap<>();

        countryCapital.put("India", "New Delhi");
        countryCapital.put("USA", "Washington, D.C.");
        countryCapital.put("France", "Paris");
        countryCapital.put("Germany", "Berlin");
        countryCapital.put("Japan", "Tokyo");
        countryCapital.put("Canada", "Ottawa");
        countryCapital.put("Australia", "Canberra");
        countryCapital.put("Brazil", "Brasília");

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter country name: ");
        String country = sc.nextLine().trim();

        String capital = countryCapital.get(country);
        if (capital == null) {
            System.out.println("Unknown country");
        } else {
            System.out.println("Capital of " + country + " is " + capital);
        }

        System.out.println("\nAll countries and capitals (sorted by country):");
        Map<String, String> sorted = new TreeMap<>(countryCapital);
        for (Map.Entry<String, String> e : sorted.entrySet()) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }

        sc.close();
    }
}
