package com.softtoolscar.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtoolscar.fleetapp.models.Invoice;
import com.softtoolscar.fleetapp.repositories.InvoiceRepository;

@Service
public class InvoiceService {
	
	@Autowired
	private InvoiceRepository invoiceRepository;
	
	// Return list of Invoices
	public List<Invoice> getInvoices() {
		return invoiceRepository.findAll();	
	}
	
	// Post a new Invoice
	public void saveInvoice(Invoice invoice) {
		invoiceRepository.save(invoice);	
	}
	
	// Get a Invoice by id
	public Optional<Invoice> getInvoiceById(int id) {
		return invoiceRepository.findById(id);
	}
	
	//Delete a Invoice by id
	public void deleteInvoiceById(int id) {
		 invoiceRepository.deleteById(id);
	}
}
