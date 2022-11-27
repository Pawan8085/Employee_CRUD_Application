package com.employee.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.employee.exceptions.EmployeeException;
import com.employee.model.Employee;
import com.employee.service.EmployeeService;

import jakarta.websocket.server.PathParam;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/")
	public String mainPage(Model model ) {
		model.addAttribute("allEmployees", employeeService.getAllEmployee());
		
		return "index";
	}
	
	@GetMapping("/employeeform")
	public String addEmployee(Model model) {
		Employee employee = new Employee();
		
		model.addAttribute("employee", employee);
		
		return "newemployee";
		
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		employeeService.saveEmployee(employee);
		
		return "redirect:/";
	}
	
	@GetMapping("/employeeupdateform/{id}")
	public String updateEmployee(@PathVariable Integer id, Model model) throws EmployeeException {
		Employee employee = employeeService.getEmployeeById(id);
		
		model.addAttribute("employee", employee);
		
		return "updateemployee";
	}
	
	@GetMapping("/deleteemployee/{id}")
	public String deleteEmployee(@PathVariable Integer id) throws EmployeeException {
		
		
		employeeService.deleteEmployeeById(id);
		
		return "redirect:/";
	}
}
