package com.gla.StreamAPI.StreamapiStatement.forEachMethod;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class TransactionLogger {
    public static void main(String[] args) {

        List<String> transactionIds = Arrays.asList(
                "TXN-1001",
                "TXN-1002",
                "TXN-1003",
                "TXN-1004"
        );

        transactionIds.forEach(id ->
                System.out.println(LocalDateTime.now() + " - Transaction: " + id)
        );
    }
}
