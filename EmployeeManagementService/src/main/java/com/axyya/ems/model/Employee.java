package com.axyya.ems.model;

public class Employee {
	private long code;
	private String name;
	private double salary;
	private int age;
	private String dept;
	private String address;
	
	public Employee() {
		
	}
	
	public Employee(long code, String name, double salary, int age, String dept, String address) {
		super();
		this.code = code;
		this.name = name;
		this.salary = salary;
		this.age = age;
		this.dept = dept;
		this.address = address;
	}
	
	public long getCode() {
		return code;
	}
	public void setCode(long code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [code=" + code + ", name=" + name + ", salary=" + salary + ", age=" + age + ", dept=" + dept
				+ ", address=" + address + "]";
	}
	
	
}
