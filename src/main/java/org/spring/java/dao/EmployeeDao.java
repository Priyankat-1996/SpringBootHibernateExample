package org.spring.java.dao;

import java.util.List;

import org.spring.java.model.Employee;

public interface EmployeeDao {
	public List<Employee> getAllEmployees() ;

	public Employee getEmployee(int id) ;

	public Employee addEmployee(Employee employee);

	public Employee getById(int id);

	public void updateEmployee(Employee employee) ;

	public void deleteEmployee(int id) ;
}
