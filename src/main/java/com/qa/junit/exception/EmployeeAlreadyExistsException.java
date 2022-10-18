package com.qa.junit.exception;

public class EmployeeAlreadyExistsException extends Exception {
	public EmployeeAlreadyExistsException(String msg) {
		super(msg);
	}
}
