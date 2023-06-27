package com.softtoolscar.fleetapp.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.softtoolscar.fleetapp.models.VehicleMovement;
import com.softtoolscar.fleetapp.repositories.VehicleMovementRepository;

@Service
public class VehicleMovementService {
	@Autowired
	private VehicleMovementRepository vehicleMovementRepository;
	
	// Return list of VehicleMovements
	public List<VehicleMovement> getVehicleMovements() {
		return vehicleMovementRepository.findAll();	
	}
	
	// Post a new VehicleMovement
	public void saveVehicleMovement(VehicleMovement vehicleMovement) {
		vehicleMovementRepository.save(vehicleMovement);	
	}
	
	// Get a VehicleMovement by id
	public Optional<VehicleMovement> getVehicleMovementById(int id) {
		return vehicleMovementRepository.findById(id);
	}
	
	//Delete a VehicleMovement by id
	public void deleteVehicleMovementById(int id) {
		 vehicleMovementRepository.deleteById(id);
	}
}
