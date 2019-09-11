package com.kenzan.exercise.controller;

import org.springframework.web.bind.annotation.*;

import com.kenzan.exercise.model.EmployeeDTO;

@RestController
@RequestMapping("/employees")
public class Controller {

	@GetMapping("/{id}")
	public EmployeeDTO getEmployeeBy(@PathVariable int id) {
		System.out.println(id);
		return null;
	}
	
}