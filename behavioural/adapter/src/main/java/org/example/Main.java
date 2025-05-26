package org.example;

import org.example.classadap.EmployeeClassAdapter;
import org.example.common.BusinessCardDesigner;
import org.example.common.Employee;
import org.example.objectadap.EmployeeObjectAdapter;

public class Main {

    public static void main(String[] args) {
        /**  Using Class /Two-way Adapter**/
        EmployeeClassAdapter employeeClassAdapter = new EmployeeClassAdapter();
        populateEmployeeData(employeeClassAdapter);
        BusinessCardDesigner designer = new BusinessCardDesigner();
        String card = designer.designCard(employeeClassAdapter);
        System.out.println(card);

        /** Using Object Adapter **/
        Employee employee = new Employee();
        populateEmployeeData(employee);
        EmployeeObjectAdapter employeeObjectAdapter = new EmployeeObjectAdapter(employee);
        card = designer.designCard(employeeObjectAdapter);
        System.out.println(card);
    }

    private static void populateEmployeeData(Employee employee) {
        employee.setFullName("Elliot Alderson");
        employee.setJobTitle("Security Engineer");
        employee.setOfficeLocation("Allsafe Cybersecurity, New York City, New York");
    }
}