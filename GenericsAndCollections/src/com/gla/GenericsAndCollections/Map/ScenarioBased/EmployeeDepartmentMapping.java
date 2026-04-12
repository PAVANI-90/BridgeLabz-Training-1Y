package com.gla.GenericsAndCollections.Map.ScenarioBased;
import java.util.*;

public class EmployeeDepartmentMapping {
    private Map<Integer, String> empDeptMap = new HashMap<>();

    public void addEmployee(int empId, String department) {
        empDeptMap.put(empId, department);
    }

    public void changeDepartment(int empId, String newDepartment) {
        if (!empDeptMap.containsKey(empId)) {
            System.out.println("Employee ID not found: " + empId);
            return;
        }
        empDeptMap.put(empId, newDepartment);
        System.out.println("Employee " + empId + " moved to " + newDepartment);
    }

    public List<Integer> getEmployeesInDepartment(String department) {
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, String> entry : empDeptMap.entrySet()) {
            if (entry.getValue().equalsIgnoreCase(department)) {
                result.add(entry.getKey());
            }
        }
        return result;
    }

    public void printEmployeeCountPerDepartment() {
        Map<String, Integer> deptCount = new HashMap<>();
        for (String dept : empDeptMap.values()) {
            deptCount.put(dept, deptCount.getOrDefault(dept, 0) + 1);
        }
        System.out.println("Employees per department:");
        for (Map.Entry<String, Integer> entry : deptCount.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public void printAllEmployees() {
        System.out.println("Employee -> Department mapping:");
        for (Map.Entry<Integer, String> entry : empDeptMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        EmployeeDepartmentMapping system = new EmployeeDepartmentMapping();

        system.addEmployee(101, "IT");
        system.addEmployee(102, "HR");
        system.addEmployee(103, "Finance");
        system.addEmployee(104, "IT");
        system.addEmployee(105, "Sales");
        system.addEmployee(106, "HR");

        system.printAllEmployees();

        system.changeDepartment(105, "Marketing");
        system.changeDepartment(999, "IT");

        system.printAllEmployees();

        String searchDept = "IT";
        List<Integer> itEmployees = system.getEmployeesInDepartment(searchDept);
        System.out.println("Employees in " + searchDept + ": " + itEmployees);

        system.printEmployeeCountPerDepartment();
    }
}
