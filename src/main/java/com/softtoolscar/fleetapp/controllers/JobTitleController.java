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
import com.softtoolscar.fleetapp.models.JobTitle;
import com.softtoolscar.fleetapp.services.JobTitleService;

@Controller
public class JobTitleController {
	
	@Autowired
	private JobTitleService jobTitleService;
	
	/**
	 * Cette méthode recherche la liste des pays enregistrés.
	 * Elle prend en compte les paramètres suivants : Pas de paramétre.
	 * 
	 * @param param1 Description du paramètre 1
	 * @param param2 Description du paramètre 2
	 * @return renvoie la liste de tous les pays sous la variable countries
	 * @throws UneException Description de l'exception éventuellement lancée : Non Capturée
	 */
	@GetMapping("/jobtitle")
	public String findAll(Model model){	
		List<JobTitle> jobTitles = jobTitleService.getJobTitles();
		model.addAttribute("jobTitles", jobTitles);
	    return "jobtitle";
    }
	
	//Post a new JobTitle
	@PostMapping("/jobtitle/addnew")
	public String addNew(JobTitle jobTitle){	
		jobTitleService.saveJobTitle(jobTitle);
		return "redirect:/jobtitle";
	}
	
	//Get a JobTitle by id sous format json
	@RequestMapping("/jobtitle/findById")
	@ResponseBody
	public Optional<JobTitle> findById(int id){	
		return jobTitleService.getJobTitleById(id);
	}
	
	//Deleting a JobTitle -- methode qui marchera aussi en get
	@RequestMapping(value="/jobtitle/delete/{id}", method = { RequestMethod.DELETE, RequestMethod.GET})
	public String delete(@PathVariable("id") int id){	
		jobTitleService.deleteJobTitleById(id);
		return "redirect:/jobtitle";
	}
}
