package com.designpattern.adapter.adapwithargus;

/**
 * An object adapter. Using composition to translate interface
 */
public class EmployeeObjectAdapter implements Customer {

	private Employee adaptee;

	public EmployeeObjectAdapter(Employee adaptee) {
		this.adaptee = adaptee;
	}

	@Override
	public String getName() {
		return adaptee.getFullName();
	}

	@Override
	public String getDesignation() {
		return adaptee.getJobTitle();
	}

	@Override
	public String getAddress() {
		return adaptee.getOfficeLocation();
	}

	@Override
	public CustomerRating getRating() {
		EmployeeRating employeeRating = adaptee.getEmployeeRating();
		CustomerRatingMapper customerRatingMapper = new CustomerRatingMapper();
		CustomerRating customerRating = customerRatingMapper.getCustomerRating(employeeRating);
		return customerRating;
	}

	@Override
	public void setRating(CustomerRating customerRating) {
		EmployeeRatingMapper employeeRatingMapper = new EmployeeRatingMapper();
		EmployeeRating employeeRating = employeeRatingMapper.getEmployeeRating(customerRating);
		adaptee.setEmployeeRating(employeeRating);
	}
}
