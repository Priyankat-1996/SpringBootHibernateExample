package org.spring.java.service;

import java.util.List;

import javax.transaction.Transactional;

import org.spring.java.dao.EmployeeDao;
import org.spring.java.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("employeeService")
public class EmployeeService {

	@Autowired
	EmployeeDao employeeDao;
	 private static List<Employee> employees;
	 
	@Transactional
	public List<Employee> getAllEmployees() {
		return employeeDao.getAllEmployees();
	}

	@Transactional
	public Employee getEmployee(int id) {
		return employeeDao.getEmployee(id);
	}

	@Transactional
	public void addEmployee(Employee employee) {
		employeeDao.addEmployee(employee);
	}
	
	@Transactional
	public Employee getById(int id) {
		for (Employee emp : employees) {
            if (emp.getId() == id) {
                return emp;
            }
        }
        return null;
	}

	@Transactional
	public void updateEmployee(Employee employee) {
		employeeDao.updateEmployee(employee);

	}

	@Transactional
	public void deleteEmployee(int id) {
		employeeDao.deleteEmployee(id);
	}
}
