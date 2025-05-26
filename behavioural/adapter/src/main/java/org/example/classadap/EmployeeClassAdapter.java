package org.example.classadap;

import org.example.common.Customer;
import org.example.common.Employee;

public class EmployeeClassAdapter extends Employee implements Customer {

    @Override
    public String getName() {
        return this.getFullName();
    }

    @Override
    public String getDesignation() {
        return this.getJobTitle();
    }

    @Override
    public String getAddrerss() {
        return this.getOfficeLocation();
    }
}
