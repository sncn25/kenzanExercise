package com.kenzan.exercise.service;

import java.util.List;

import javax.xml.ws.http.HTTPException;

import com.kenzan.exercise.model.EmployeeDTO;

public interface ServiceEmployees {

	public EmployeeDTO getEmployeeBy(int id);
	public String createEmployee(EmployeeDTO employeeDTO);
	public EmployeeDTO updateEmployee(int id, EmployeeDTO employeeDTO);
	public String inactivateEmployee(int id);
	public List<EmployeeDTO> getEmployees();
	
}
