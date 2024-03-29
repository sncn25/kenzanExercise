package com.kenzan.exercise.model;

import javax.validation.constraints.Pattern;

public class EmployeeDTO extends Employee {

	private static final String EXPRESSION_STRING = "[A-Za-z]{1,35}";
	private static final String EXPRESSION_DATE = "[0-9]{1,2}/[0-9]{1,2}/[0-9]{4}";
	
	private int id;
	
	@Pattern(regexp = EXPRESSION_STRING)
	private String firstName;
	
	private String middleInitial;
	
	@Pattern(regexp = EXPRESSION_STRING)
	private String lastName;
	
	@Pattern(regexp = EXPRESSION_DATE)
	private String dateOfBirth;
	
	@Pattern(regexp = EXPRESSION_DATE)
	private String dateOfEmployment;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleInitial() {
		return middleInitial;
	}
	public void setMiddleInitial(String middleInitial) {
		this.middleInitial = middleInitial;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getDateOfEmployment() {
		return dateOfEmployment;
	}
	public void setDateOfEmployment(String dateOfEmployment) {
		this.dateOfEmployment = dateOfEmployment;
	}
	
}
