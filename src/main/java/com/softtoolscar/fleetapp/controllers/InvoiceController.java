package com.softtoolscar.fleetapp.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.softtoolscar.fleetapp.models.InvoiceStatus;
import com.softtoolscar.fleetapp.models.Invoice;
import com.softtoolscar.fleetapp.models.Client;
import com.softtoolscar.fleetapp.services.InvoiceStatusService;
import com.softtoolscar.fleetapp.services.InvoiceService;
import com.softtoolscar.fleetapp.services.ClientService;

@Controller
public class InvoiceController {
	
	@Autowired
	private InvoiceService invoiceService;
	@Autowired
	private InvoiceStatusService invoiceStatusService;
	@Autowired
	private ClientService clientService;
	
	/**
	 * Cette méthode recherche la liste des pays enregistrés.
	 * Elle prend en compte les paramètres suivants : Pas de paramétre.
	 * 
	 * @param param1 Description du paramètre 1
	 * @param param2 Description du paramètre 2
	 * @return renvoie la liste de tous les pays sous la variable countries
	 * @throws UneException Description de l'exception éventuellement lancée : Non Capturée
	 */
	@GetMapping("/invoice")
	public String findAll(Model model){	
		
		List<InvoiceStatus> invoiceStatuses = invoiceStatusService.getInvoiceStatuses();
		List<Client> clients = clientService.getClients();
		List<Invoice> invoices = invoiceService.getInvoices();
		
		model.addAttribute("invoiceStatuses", invoiceStatuses);
		model.addAttribute("clients", clients);
		model.addAttribute("invoices", invoices);
		
	    return "invoice";
    }
	
	//Post a new Invoice
	@PostMapping("/invoice/addnew")
	public String addNew(Invoice invoice){	
		invoiceService.saveInvoice(invoice);
		return "redirect:/invoice";
	}
	
	//Get a Invoice by id sous format json
	@RequestMapping("/invoice/findById")
	@ResponseBody
	public Optional<Invoice> findById(int id){	
		return invoiceService.getInvoiceById(id);
	}
	
	//Deleting a Invoice -- methode qui marchera aussi en get
	@RequestMapping(value="/invoice/delete/{id}", method = { RequestMethod.DELETE, RequestMethod.GET})
	public String delete(@PathVariable("id") int id){	
		invoiceService.deleteInvoiceById(id);
		return "redirect:/invoice";
	}
}
