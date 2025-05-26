package org.example.objectadap;

import org.example.common.Customer;
import org.example.common.Employee;

public class EmployeeObjectAdapter implements Customer {

    private Employee employee;

    public EmployeeObjectAdapter(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String getName() {
        return employee.getFullName();
    }

    @Override
    public String getDesignation() {
        return employee.getJobTitle();
    }

    @Override
    public String getAddrerss() {
        return employee.getOfficeLocation();
    }
}
