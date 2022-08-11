package com.BikkadIT.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BikkadIT.model.Employee;
import com.BikkadIT.repository.EmployeeRepositoryI;

@Service
public class EmployeeServiceImpl implements EmployeeServiceI {
     @Autowired
	 private EmployeeRepositoryI employeeRepositoryI;
     
	@Override
	public int addEmployee(Employee employee) {
		int id = employeeRepositoryI.addEmployee(employee);
		return id;
	}

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> list = employeeRepositoryI.getAllEmployee();
		return list;
	}

	@Override
	public Employee loginCheck(Employee employee) {
		Employee loginCheck = employeeRepositoryI.loginCheck(employee);
		return loginCheck;
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		Employee update = employeeRepositoryI.updateEmployee(employee);
		return update;
	}

	@Override
	public Employee deleteEmployee(int empId) {
		Employee deleteEmployee = employeeRepositoryI.deleteEmployee(empId);
		return deleteEmployee;
	}
}
