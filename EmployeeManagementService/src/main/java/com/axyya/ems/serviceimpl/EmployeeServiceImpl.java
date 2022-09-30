package com.axyya.ems.serviceimpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.axyya.ems.exception.EmployeeCodeAlreadyExistsException;
import com.axyya.ems.exception.InvalidEmployeeIDException;
import com.axyya.ems.model.Employee;
import com.axyya.ems.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	public List<Employee> employees = new ArrayList<>(
			Arrays.asList(new Employee(101, "Honnur Ali", 25000.00, 24, "IT", "Gangavathi"),
					new Employee(102, "Zoya Begum", 28000, 22, "Sales", "Bangalore"),
					new Employee(103, "Bhavana V", 27000, 24, "IT", "Bangalore")));

	@Override
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return employees;
	}

	@Override
	public Employee addEmployee(Employee emp) {

		Optional<Employee> exisitingEmployee = getEmployeeById(emp.getCode());
		if (!exisitingEmployee.isPresent()) {
			employees.add(emp);
		} else {
			throw new InvalidEmployeeIDException(
					"Employee details with code " + emp.getCode() + " is already present.");
		}
		return emp;
	}

	@Override
	public Optional<Employee> getEmployeeById(long code) {
		Optional<Employee> employee = employees.stream().filter(emp -> emp.getCode() == code).findAny();
		return employee;
	}

	@Override
	public void updateEmployee(long code, Employee emp) {
		Optional<Employee> exisitingEmployee = getEmployeeById(code);
		if (exisitingEmployee.isPresent()) {

			for (int i = 0; i < employees.size(); i++) {
				Employee getEmpCode = employees.get(i);
				if (getEmpCode.getCode() == code) {
					employees.set(i, emp);
				}
			}
		} else {
			throw new InvalidEmployeeIDException("Employee with code " +code
					+ " is Not Found. Please try to update with correct Employee ID.");
		}

	}

	@Override
	public void deleteEmployee(long code) {
		Optional<Employee> exisitingEmployee = getEmployeeById(code);
	

		if (exisitingEmployee.isPresent()) {

			for (int i = 0; i < employees.size(); i++) {
				Employee getEmpCode = employees.get(i);
				if (getEmpCode.getCode() == code) {
					employees.remove(i);
				}
			}
		}
		else {
			throw new InvalidEmployeeIDException("Employee with code " + code + " is Not Found.");
		}

	}

}
