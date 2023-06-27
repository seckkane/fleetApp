package com.softtoolscar.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtoolscar.fleetapp.models.VehicleModel;
import com.softtoolscar.fleetapp.repositories.VehicleModelRepository;

@Service
public class VehicleModelService {
	
	@Autowired
	private VehicleModelRepository vehicleModelRepository;
	
	// Return list of VehicleModels
	public List<VehicleModel> getVehicleModels() {
		return vehicleModelRepository.findAll();	
	}
	
	// Post a new VehicleModel
	public void saveVehicleModel(VehicleModel vehicleModel) {
		vehicleModelRepository.save(vehicleModel);	
	}
	
	// Get a VehicleModel by id
	public Optional<VehicleModel> getVehicleModelById(int id) {
		return vehicleModelRepository.findById(id);
	}
	
	//Delete a VehicleModel by id
	public void deleteVehicleModelById(int id) {
		 vehicleModelRepository.deleteById(id);
	}
}
