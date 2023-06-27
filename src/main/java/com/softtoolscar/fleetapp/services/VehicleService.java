package com.softtoolscar.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtoolscar.fleetapp.models.Vehicle;
import com.softtoolscar.fleetapp.repositories.VehicleRepository;

@Service
public class VehicleService {
	
	@Autowired
	private VehicleRepository vehicleRepository;
	
	// Return list of Vehicles
	public List<Vehicle> getVehicles() {
		return vehicleRepository.findAll();	
	}
	
	// Post a new Vehicle
	public void saveVehicle(Vehicle vehicle) {
		vehicleRepository.save(vehicle);	
	}
	
	// Get a Vehicle by id
	public Optional<Vehicle> getVehicleById(int id) {
		return vehicleRepository.findById(id);
	}
	
	//Delete a Vehicle by id
	public void deleteVehicleById(int id) {
		 vehicleRepository.deleteById(id);
	}
	
}
