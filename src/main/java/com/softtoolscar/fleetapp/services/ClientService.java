package com.softtoolscar.fleetapp.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.softtoolscar.fleetapp.models.Client;
import com.softtoolscar.fleetapp.repositories.ClientRepository;

@Service
public class ClientService {
	@Autowired
	private ClientRepository clientRepository;
	
	// Return list of Clients
	public List<Client> getClients() {
		return clientRepository.findAll();	
	}
	
	// Post a new Client
	public void saveClient(Client client) {
		clientRepository.save(client);	
	}
	
	// Get a Client by id
	public Optional<Client> getClientById(int id) {
		return clientRepository.findById(id);
	}
	
	//Delete a Client by id
	public void deleteClientById(int id) {
		 clientRepository.deleteById(id);
	}
}
