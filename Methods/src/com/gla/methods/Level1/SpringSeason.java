package com.gla.methods.Level1;
import java.util.Scanner;

public class SpringSeason {

    public static boolean isSpringSeason(int month, int day) {
        if (month == 3 && day >= 20) return true;
        if (month == 4 || month == 5) return true;
        if (month == 6 && day <= 20) return true;
        return false;
    }

    public static void main(String[] args) {
        int month, day;
        if (args.length == 2) {
            month = Integer.parseInt(args[0]);
            day = Integer.parseInt(args[1]);
        } else {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter month (1-12): ");
            month = sc.nextInt();
            System.out.print("Enter day (1-31): ");
            day = sc.nextInt();
            sc.close();
        }
        if (isSpringSeason(month, day)) {
            System.out.println("It's a Spring Season");
        } else {
            System.out.println("Not a Spring Season");
        }
    }
}
