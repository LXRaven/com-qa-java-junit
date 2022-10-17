package com.qa.junit.repository;

import java.util.Arrays;
import java.util.List;

import com.qa.junit.model.Employee;

public class Repository {
	
	//code to perform db operations
	
	List<Employee> empList;
	
	public Repository() {
		this.empList = Arrays.asList(
				new Employee(111,"emp1",32423.23),
				new Employee(222,"emp2",42423.23),
				new Employee(333,"emp3",52423.23)
				);
				
	}
	
	public Employee getEmployeeById(int id) {
		Employee emp= null;
		//logic
		return emp;
	}
	
	

}
