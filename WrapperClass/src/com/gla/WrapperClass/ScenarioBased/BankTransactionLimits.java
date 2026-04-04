package com.gla.WrapperClass.ScenarioBased;

public class BankTransactionLimits {
    public static double getWithdrawalLimit(Double limitObj, double legacyLimit) {
        if (limitObj != null) {
            return limitObj;
        }
        return legacyLimit;
    }

    public static void main(String[] args) {

        Double dbLimit1 = 5000.0;
        Double dbLimit2 = null;
        double legacyLimit1 = 3000.0;
        double legacyLimit2 = 0.0;

        System.out.println("DB Double (5000): " + getWithdrawalLimit(dbLimit1, 0));
        System.out.println("DB Null: " + getWithdrawalLimit(dbLimit2, 0));
        System.out.println("Legacy double (3000): " + getWithdrawalLimit(null, legacyLimit1));
        System.out.println("Zero limit: " + getWithdrawalLimit(null, legacyLimit2));
    }
}
