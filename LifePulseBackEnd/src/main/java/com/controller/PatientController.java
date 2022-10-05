package com.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.json.JSONObject;
import com.dto.PatientRequest;
import com.entity.Patients;
import com.google.gson.Gson;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PatientController {
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	
	
	
	@GetMapping("/addPatients")
	public void addPatients()
	{
			
		Patients p1 =  new Patients("3434-45656gfg-71"," Smith"," Smith","Cat","Cyst","8 Days Ago");
		Patients p2 =  new Patients("3434-45656gfg-84"," Garcias"," garcias","Cat","Cyst","3 Week Ago");
		 mongoTemplate.insert(p1);
		 mongoTemplate.insert(p2);
	}
	
	
	@GetMapping("/patients")
	public List<Patients> getPatients()
	{
			
		List<Patients> documents = mongoTemplate.findAll(Patients.class);
		return documents;
	}
	
	
	@PostMapping("/addpatient")
	public void addPatient(@RequestBody Object requestBody)
	{
		System.out.println(requestBody);
	
		 String reqBody = new Gson().toJson(requestBody);
	        JSONObject jsonObject = new JSONObject(reqBody);
	    	System.out.println(jsonObject);
	}
	

}
