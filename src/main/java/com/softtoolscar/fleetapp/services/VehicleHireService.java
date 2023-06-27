package com.softtoolscar.fleetapp.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.softtoolscar.fleetapp.models.VehicleHire;
import com.softtoolscar.fleetapp.repositories.VehicleHireRepository;

@Service
public class VehicleHireService {
	@Autowired
	private VehicleHireRepository vehicleHireRepository;
	
	// Return list of VehicleHires
	public List<VehicleHire> getVehicleHires() {
		return vehicleHireRepository.findAll();	
	}
	
	// Post a new VehicleHire
	public void saveVehicleHire(VehicleHire vehicleHire) {
		vehicleHireRepository.save(vehicleHire);	
	}
	
	// Get a VehicleHire by id
	public Optional<VehicleHire> getVehicleHireById(int id) {
		return vehicleHireRepository.findById(id);
	}
	
	//Delete a VehicleHire by id
	public void deleteVehicleHireById(int id) {
		 vehicleHireRepository.deleteById(id);
	}
}
