package com.yss.employee.services.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yss.employee.services.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
