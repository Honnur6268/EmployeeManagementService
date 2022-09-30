package com.axyya.ems.exception;

public class EmployeeCodeAlreadyExistsException extends RuntimeException {

	public EmployeeCodeAlreadyExistsException(String msg) {
		super(msg);
	}
}
