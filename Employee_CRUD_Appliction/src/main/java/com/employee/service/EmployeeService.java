package com.employee.service;

import java.util.List;

import com.employee.exceptions.EmployeeException;
import com.employee.model.Employee;

public interface EmployeeService {
	
	List<Employee> getAllEmployee();
	
	void saveEmployee(Employee employee);
	
	Employee getEmployeeById(Integer id)throws EmployeeException;
	
	void deleteEmployeeById(Integer id)throws EmployeeException;
}
