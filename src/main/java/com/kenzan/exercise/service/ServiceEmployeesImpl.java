package com.kenzan.exercise.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.kenzan.exercise.model.EmployeeDTO;
import com.kenzan.exercise.repository.EmployeeEntity;
import com.kenzan.exercise.repository.EmployeesRepository;
import com.kenzan.exercise.util.Constants;
import com.kenzan.exercise.util.CreatorEmployeeDto;
import com.kenzan.exercise.util.CreatorEmployeeEntity;
import com.kenzan.exercise.util.CreatorEmployees;

@Service
@Transactional
public class ServiceEmployeesImpl implements ServiceEmployees {

	@Autowired
	EmployeesRepository employeesRepository;
	
	private CreatorEmployees creatorDtoEmployees = new CreatorEmployeeDto();
	private CreatorEmployees creatorEntityEmployees = new CreatorEmployeeEntity();
	
	
	@Override
	public EmployeeDTO getEmployeeBy(int id) throws ResponseStatusException {
		EmployeeDTO employeeDTO = (EmployeeDTO) creatorDtoEmployees.factoryMethod(getEmployeeEntity(id));
		return employeeDTO;
	}

	private EmployeeEntity getEmployeeEntity(int id) throws ResponseStatusException {
		Optional<EmployeeEntity> employeeEntity = employeesRepository.findByIdAndStatus(id, Constants.ACTIVE_STATUS);
		
		if(employeeEntity.isPresent()) {
			return employeeEntity.get();
		} 
		
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, Constants.EMPLOYEE_WITH_ID + id + Constants.DOES_NOT_EXIST);
		
	}

	@Override
	public String createEmployee(EmployeeDTO employeeDTO) {
		EmployeeEntity employee = (EmployeeEntity) creatorEntityEmployees.factoryMethod(employeeDTO);
		employee.setStatus(Constants.ACTIVE_STATUS);
		employee = employeesRepository.save(employee);
		return Constants.EMPLOYEE_WITH_ID + employee.getId() + Constants.WAS_CREATED;
	}
	
	@Override
	public EmployeeDTO updateEmployee(int id, EmployeeDTO employeeDTO) throws ResponseStatusException {
		EmployeeEntity actualEmployee = getEmployeeEntity(id);
		
		modifyValues(employeeDTO, actualEmployee);
		
		EmployeeEntity newEmployee = employeesRepository.save(actualEmployee);
		EmployeeDTO employee = (EmployeeDTO) creatorDtoEmployees.factoryMethod(newEmployee);
		
		return employee;
	}

	private void modifyValues(EmployeeDTO employeeDTO, EmployeeEntity actualEmployee) {
		actualEmployee.setDateOfBirth(employeeDTO.getDateOfBirth());
		actualEmployee.setDateOfEmployment(employeeDTO.getDateOfEmployment());
		actualEmployee.setFirstName(employeeDTO.getFirstName());
		actualEmployee.setLastName(employeeDTO.getLastName());
		actualEmployee.setMiddleInitial(employeeDTO.getMiddleInitial());
	}

	@Override
	public String inactivateEmployee(int id) throws ResponseStatusException {
		EmployeeEntity actualEmployee = getEmployeeEntity(id);
		actualEmployee.setStatus(Constants.INACTIVE_STATUS);
		employeesRepository.save(actualEmployee);
		return Constants.EMPLOYEE_WITH_ID + actualEmployee.getId() + Constants.WAS_INACTIVATED;
	}

	@Override
	public List<EmployeeDTO> getEmployees() throws ResponseStatusException {
		Optional<List<EmployeeEntity>> employeesEntities = employeesRepository.findByStatus(Constants.ACTIVE_STATUS);
		List<EmployeeDTO> employees = new LinkedList<>();
		
		if(employeesEntities.isPresent()) {
			employeesEntities.get().forEach(e -> employees.add((EmployeeDTO) creatorDtoEmployees.factoryMethod(e)));
			return employees;
		} 
	
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, Constants.MESSAGE_NO_EMPLOYEES);
	
	}

}