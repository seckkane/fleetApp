package com.softtoolscar.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtoolscar.fleetapp.models.VehicleMake;
import com.softtoolscar.fleetapp.repositories.VehicleMakeRepository;

@Service
public class VehicleMakeService {
	
	@Autowired
	private VehicleMakeRepository vehicleMakeRepository;
	
	// Return list of VehicleMakes
	public List<VehicleMake> getVehicleMakes() {
		return vehicleMakeRepository.findAll();	
	}
	
	// Post a new VehicleMake
	public void saveVehicleMake(VehicleMake vehicleMake) {
		vehicleMakeRepository.save(vehicleMake);	
	}
	
	// Get a VehicleMake by id
	public Optional<VehicleMake> getVehicleMakeById(int id) {
		return vehicleMakeRepository.findById(id);
	}
	
	//Delete a VehicleMake by id
	public void deleteVehicleMakeById(int id) {
		 vehicleMakeRepository.deleteById(id);
	}
}
