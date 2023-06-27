package com.softtoolscar.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtoolscar.fleetapp.models.Employee;
import com.softtoolscar.fleetapp.repositories.EmployeeRepository;
import com.softtoolscar.fleetapp.security.controller.ValidationException;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	// Return list of Employees
	public List<Employee> getEmployees() {
		return employeeRepository.findAll();	
	}
	
	// Post a new Employee
	public Employee saveEmployee(Employee employee) {
	    if (employee.getUsername().isEmpty()) {
	        throw new ValidationException("Le nom d'utilisateur est requis");
	    }
		return employeeRepository.save(employee);	
	}
	
	// Get a Employee by id
	public Optional<Employee> getEmployeeById(int id) {
		return employeeRepository.findById(id);
	}
	
	//Delete a Employee by id
	public void deleteEmployeeById(int id) {
		 employeeRepository.deleteById(id);
	}
}
