package com.axyya.ems.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axyya.ems.exception.InvalidEmployeeIDException;
import com.axyya.ems.model.Employee;
import com.axyya.ems.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@GetMapping("/employeeById/{code}")
	public Optional<Employee> getEmployeeByID(@PathVariable long code) {
			Optional<Employee> empByID = employeeService.getEmployeeById(code);
			
			if(empByID.isPresent()) {
				return empByID;
			}
			else {
				throw new InvalidEmployeeIDException("Employee code " + code + " is Not Found. Please try again with valid code!.");
			}
	}

	@GetMapping("/getAllEmployees")
	public List<Employee> getAllEmployees() {
		return employeeService.getEmployees();
	}

	@PostMapping("/addEmployee")
	@ExceptionHandler(InvalidEmployeeIDException.class)
	public Employee addEmployees(@RequestBody Employee emp) {
		Employee e = employeeService.addEmployee(emp);

		return e;
	}

	@PutMapping("/updateEmployee/{code}")
//	@ExceptionHandler(InvalidEmployeeIDException.class)
	public void updateEmployees(@RequestBody Employee emp, @PathVariable long code) {
		employeeService.updateEmployee(code, emp);

	}

	@DeleteMapping("/deleteEmployee/{code}")
//	@ExceptionHandler(InvalidEmployeeIDException.class)
	public void deleteEmployees(@PathVariable long code) {
		employeeService.deleteEmployee(code);

	}
}
