package com.kenzan.exercise.controller;

import java.util.List;
import com.kenzan.exercise.model.EmployeeDTO;

public interface EmployeesController {
	public EmployeeDTO getEmployeeBy(int id);
	public String createEmployee(EmployeeDTO employeeDTO);
	public EmployeeDTO updateEmployee(int id, EmployeeDTO employeeDTO);
	public String deleteEmployee(int id);
	public List<EmployeeDTO> getEmployees();
}
