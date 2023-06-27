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
import com.softtoolscar.fleetapp.models.Contact;
import com.softtoolscar.fleetapp.services.ContactService;

@Controller
public class ContactController {
	
	@Autowired
	private ContactService contactService;
	
	/**
	 * Cette méthode recherche la liste des pays enregistrés.
	 * Elle prend en compte les paramètres suivants : Pas de paramétre.
	 * 
	 * @param param1 Description du paramètre 1
	 * @param param2 Description du paramètre 2
	 * @return renvoie la liste de tous les pays sous la variable countries
	 * @throws UneException Description de l'exception éventuellement lancée : Non Capturée
	 */
	@GetMapping("/contact")
	public String findAll(Model model){	
		
		List<Contact> contacts = contactService.getContacts();
		model.addAttribute("contacts", contacts);
	    return "contact";
    }
	
	//Post a new Contact
	@PostMapping("/contact/addnew")
	public String addNew(Contact contact){	
		contactService.saveContact(contact);
		return "redirect:/contact";
	}
	
	//Get a Contact by id sous format json
	@RequestMapping("/contact/findById")
	@ResponseBody
	public Optional<Contact> findById(int id){	
		return contactService.getContactById(id);
	}
	
	//Deleting a Contact -- methode qui marchera aussi en get
	@RequestMapping(value="/contact/delete/{id}", method = { RequestMethod.DELETE, RequestMethod.GET})
	public String delete(@PathVariable("id") int id){	
		contactService.deleteContactById(id);
		return "redirect:/contact";
	}
	
}
