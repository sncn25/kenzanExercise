package com.kenzan.exercise.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.server.ResponseStatusException;

import com.kenzan.exercise.model.EmployeeDTO;
import com.kenzan.exercise.service.ServiceEmployees;

@Controller
class EmployeesControllerImpl implements EmployeesController {

	@Autowired
	ServiceEmployees serviceEmployees;
	
	public EmployeeDTO getEmployeeBy(int id) throws ResponseStatusException {
		EmployeeDTO employeeFound = serviceEmployees.getEmployeeBy(id);
		return employeeFound;
	}
	
	public String createEmployee(EmployeeDTO employeeDTO) {
		String result = serviceEmployees.createEmployee(employeeDTO);
		return result;
	}
	
	public EmployeeDTO updateEmployee(int id, EmployeeDTO employeeDTO) throws ResponseStatusException {
		EmployeeDTO employeeUpdated = serviceEmployees.updateEmployee(id, employeeDTO);
		return employeeUpdated;
	}
	
	public String deleteEmployee(int id) throws ResponseStatusException {
			return serviceEmployees.inactivateEmployee(id);
	}
	
	public List<EmployeeDTO> getEmployees() throws ResponseStatusException {
		List<EmployeeDTO> employees = serviceEmployees.getEmployees();
		return employees;
	}
}