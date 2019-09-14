package com.kenzan.exercise.model;

public abstract class Employee {
	public abstract int getId();
	public abstract void setId(int id);
	public abstract String getFirstName();
	public abstract void setFirstName(String firstName);
	public abstract String getMiddleInitial();
	public abstract void setMiddleInitial(String middleInitial);
	public abstract String getLastName();
	public abstract void setLastName(String lastName);
	public abstract String getDateOfBirth();
	public abstract void setDateOfBirth(String dateOfBirth);
	public abstract String getDateOfEmployment();
	public abstract void setDateOfEmployment(String dateOfEmployment);
}
