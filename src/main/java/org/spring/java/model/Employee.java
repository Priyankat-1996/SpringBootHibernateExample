
package org.spring.java.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="EMPLOYEE")
public class Employee{

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;

	@Column(name="empName")
	String empName; 

	@Column(name="salary")
	String salary;
	
	@Column(name="empDept")
	String empDept;
	
	@Column(name="age")
	String age;
	
	public Employee() {
		super();
	}
	public Employee(String empName,String salary,String empDept,String age) {
		super();
		this.empName=empName;
		this.salary=salary;
		this.empDept=empDept;
		this.age=age;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getEmpDept() {
		return empDept;
	}
	public void setEmpDept(String empDept) {
		this.empDept = empDept;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
	
}

/*
create database EmployeeData;
CREATE TABLE `EMPLOYEE` ( `id` int(11) NOT NULL AUTO_INCREMENT, `empName` varchar(30) DEFAULT NULL, `salary` varchar(10) DEFAULT NULL,`empDept` varchar(30) DEFAULT NULL,`age` varchar(5), PRIMARY KEY (`id`) );
*/
