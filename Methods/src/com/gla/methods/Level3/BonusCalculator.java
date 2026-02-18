package com.gla.methods.Level3;
public class BonusCalculator {
    public static int[][] generateEmployeeData() {
        int[][] data = new int[10][2];
        for (int i = 0; i < 10; i++) {
            data[i][0] = (int) (Math.random() * 90000) + 10000;
            data[i][1] = (int) (Math.random() * 20) + 1;
        }
        return data;
    }
    public static double[][] calculateBonus(int[][] employeeData) {
        double[][] results = new double[10][4];
        for (int i = 0; i < 10; i++) {
            int salary = employeeData[i][0];
            int years = employeeData[i][1];
            double bonusRate = (years > 5) ? 0.05 : 0.02;  // Hint a
            double bonus = salary * bonusRate;
            double newSalary = salary + bonus;
            results[i][0] = salary;
            results[i][1] = years;
            results[i][2] = bonus;
            results[i][3] = newSalary;
        }
        return results;
    }
    public static double[] calculateTotals(double[][] employeeData) {
        double sumOldSalary = 0, sumNewSalary = 0, totalBonus = 0;
        for (double[] employee : employeeData) {
            sumOldSalary += employee[0];
            totalBonus += employee[2];
            sumNewSalary += employee[3];
        }
        return new double[]{sumOldSalary, totalBonus, sumNewSalary};
    }
    public static void main(String[] args) {
        int[][] employees = generateEmployeeData();
        double[][] results = calculateBonus(employees);
        double[] totals = calculateTotals(results);
        System.out.println("ZARA BONUS CALCULATOR (10 Employees)");
        System.out.println("Emp | Old Salary | Years | Bonus%% | Bonus   | New Salary");
        for (int i = 0; i < 10; i++) {
            String bonusRate = (results[i][1] > 5) ? "5%" : "2%";
            System.out.printf("%2d  | %8.0f  |  %3.0f  |  %3s  | %7.0f | %9.0f\n",
                    i + 1,
                    results[i][0], results[i][1], bonusRate,
                    results[i][2], results[i][3]);
        }
        System.out.println("\n TOTALS ");
        System.out.printf("Total Old Salary: ₹%,.0f\n", totals[0]);
        System.out.printf("Total Bonus:     ₹%,.0f\n", totals[1]);
        System.out.printf("Total New Salary:₹%,.0f\n", totals[2]);
    }
}

