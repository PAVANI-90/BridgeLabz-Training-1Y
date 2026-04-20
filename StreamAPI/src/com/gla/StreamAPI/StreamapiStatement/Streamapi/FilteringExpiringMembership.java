package com.gla.StreamAPI.StreamapiStatement.Streamapi;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

class Member {
    String name;
    LocalDate expiryDate;

    Member(String name, LocalDate expiryDate) {
        this.name = name;
        this.expiryDate = expiryDate;
    }

    String getName() {
        return name;
    }

    LocalDate getExpiryDate() {
        return expiryDate;
    }

    @Override
    public String toString() {
        return name + " (expires on " + expiryDate + ")";
    }
}
public class FilteringExpiringMembership {
    public static void main(String[] args) {

        List<Member> members = Arrays.asList(
                new Member("Aman",  LocalDate.now().plusDays(5)),
                new Member("Bhavya",LocalDate.now().plusDays(15)),
                new Member("Chirag",LocalDate.now().plusDays(40)),
                new Member("Diya",  LocalDate.now().minusDays(2)),
                new Member("Esha",  LocalDate.now().plusDays(30)),
                new Member("Farhan",LocalDate.now().plusDays(60))
        );

        LocalDate today = LocalDate.now();
        LocalDate cutoff = today.plusDays(30);

        List<Member> expiringSoon = members.stream()
                .filter(m -> {
                    LocalDate expiry = m.getExpiryDate();
                    return !expiry.isBefore(today) && !expiry.isAfter(cutoff);

                })
                .collect(Collectors.toList());

        System.out.println("Members whose membership expires in the next 30 days:");
        expiringSoon.forEach(System.out::println);
    }

}
