package com.gla.JavaPackage;

import static java.lang.Math.pow;
public class InterestCalculator {
    public static double calculateSimpleInterest(double P, double R, double T) {
        return (P * R * T) / 100;
    }

    public static double calculateCompoundInterest(double P, double R, double T) {
        return P * (pow(1 + R/100, T)) - P;
    }

}

