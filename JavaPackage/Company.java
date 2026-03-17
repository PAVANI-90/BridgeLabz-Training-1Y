package com.gla.JavaPackage;

public class Company {
    public static void main(String[] args) {

        SalesReport sales = new SalesReport();
        EmployeeReport hr = new EmployeeReport();

        sales.showSales();
        hr.showReport();
    }

}

