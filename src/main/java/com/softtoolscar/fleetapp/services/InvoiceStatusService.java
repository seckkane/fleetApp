package com.softtoolscar.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtoolscar.fleetapp.models.InvoiceStatus;
import com.softtoolscar.fleetapp.repositories.InvoiceStatusRepository;

@Service
public class InvoiceStatusService {
	
	@Autowired
	private InvoiceStatusRepository invoiceStatusRepository;
	
	// Return list of InvoiceStatuss
	public List<InvoiceStatus> getInvoiceStatuses() {
		return invoiceStatusRepository.findAll();	
	}
	
	// Post a new InvoiceStatus
	public void saveInvoiceStatus(InvoiceStatus invoiceStatus) {
		invoiceStatusRepository.save(invoiceStatus);	
	}
	
	// Get a InvoiceStatus by id
	public Optional<InvoiceStatus> getInvoiceStatusById(int id) {
		return invoiceStatusRepository.findById(id);
	}
	
	//Delete a InvoiceStatus by id
	public void deleteInvoiceStatusById(int id) {
		 invoiceStatusRepository.deleteById(id);
	}
}
