package org.spring.java.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.spring.java.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public List<Employee> getAllEmployees() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Employee>  employeeList = session.createQuery("from Employee").list();
		return employeeList;
	}

	public Employee getEmployee(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Employee employee = (Employee) session.get(Employee.class, id);
		return employee;
	}

	public Employee addEmployee(Employee employee) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(employee);
		return employee;
	}
	
	public Employee getById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Employee employee = (Employee) session.get(Employee.class, id);
		return employee;
	}

	public void updateEmployee(Employee employee) {
		Session session = this.sessionFactory.getCurrentSession();
		Hibernate.initialize(employee);
		session.update(employee);
	}

	public void deleteEmployee(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Employee p = (Employee) session.load(Employee.class, new Integer(id));
		if (null != p) {
			session.delete(p);
		}
	} 
}
