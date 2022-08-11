package com.BikkadIT.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.BikkadIT.model.Employee;


public interface EmployeeRepositoryI {
	
	public int addEmployee(Employee employee);
	public List<Employee> getAllEmployee();
	public Employee loginCheck(Employee employee);
	public Employee updateEmployee(Employee employee);
	public Employee deleteEmployee(int empId);
	
	
	

}
