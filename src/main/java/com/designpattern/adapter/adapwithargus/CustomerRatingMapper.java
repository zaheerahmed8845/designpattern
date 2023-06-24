package com.designpattern.adapter.adapwithargus;

public class CustomerRatingMapper {

    public CustomerRating getCustomerRating(EmployeeRating employeeRating) {
        CustomerRating customerRating = new CustomerRating();
        customerRating.setRating(employeeRating.getRating());
        return customerRating;
    }
}
