package com.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.exceptions.EmployeeException;
import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;
@Service
public class  EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;
	@Override
	public List<Employee> getAllEmployee() {
		
		return employeeRepository.findAll();
	}
	@Override
	public void saveEmployee(Employee employee) {
	
		employeeRepository.save(employee);
		
	}
	@Override
	public Employee getEmployeeById(Integer id) throws EmployeeException {
		Optional<Employee> opt = employeeRepository.findById(id);
		Employee employee=null;
		if (opt.isPresent()) {
			employee=opt.get();
		}
		else throw new EmployeeException("Employee not found with id "+id);
		return employee;
	}
	@Override
	public void deleteEmployeeById(Integer id) throws EmployeeException {
		
		Optional<Employee> opt = employeeRepository.findById(id);
		
		if(opt.isPresent()) {
			employeeRepository.deleteById(id);
		}
		//Such thing wont happen but i am just adding
		else throw new EmployeeException("Invalid id : "+id);
		
		
	}
	

}
