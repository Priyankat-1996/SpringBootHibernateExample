package org.spring.java.controller;

import java.util.ArrayList;
import java.util.List;

import org.spring.java.model.Employee;
import org.spring.java.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@RequestMapping(value = "/getAllEmployees", method = RequestMethod.GET, headers = "Accept=application/json")
	public String getAllEmployees(Model model) {

		List<Employee> listOfEmployees = employeeService.getAllEmployees();
		model.addAttribute("employee", new Employee());
		model.addAttribute("listOfEmployees", listOfEmployees);
		return "EmployeeDetails";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET, headers = "Accept=application/json")
	public String goToHomePage() {
		return "redirect:/getAllEmployees";
	}
	
	@RequestMapping(value = "/getEmployee/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Employee getEmployeeById(@PathVariable int id) {
		return employeeService.getEmployee(id);
	}

	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST, headers = "Accept=application/json")
	public String addEmployee(@ModelAttribute("employee") Employee employee) {	
		if(employee.getId()==0)
		{
			employeeService.addEmployee(employee);
		}
		else
		{	
			employeeService.updateEmployee(employee);
		}

		return "redirect:/getAllEmployees";
	}

	@RequestMapping(value = "/getById", method = RequestMethod.POST, headers = "Accept=application/json")
	public String getById(@RequestParam("id") int id,Model model) 
	{/*
		Employee emp = employeeService.getEmployee(id);
		model.addAttribute("employee", emp);
		model.addAttribute("list", emp);
		return "redirect:/getAllEmployees";
		
		model.addAttribute("employee", this.employeeService.getEmployee(id));
		model.addAttribute("list", this.employeeService.getAllEmployees());
		return "redirect:/getAllEmployees";
		*/
		System.out.println("Fetching User with id " + id);
		Employee emp = employeeService.getEmployee(id);
		if(emp == null)	
		{
			System.out.println("Not Found: "+ id);
			List<Employee> empList = new ArrayList<Employee>();
	    	empList.contains(emp);
	        model.addAttribute("employee", new Employee());
	        model.addAttribute("list", empList);
		}
		else
		{
			List<Employee> empList = new ArrayList<Employee>();
	    	empList.add(emp);
	        model.addAttribute("employee", new Employee());
	       
	        model.addAttribute("list", empList);
		}
		List<Employee> listOfEmployees = employeeService.getAllEmployees();
		model.addAttribute("listOfEmployees", listOfEmployees);
        
        return "EmployeeDetails";
		
	}
	
	@RequestMapping(value = "/updateEmployee/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String updateEmployee(@PathVariable("id") int id,Model model) {
		model.addAttribute("employee", this.employeeService.getEmployee(id));
		model.addAttribute("listOfEmployees", this.employeeService.getAllEmployees());
		return "EmployeeDetails";
	}

	@RequestMapping(value = "/deleteEmployee/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String deleteEmployee(@PathVariable("id") int id) {
		employeeService.deleteEmployee(id);
		return "redirect:/getAllEmployees";

	}	
}
