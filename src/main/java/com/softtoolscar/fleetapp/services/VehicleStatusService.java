package com.softtoolscar.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtoolscar.fleetapp.models.VehicleStatus;
import com.softtoolscar.fleetapp.repositories.VehicleStatusRepository;

@Service
public class VehicleStatusService {
	
	@Autowired
	private VehicleStatusRepository vehicleStatusRepository;
	
	// Return list of VehicleStatuss
	public List<VehicleStatus> getVehicleStatuses() {
		return vehicleStatusRepository.findAll();	
	}
	
	// Post a new VehicleStatus
	public void saveVehicleStatus(VehicleStatus vehicleStatus) {
		vehicleStatusRepository.save(vehicleStatus);	
	}
	
	// Get a VehicleStatus by id
	public Optional<VehicleStatus> getVehicleStatusById(int id) {
		return vehicleStatusRepository.findById(id);
	}
	
	//Delete a VehicleStatus by id
	public void deleteVehicleStatusById(int id) {
		 vehicleStatusRepository.deleteById(id);
	}
}
