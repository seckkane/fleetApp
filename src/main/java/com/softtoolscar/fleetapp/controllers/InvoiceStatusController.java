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
import com.softtoolscar.fleetapp.services.InvoiceStatusService;

@Controller
public class InvoiceStatusController {
	
	@Autowired
	private InvoiceStatusService invoiceStatusService;
	
	/**
	 * Cette méthode recherche la liste des pays enregistrés.
	 * Elle prend en compte les paramètres suivants : Pas de paramétre.
	 * 
	 * @param param1 Description du paramètre 1
	 * @param param2 Description du paramètre 2
	 * @return renvoie la liste de tous les pays sous la variable countries
	 * @throws UneException Description de l'exception éventuellement lancée : Non Capturée
	 */
	@GetMapping("/invoicestatus")
	public String findAll(Model model){	
		List<InvoiceStatus> invoiceStatuses = invoiceStatusService.getInvoiceStatuses();
		model.addAttribute("invoiceStatuses", invoiceStatuses);
	    return "invoicestatus";
    }
	
	//Post a new InvoiceStatus
	@PostMapping("/invoicestatus/addnew")
	public String addNew(InvoiceStatus invoiceStatus){	
		invoiceStatusService.saveInvoiceStatus(invoiceStatus);
		return "redirect:/invoicestatus";
	}
	
	//Get a InvoiceStatus by id sous format json
	@RequestMapping("/invoicestatus/findById")
	@ResponseBody
	public Optional<InvoiceStatus> findById(int id){	
		return invoiceStatusService.getInvoiceStatusById(id);
	}
	
	//Deleting a InvoiceStatus -- methode qui marchera aussi en get
	@RequestMapping(value="/invoicestatus/delete/{id}", method = { RequestMethod.DELETE, RequestMethod.GET})
	public String delete(@PathVariable("id") int id){	
		invoiceStatusService.deleteInvoiceStatusById(id);
		return "redirect:/invoicestatus";
	}
}
