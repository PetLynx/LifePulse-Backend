package com.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Patients;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PatientController {
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	
	
	
	@PostMapping("/addPatients")
	public void addPatients()
	{
			
		Patients p1 =  new Patients("3434-45656gfg-5","Fido Smith","John Smith","Dog","Skin","3 Days Ago");
		Patients p2 =  new Patients("3434-45656gfg-6","Bella Garcias","marcia garcias","Dog","Cyst","1 Week Ago");
		 mongoTemplate.insert(p1);
		 mongoTemplate.insert(p2);
	}
	
	
	@GetMapping("/patients")
	public List<Patients> getPatients()
	{
			
		List<Patients> documents = mongoTemplate.findAll(Patients.class);
		return documents;
	}
	

}
