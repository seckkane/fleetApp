package com.softtoolscar.fleetapp.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.softtoolscar.fleetapp.models.Location;
import com.softtoolscar.fleetapp.repositories.LocationRepository;

@Service
public class LocationService {
	
	@Autowired
	private LocationRepository locationRepository;
	
	// Return list of Locations
	public List<Location> getLocations() {
		return locationRepository.findAll();	
	}
	
	// Post a new Location
	public void saveLocation(Location location) {
		locationRepository.save(location);	
	}
	
	// Get a Location by id
	public Optional<Location> getLocationById(int id) {
		return locationRepository.findById(id);
	}
	
	//Delete a Location by id
	public void deleteLocationById(int id) {
		 locationRepository.deleteById(id);
	}
}
