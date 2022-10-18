package com.qa.junit.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.qa.junit.exception.EmployeeAlreadyExistsException;
import com.qa.junit.exception.EmployeeNotFoundException;
import com.qa.junit.exception.InvalidInputException;
import com.qa.junit.model.Employee;

public class RepositoryTest {
	
	/*
	 * To test Repository class
	 */
	
	Repository repository;
	
	@BeforeEach
	public void setUp() {
		this.repository = new Repository();
	}
	
	@AfterEach
	public void cleanUp() {
		this.repository = null;
	}
	
	@Test
	@DisplayName("getEmpById(id) -> Return Employee")
	public void givenExistingId_whenGetEmployeeById_thenReturnEmployee() throws EmployeeNotFoundException, InvalidInputException {
		//testing the code
		//expected vs actual
		Employee employee = this.repository.getEmployeeById(111);
		assertNotNull(employee);
		assertEquals("emp1", employee.getName());
		assertEquals(32423.23,employee.getSalary());
		
	}
	
	@Test
	@DisplayName("getEmployeeById(id) -> Throws EmployeeNotFoundException")
	public void givenNonExistingId_whenGetEmployeeById_thenThrowEmployeeNotFoundException() {
		
		assertThrows(EmployeeNotFoundException.class, () -> this.repository.getEmployeeById(888) );
	}
	
	@Test
	@DisplayName("getEmployeeById(invalid) -> Throws InvalidInputException")
	public void givenInvalidInputAsId_whenGetEmpoyeeById_thenThrowInvalidInputException() {
		assertThrows(InvalidInputException.class, () -> this.repository.getEmployeeById(-100) );
	}
	
	/*
	 * Write the test cases for getAllEmployees
	 */
	@Test
	@DisplayName("getAllEmployees() -> Returns Employee List")
	public void givenARepository_whenGetAllEmployees_thenReturnEmployeesList() {
		List<Employee> empListTest = this.repository.getAllEmployees();
		assertNotNull(empListTest);
		assertEquals(this.repository.empList.size(), empListTest.size());
		for (int i=0;i<empListTest.size(); i++) {
			assertEquals(this.repository.empList.get(i), empListTest.get(i));
		}
	}
	
	/*
	 * Write the test cases for addEmployee(employee)
	 */
	@Test
	@DisplayName("addEmployee(employee) -> Adds new Employee")
	public void givenAnExistingList_whenAddEmployee_thenAddTheEmployeeToTheList() throws EmployeeAlreadyExistsException, InvalidInputException {
		Employee emp4 = new Employee (444, "emp4", 34234.21);
		this.repository.addEmployee(emp4);
		assertNotNull(repository.empList.get(3));
		assertEquals(emp4.getId(), repository.empList.get(3).getId());
		assertEquals(emp4.getName(), repository.empList.get(3).getName());
		assertEquals(emp4.getSalary(), repository.empList.get(3).getSalary());
		
	}
	
	@Test
	@DisplayName("addEmployee(employee) -> Throws EmployeeAlreadyExistsException")
	public void givenAnExistingList_whenAddEmployeeExistingEmployee_thenThrowExsitingEmployeeException() {
		Employee emp2 = new Employee(222, "emp2", 23141.11);
		assertThrows( EmployeeAlreadyExistsException.class, ()-> this.repository.addEmployee(emp2));
	}
	@Test
	@DisplayName("addEmployee(employee) -> Throws InvalidInputException")
	public void givenExistingList_whenAddEmployeeWithInvalidInput_thenThrowInvalidInputException(){
		assertThrows(InvalidInputException.class, ()-> this.repository.addEmployee("Employee"));
	}
	
}
