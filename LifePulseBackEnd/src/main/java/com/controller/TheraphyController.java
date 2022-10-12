package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Patients;
import com.entity.TherapyPatient;
import com.entity.Treatment;
import com.google.gson.Gson;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TheraphyController {
	
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	
	@PostMapping("/addTreatment")
	public void addtreatment(@RequestBody Object requestBody)
	{
			
		
		
		String reqBody = new Gson().toJson(requestBody);
	       JSONObject jsonObject = new JSONObject(reqBody);
	    System.out.println(jsonObject);
	
		
		Patients patient = mongoTemplate.findById(jsonObject.getString("id"), Patients.class);
		
		for(TherapyPatient th : patient.getTheraphies())
		{
			
			if(th.getKey().equalsIgnoreCase(jsonObject.getString("tid")))
			{
				   th.setTherpahyName(jsonObject.getString("theraphyName"));
				 Map<String,String> theraphyFields = new HashMap<String,String>();
				    theraphyFields.put("theraphyName", jsonObject.getString("theraphyName"));
				    theraphyFields.put("tindication", jsonObject.getString("tindication"));
				    theraphyFields.put("tumorType", jsonObject.getString("tumorType"));
				    theraphyFields.put("tumorVolume", jsonObject.getString("tumorVolume"));
				    theraphyFields.put("grade", jsonObject.getString("grade"));
				    theraphyFields.put("cellType", jsonObject.getString("cellType"));
				    theraphyFields.put("tnmStage", jsonObject.getString("tnmStage"));
				    theraphyFields.put("overAllStage", jsonObject.getString("overAllStage"));
				    theraphyFields.put("pweight", jsonObject.getString("pweight"));
				    theraphyFields.put("therapeutic", jsonObject.getString("therapeutic"));
				    theraphyFields.put("tname", jsonObject.getString("tname"));
				    theraphyFields.put("ivolume", jsonObject.getString("ivolume"));
				    theraphyFields.put("ores", jsonObject.getString("ores"));
				    theraphyFields.put("retreat", jsonObject.getString("retreat"));
				    theraphyFields.put("nacrosis", jsonObject.getString("nacrosis"));
				    th.setTheraphyFields(theraphyFields);
				    
				    Treatment treat = new Treatment();
				    int size= th.getTreatments().size()+1;
				    treat.setTreatmentName("Treatment "+size);
				    treat.setSessionLength("30 minutes");
				    treat.setSpecialist("Gary");
				    treat.setDate("12-10-2022");
				
				    th.getTreatments().add(treat);
				    mongoTemplate.save(patient);
			}
		}
		
		
	}
	
	
	@GetMapping("/theraphy/{patientId}/{therapyId}")
	public TherapyPatient getTheraphy(@PathVariable String patientId,@PathVariable String therapyId)
	{
			
		TherapyPatient theraphy =  new TherapyPatient();
		
		Patients patient = mongoTemplate.findById(patientId, Patients.class);
		
		for(TherapyPatient th : patient.getTheraphies())
		{
			
			if(th.getKey().equalsIgnoreCase(therapyId))
			{
				theraphy = th;
				break;
			}
		}
		return theraphy;
		
	}
}
