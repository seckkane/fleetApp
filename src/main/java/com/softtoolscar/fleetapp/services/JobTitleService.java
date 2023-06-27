package com.softtoolscar.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtoolscar.fleetapp.models.JobTitle;
import com.softtoolscar.fleetapp.repositories.JobTitleRepository;

@Service
public class JobTitleService {
	
	@Autowired
	private JobTitleRepository jobTitleRepository;
	
	// Return list of jobTitles
	public List<JobTitle> getJobTitles() {
		return jobTitleRepository.findAll();	
	}
	
	// Post a new JobTitle
	public void saveJobTitle(JobTitle jobTitle) {
		jobTitleRepository.save(jobTitle);	
	}
	
	// Get a JobTitle by id
	public Optional<JobTitle> getJobTitleById(int id) {
		return jobTitleRepository.findById(id);
	}
	
	//Delete a JobTitle by id
	public void deleteJobTitleById(int id) {
		 jobTitleRepository.deleteById(id);
	}
}
