package com.designpattern.adapter.adapwithargus;

/**
 * An existing class used in our system
 * Adaptee
 */
public class Employee {

	private String fullName;

	private String jobTitle;

	private String officeLocation;

	private EmployeeRating employeeRating;

	public EmployeeRating getEmployeeRating() {
		return employeeRating;
	}

	public void setEmployeeRating(EmployeeRating employeeRating) {
		this.employeeRating = employeeRating;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getOfficeLocation() {
		return officeLocation;
	}

	public void setOfficeLocation(String officeLocation) {
		this.officeLocation = officeLocation;
	}

}
