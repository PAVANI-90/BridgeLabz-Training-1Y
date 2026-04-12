package com.gla.GenericsAndCollections.Map.MapInterface;
import java.util.*;
class Employee {
    private String name;
    private String department;

    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public String getName() { return name; }
    public String getDepartment() { return department; }

    @Override
    public String toString() {
        return name + " (" + department + ")";
    }
}
public class GroupEmployeesByDepartment {
    public static Map<String, List<Employee>> groupByDepartment(List<Employee> employees) {
        Map<String, List<Employee>> map = new HashMap<>();

        for (Employee e : employees) {
            String dept = e.getDepartment();
            map.computeIfAbsent(dept, k -> new ArrayList<>()).add(e);
        }
        return map;
    }

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", "HR"));
        employees.add(new Employee("Bob", "IT"));
        employees.add(new Employee("Carol", "HR"));
        employees.add(new Employee("David", "Finance"));

        Map<String, List<Employee>> byDept = groupByDepartment(employees);

        for (Map.Entry<String, List<Employee>> e : byDept.entrySet()) {
            System.out.println(e.getKey() + " : " + e.getValue());
        }
    }
}
