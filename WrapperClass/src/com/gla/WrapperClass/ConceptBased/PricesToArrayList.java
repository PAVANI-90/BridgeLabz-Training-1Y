package com.gla.WrapperClass.ConceptBased;
import java.util.ArrayList;
public class PricesToArrayList {
    public static void main(String[] args){
        double[] prices = {10.5, 20.0, 35.75, 5.5};
        ArrayList<Double> priceList = new ArrayList<>();
        for (double price : prices) {
            priceList.add(price);
        }
        double maxPrice = priceList.get(0);
        for (Double price : priceList) {
            if (price > maxPrice) {
                maxPrice = price;
            }
        }
        double sum = 0;
        for (Double price : priceList) {
            sum += price;
        }
        double average = sum / priceList.size();
        System.out.println("Highest price: " + maxPrice);
        System.out.println("Average price: " + average);

    }
}
