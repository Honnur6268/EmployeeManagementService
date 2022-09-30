package com.axyya.ems.service;

import java.util.List;
import java.util.Optional;

import com.axyya.ems.model.Employee;

public interface EmployeeService {
	List<Employee> getEmployees();
	Employee addEmployee(Employee emp);
	Optional<Employee> getEmployeeById(long code);
	void updateEmployee(long code, Employee emp);
	void deleteEmployee(long code);
}
