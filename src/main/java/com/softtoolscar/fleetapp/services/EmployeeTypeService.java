package com.softtoolscar.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtoolscar.fleetapp.models.EmployeeType;
import com.softtoolscar.fleetapp.repositories.EmployeeTypeRepository;

@Service
public class EmployeeTypeService {
	
	@Autowired
	private EmployeeTypeRepository employeeTypeRepository;
	
	// Return list of EmployeeTypes
	public List<EmployeeType> getEmployeeTypes() {
		return employeeTypeRepository.findAll();	
	}
	
	// Post a new EmployeeType
	public void saveEmployeeType(EmployeeType employeeType) {
		employeeTypeRepository.save(employeeType);	
	}
	
	// Get a EmployeeType by id
	public Optional<EmployeeType> getEmployeeTypeById(int id) {
		return employeeTypeRepository.findById(id);
	}
	
	//Delete a EmployeeType by id
	public void deleteEmployeeTypeById(int id) {
		 employeeTypeRepository.deleteById(id);
	}
}
