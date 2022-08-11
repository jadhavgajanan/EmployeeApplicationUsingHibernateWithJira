package com.BikkadIT.service;

import java.util.List;

import com.BikkadIT.model.Employee;

public interface EmployeeServiceI {
	public int addEmployee(Employee employee);
	public List<Employee> getAllEmployee();
	public Employee loginCheck(Employee employee);
	public Employee updateEmployee(Employee employee);
	public Employee deleteEmployee(int empId);
	
}
