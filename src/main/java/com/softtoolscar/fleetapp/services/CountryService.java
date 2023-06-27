package com.softtoolscar.fleetapp.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.softtoolscar.fleetapp.models.Country;
import com.softtoolscar.fleetapp.repositories.CountryRepository;

@Service
public class CountryService {
	
	@Autowired
	private CountryRepository countryRepository;
	
	// Return list of Countries
	public List<Country> getCountries() {
		return countryRepository.findAll();	
	}
	
	// Post a new Country
	public void saveCountry(Country country) {
		countryRepository.save(country);	
	}
	
	// Get a Country by id
	public Optional<Country> getCountryById(int id) {
		return countryRepository.findById(id);
	}
	
	//Delete a Country by id
	public void deleteCountryById(int id) {
		 countryRepository.deleteById(id);
	}
}
