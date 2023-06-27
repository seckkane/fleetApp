package com.softtoolscar.fleetapp.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.softtoolscar.fleetapp.models.State;
import com.softtoolscar.fleetapp.repositories.StateRepository;

@Service
public class StateService {
	
	@Autowired
	private StateRepository stateRepository;
	
	// Return list of States
	public List<State> getStates() {
		return stateRepository.findAll();	
	}
	
	// Post a new State
	public void saveState(State state) {
		stateRepository.save(state);	
	}
	
	// Get a State by id
	public Optional<State> getStateById(int id) {
		return stateRepository.findById(id);
	}
	
	// Delete a Service by id
	public void deleteStateById(int id) {
		 stateRepository.deleteById(id);
	}
}
