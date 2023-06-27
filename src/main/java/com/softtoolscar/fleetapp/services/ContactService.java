package com.softtoolscar.fleetapp.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.softtoolscar.fleetapp.models.Contact;
import com.softtoolscar.fleetapp.repositories.ContactRepository;

@Service
public class ContactService {
	@Autowired
	private ContactRepository contactRepository;
	
	// Return list of Contacts
	public List<Contact> getContacts() {
		return contactRepository.findAll();	
	}
	
	// Post a new Contact
	public void saveContact(Contact contact) {
		contactRepository.save(contact);	
	}
	
	// Get a Contact by id
	public Optional<Contact> getContactById(int id) {
		return contactRepository.findById(id);
	}
	
	//Delete a Contact by id
	public void deleteContactById(int id) {
		 contactRepository.deleteById(id);
	}
}
