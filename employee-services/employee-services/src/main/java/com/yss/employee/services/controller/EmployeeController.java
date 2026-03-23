package com.yss.employee.services.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.yss.employee.services.response.EmployeeResponse;
import com.yss.employee.services.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@GetMapping("/employees/{id}")
	private ResponseEntity<EmployeeResponse> getEmployeeDetails(@PathVariable("id") int id) {
		{
			EmployeeResponse employee = employeeService.getEmployeeById(id);
			return ResponseEntity.status(HttpStatus.OK).body(employee);
		}
	}
}