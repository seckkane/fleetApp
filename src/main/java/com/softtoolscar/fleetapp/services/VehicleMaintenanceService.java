package com.softtoolscar.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtoolscar.fleetapp.models.VehicleMaintenance;
import com.softtoolscar.fleetapp.repositories.VehicleMaintenanceRepository;

@Service
public class VehicleMaintenanceService {
	@Autowired
	private VehicleMaintenanceRepository vehicleMaintenanceRepository;
	
	// Return list of VehicleMaintenances
	public List<VehicleMaintenance> getVehicleMaintenances() {
		return vehicleMaintenanceRepository.findAll();	
	}
	
	// Post a new VehicleMaintenance
	public void saveVehicleMaintenance(VehicleMaintenance vehicleMaintenance) {
		vehicleMaintenanceRepository.save(vehicleMaintenance);	
	}
	
	// Get a VehicleMaintenance by id
	public Optional<VehicleMaintenance> getVehicleMaintenanceById(int id) {
		return vehicleMaintenanceRepository.findById(id);
	}
	
	//Delete a VehicleMaintenance by id
	public void deleteVehicleMaintenanceById(int id) {
		 vehicleMaintenanceRepository.deleteById(id);
	}
}
