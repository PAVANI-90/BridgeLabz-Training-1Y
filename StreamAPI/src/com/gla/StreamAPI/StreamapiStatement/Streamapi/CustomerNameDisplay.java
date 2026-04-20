package com.gla.StreamAPI.StreamapiStatement.Streamapi;
import java.util.*;
import java.util.stream.Collectors;

public class CustomerNameDisplay {
    public static void main(String[] args) {

        List<String> customerNames = Arrays.asList(
                "rahul",
                "Anita",
                "mohit",
                "Zara",
                "kiran"
        );

        List<String> displayNames = customerNames.stream()
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());

        System.out.println("Customer names for display (UPPERCASE & sorted):");
        displayNames.forEach(System.out::println);
    }
}
