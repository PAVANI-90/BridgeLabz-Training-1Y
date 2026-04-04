package com.gla.WrapperClass.ScenarioBased;
import java.util.*;
public class EmployeeDataProcessing {
    public static void main(String[] args){
        int[] ages = {25, 30, 22, 45, 35, 28};
        ArrayList<Integer> ageList = new ArrayList<>();
        for (int age : ages) {
            ageList.add(age);
        }
        int youngest = Collections.min(ageList);
        int oldest = Collections.max(ageList);

        System.out.println("Youngest employee age: " + youngest);
        System.out.println("Oldest employee age: " + oldest);
    }
}
