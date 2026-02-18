package com.gla.methods.Level3;
import java.util.Arrays;
public class OTPGenerator {
    public static int generateOTP() {
        return (int) (Math.random() * 900000) + 100000;
    }
    public static boolean areOTPsUnique() {
        int[] otps = new int[10];
        for (int i = 0; i < 10; i++) {
            otps[i] = generateOTP();
        }
        for (int i = 0; i < 10; i++) {
            for (int j = i + 1; j < 10; j++) {
                if (otps[i] == otps[j]) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println("Generating 10 unique 6-digit OTPs...");
        int attempts = 0;
        boolean unique;
        int[] finalOTPs;
        do {
            attempts++;
            finalOTPs = new int[10];
            for (int i = 0; i < 10; i++) {
                finalOTPs[i] = generateOTP();
            }
            unique = true;
            for (int i = 0; i < 10; i++) {
                for (int j = i + 1; j < 10; j++) {
                    if (finalOTPs[i] == finalOTPs[j]) {
                        unique = false;
                        break;
                    }
                }
                if (!unique) break;
            }
        } while (!unique && attempts < 1000);
        System.out.println("Attempts needed: " + attempts);
        System.out.print("10 Unique OTPs: ");
        for (int otp : finalOTPs) {
            System.out.printf("%06d ", otp);
        }
        System.out.println();
        System.out.println("All OTPs are UNIQUE: " + unique);
    }
}

