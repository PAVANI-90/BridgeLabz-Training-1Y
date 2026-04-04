package com.gla.WrapperClass.ScenarioBased;
import java.util.ArrayList;
public class StudentMarksReport {
    public static void main(String[] args){
        Object[] rawMarks = {
                "85",      // String
                95,        // primitive int
                Integer.valueOf(88),
                "null",
                "abc",
                92
        };

        ArrayList<Integer> validMarks = new ArrayList<>();
        for (Object mark : rawMarks) {
            try {
                if (mark instanceof String str) {
                    if (!"null".equals(str.trim())) {
                        validMarks.add(Integer.parseInt(str));
                    }
                } else if (mark instanceof Number num) {
                    validMarks.add(num.intValue());
                }
            } catch (NumberFormatException e) {

            }
        }
        int sum = 0;
        for (Integer m : validMarks) {
            sum += m;
        }
        double average = validMarks.isEmpty() ? 0 : (double) sum / validMarks.size();

        System.out.println("Raw inputs: " + java.util.Arrays.toString(rawMarks));
        System.out.println("Valid marks: " + validMarks);
        System.out.printf("Average: %.2f%n", average);
    }
}
