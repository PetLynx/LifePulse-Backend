package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Devices;
import com.entity.Patients;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DeviceController {
	
	
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	
	
	
	@GetMapping("/addDevices")
	public void addPatients()
	{
			
		Devices p1 =  new Devices("3434-45656gfg-5","VCC-LPD-135R92","Vet Care Center 135","Room 92","Online","3 hours Ago");
		Devices p2 =  new Devices("3434-45656gfg-6","VCC-LPD-135R93","Vet Care Center 135","Room 93","Offine","1 hours Ago");
		 mongoTemplate.insert(p1);
		 mongoTemplate.insert(p2);
	}
	
	
	@GetMapping("/devices")
	public List<Devices> getPatients()
	{
			
		List<Devices> documents = mongoTemplate.findAll(Devices.class);
		return documents;
	}
	

}
