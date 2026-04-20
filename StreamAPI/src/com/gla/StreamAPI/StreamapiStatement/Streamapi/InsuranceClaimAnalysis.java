package com.gla.StreamAPI.StreamapiStatement.Streamapi;
import java.util.*;
import java.util.stream.Collectors;

class InsuranceClaim {
    String claimId;
    String claimType;
    double amount;

    InsuranceClaim(String claimId, String claimType, double amount) {
        this.claimId = claimId;
        this.claimType = claimType;
        this.amount = amount;
    }

    String getClaimType() {
        return claimType;
    }

    double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return claimId + " [" + claimType + "] : " + amount;
    }
}
public class InsuranceClaimAnalysis {
    public static void main(String[] args) {

        List<InsuranceClaim> claims = Arrays.asList(
                new InsuranceClaim("C001", "HEALTH", 12000.0),
                new InsuranceClaim("C002", "AUTO",   5000.0),
                new InsuranceClaim("C003", "HOME",   8000.0),
                new InsuranceClaim("C004", "HEALTH", 15000.0),
                new InsuranceClaim("C005", "AUTO",   7000.0),
                new InsuranceClaim("C006", "HOME",   6000.0),
                new InsuranceClaim("C007", "HEALTH", 9000.0)
        );


        Map<String, Double> avgAmountByType = claims.stream()
                .collect(Collectors.groupingBy(
                        InsuranceClaim::getClaimType,
                        Collectors.averagingDouble(InsuranceClaim::getAmount)
                ));

        avgAmountByType.forEach((type, avg) ->
                System.out.println(type + " -> Average Amount: " + avg)
        );
    }
}
