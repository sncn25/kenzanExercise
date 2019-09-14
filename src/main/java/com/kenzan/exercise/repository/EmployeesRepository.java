package com.kenzan.exercise.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeesRepository extends CrudRepository<EmployeeEntity, Integer>{
	public Optional<EmployeeEntity> findByIdAndStatus(int id, String status);
	public Optional<List<EmployeeEntity>> findByStatus(String status);
}
