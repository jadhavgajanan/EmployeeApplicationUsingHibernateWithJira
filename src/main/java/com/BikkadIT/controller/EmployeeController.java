package com.BikkadIT.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.BikkadIT.model.Employee;
import com.BikkadIT.service.EmployeeServiceI;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeServiceI employeeServiceI;
	@PostMapping (value="/addEmployee",consumes="application/json")
	public ResponseEntity<Integer> addEmployee(@RequestBody Employee employee){
		int id = employeeServiceI.addEmployee(employee);
		return new ResponseEntity<Integer>(id,HttpStatus.CREATED);
		
	}
	@GetMapping (value="/getAllEmployee",produces="application/json")
	public ResponseEntity<List<Employee>> getAllEmployee(){
		List<Employee> list= employeeServiceI.getAllEmployee();
		return new ResponseEntity<List<Employee>> (list,HttpStatus.OK);

	}
	@PostMapping(value="/login",consumes="application/json")
	public ResponseEntity<String> loginCheck(@RequestBody Employee employee){
		Employee loginCheck = employeeServiceI.loginCheck(employee);
		if(loginCheck!=null) {
			return new ResponseEntity<String> ("Login Successful.",HttpStatus.FOUND);
		}
		else {
		return new ResponseEntity<String> ("Login Fail",HttpStatus.NOT_FOUND);
		}
	}
	@PutMapping(value="/updateEmployee",consumes="application/json")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
		Employee updateEmployee = employeeServiceI.updateEmployee(employee);
		return new ResponseEntity<Employee>(updateEmployee,HttpStatus.OK);	
	}
	@DeleteMapping(value="/deleteEmployee/{empId}" ,produces="application/json")
	public ResponseEntity<String> deleteEmployee(@PathVariable int empId){
		Employee deleteEmployee = employeeServiceI.deleteEmployee(empId);
		return new ResponseEntity<String>("Delete Data successfully.",HttpStatus.OK);
		
	}
}
