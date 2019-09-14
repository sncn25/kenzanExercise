package com.kenzan.exercise.util;

import com.kenzan.exercise.model.Employee;
import com.kenzan.exercise.model.EmployeeDTO;

public class CreatorEmployeeDto extends CreatorEmployees {
	
	@Override
	public Employee factoryMethod(Employee sourceEmployee) {
		Employee newEmployee = new EmployeeDTO();

		newEmployee.setId(sourceEmployee.getId());
		newEmployee.setFirstName(sourceEmployee.getFirstName());
		newEmployee.setMiddleInitial(sourceEmployee.getMiddleInitial());
		newEmployee.setLastName(sourceEmployee.getLastName());
		newEmployee.setDateOfBirth(sourceEmployee.getDateOfBirth());
		newEmployee.setDateOfEmployment(sourceEmployee.getDateOfEmployment());

		return newEmployee;
	}

}
