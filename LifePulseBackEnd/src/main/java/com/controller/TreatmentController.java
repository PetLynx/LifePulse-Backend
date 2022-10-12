package com.controller;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Patients;
import com.entity.TherapyPatient;
import com.entity.Treatment;
import com.google.gson.Gson;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TreatmentController {
	
	
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	
	
	
	
	

}
