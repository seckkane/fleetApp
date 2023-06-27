package com.softtoolscar.fleetapp.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.softtoolscar.fleetapp.models.Supplier;
import com.softtoolscar.fleetapp.repositories.SupplierRepository;

@Service
public class SupplierService {
	@Autowired
	private SupplierRepository supplierRepository;
	
	// Return list of Suppliers
	public List<Supplier> getSuppliers() {
		return supplierRepository.findAll();	
	}
	
	// Post a new Supplier
	public void saveSupplier(Supplier supplier) {
		supplierRepository.save(supplier);	
	}
	
	// Get a Supplier by id
	public Optional<Supplier> getSupplierById(int id) {
		return supplierRepository.findById(id);
	}
	
	//Delete a Supplier by id
	public void deleteSupplierById(int id) {
		 supplierRepository.deleteById(id);
	}
}
