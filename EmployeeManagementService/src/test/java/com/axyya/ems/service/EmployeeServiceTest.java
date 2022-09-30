package com.axyya.ems.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.axyya.ems.exception.InvalidEmployeeIDException;
import com.axyya.ems.model.Employee;

@SpringBootTest
public class EmployeeServiceTest {

	@Autowired
	private EmployeeService employeeService;
	
	
	@Test
	public void getEmployeeById() {
		
		Employee employee = new Employee();
		employee.setCode(105);
		employee.setName("test");
		employee.setSalary(25000.00);
		employee.setAge(32);
		employee.setDept("Sales");
		employee.setAddress("Gvt");
		
		employeeService.addEmployee(employee);
		
		assertEquals(105, employeeService.getEmployeeById(105).get().getCode());
	}
	
	@Test
	public void addEmployee() {

		Employee employee = new Employee();
		employee.setCode(106);
		employee.setName("test");
		employee.setSalary(25000.00);
		employee.setAge(32);
		employee.setDept("Sales");
		employee.setAddress("Gvt");
		
		
		assertEquals(employee, employeeService.addEmployee(employee));

	}
	

}
