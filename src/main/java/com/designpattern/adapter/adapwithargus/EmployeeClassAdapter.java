package com.designpattern.adapter.adapwithargus;

/**
 * A class adapter, works as Two-way adapter
 */
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
	public String getAddress() {
		return this.getOfficeLocation();
	}

	@Override
	public CustomerRating getRating() {
		return null;
	}

	@Override
	public void setRating(CustomerRating customerRating) {
		EmployeeRatingMapper employeeAddressMapper = new EmployeeRatingMapper();
		EmployeeRating employeeRating = employeeAddressMapper.getEmployeeRating(customerRating);
		this.setEmployeeRating(employeeRating);
	}

}
