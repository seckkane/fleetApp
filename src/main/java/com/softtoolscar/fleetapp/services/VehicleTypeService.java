package com.softtoolscar.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtoolscar.fleetapp.models.VehicleType;
import com.softtoolscar.fleetapp.repositories.VehicleTypeRepository;

@Service
public class VehicleTypeService {
	
	@Autowired
	private VehicleTypeRepository vehicleTypeRepository;
	
	// Return list of VehicleTypes
	public List<VehicleType> getVehicleTypes() {
		return vehicleTypeRepository.findAll();	
	}
	
	// Post a new VehicleType
	public void saveVehicleType(VehicleType vehicleType) {
		vehicleTypeRepository.save(vehicleType);	
	}
	
	// Get a VehicleType by id
	public Optional<VehicleType> getVehicleTypeById(int id) {
		return vehicleTypeRepository.findById(id);
	}
	
	//Delete a VehicleType by id
	public void deleteVehicleTypeById(int id) {
		 vehicleTypeRepository.deleteById(id);
	}
}
