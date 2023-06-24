package com.designpattern.adapter.adapwithargus;

public class EmployeeRatingMapper {

    public EmployeeRating getEmployeeRating(CustomerRating customerRating) {
        EmployeeRating employeeRating = new EmployeeRating();
        employeeRating.setRating(customerRating.getRating());
        return employeeRating;
    }
}
