package com.gla.StreamAPI.StreamapiStatement.forEachMethod;
import java.util.*;
import java.util.stream.*;

public class StockPriceLogger {
    public static void main(String[] args) {


        List<Double> stockPrices = Arrays.asList(
                101.25,
                102.10,
                100.75,
                103.40,
                102.95
        );

        System.out.println("Live stock price updates:");


        stockPrices.stream()
                .forEach(price -> System.out.println("Price update: " + price));

    }
}
