package com.kenzan.exercise.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.kenzan.exercise.model.EmployeeDTO;
import com.kenzan.exercise.util.Constants;

@RestController
@RequestMapping("/employees")
public class ProxyController implements EmployeesController {

	@Autowired
	EmployeesController employeesController;
	
	@GetMapping("/{id}")
	public EmployeeDTO getEmployeeBy(@PathVariable int id) throws ResponseStatusException {
		EmployeeDTO employeeFound = employeesController.getEmployeeBy(id);
		return employeeFound;
	}
	
	@PostMapping
	public String createEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {
		String result = employeesController.createEmployee(employeeDTO);
		return result;
	}
	
	@PutMapping("/{id}")
	public EmployeeDTO updateEmployee(@PathVariable int id, @Valid @RequestBody EmployeeDTO employeeDTO) throws ResponseStatusException {
		EmployeeDTO employeeUpdated = employeesController.updateEmployee(id, employeeDTO);
		return employeeUpdated;
	}
	
	@DeleteMapping("/{id}")
	public String deleteEmployee(@PathVariable int id, @RequestHeader(value = "Authorization") String Authorization) throws ResponseStatusException {
		if(isValidAuthorization(Authorization)) {
			return this.deleteEmployee(id);
		}
		throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, Constants.AUTHORIZATION_MESSAGE_EXCEPTION);
	}

	private boolean isValidAuthorization(String Authorization) {
		return Authorization.equals(Constants.AUTHORIZATION_PASS);
	}
	
	@GetMapping
	public List<EmployeeDTO> getEmployees() throws ResponseStatusException {
		List<EmployeeDTO> employees = employeesController.getEmployees();
		return employees;
	}

	@Override
	public String deleteEmployee(int id) {
		return employeesController.deleteEmployee(id);
	}
	
}
