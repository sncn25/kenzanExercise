package com.kenzan.exercise.util;

import com.kenzan.exercise.model.Employee;
import com.kenzan.exercise.repository.EmployeeEntity;

public class CreatorEmployeeEntity extends CreatorEmployees {
	
	@Override
	public Employee factoryMethod(Employee sourceEmployee) {
		Employee newEmployee = new EmployeeEntity();
		
		newEmployee.setFirstName(sourceEmployee.getFirstName());
		newEmployee.setMiddleInitial(sourceEmployee.getMiddleInitial());
		newEmployee.setLastName(sourceEmployee.getLastName());
		newEmployee.setDateOfBirth(sourceEmployee.getDateOfBirth());
		newEmployee.setDateOfEmployment(sourceEmployee.getDateOfEmployment());
		
		return newEmployee;
	}

}
