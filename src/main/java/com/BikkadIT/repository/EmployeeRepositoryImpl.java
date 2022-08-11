package com.BikkadIT.repository;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.BikkadIT.model.Employee;
@Repository
public class EmployeeRepositoryImpl implements EmployeeRepositoryI {
	
	@Autowired
	private SessionFactory sf;

	@Override
	public int addEmployee(Employee employee) {
		 Session session = sf.openSession();
		 session.beginTransaction();
		int  id = (int) session.save(employee);
		System.out.println(id);
		session.getTransaction().commit();
			return id;
	}

	@Override
	public List<Employee> getAllEmployee() {
	Session session = sf.openSession();
	session.beginTransaction();
	String hql="from Employee";
	Query query = session.createQuery(hql);
	List list = query.getResultList();
	return list;
	}

	@Override
	public Employee loginCheck(Employee employee) {
		Session session = sf.openSession();
		session.beginTransaction();
		String hql="from Employee";
		Query query = session.createQuery(hql);
	   List<Employee> list = query.getResultList();
		
		for(Employee emp:list) {
			
			if(employee.getEmpName().equals(emp.getEmpName()) && employee.getEmpPwd().equals(emp.getEmpPwd())) {
				return emp;
			}
			
		}
		return null;
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		Session session = sf.openSession();
		session.beginTransaction();
		session.update(employee);
		session.getTransaction().commit();
		return employee;
	}

	@Override
	public Employee deleteEmployee(int empId) {

      Session session = sf.openSession();
      session.beginTransaction();
      Employee employee = session.get(Employee.class, empId);
      if(employee!=null) {
    	  session.delete(employee);
    	  session.getTransaction().commit();
    	  session.close();
      }
      return employee;
	}
}
