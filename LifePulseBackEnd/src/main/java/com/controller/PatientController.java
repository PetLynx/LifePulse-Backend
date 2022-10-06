package com.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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
import com.entity.TherapyPatient;
import com.entity.Treatment;
import com.google.gson.Gson;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PatientController {
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	
	
//	
//	@GetMapping("/addPatients")
//	public void addPatients()
//	{
//			
//		Patients p1 =  new Patients("3434-45656gfg-71"," Smith"," Smith","Cat","Cyst","8 Days Ago");
//		Patients p2 =  new Patients("3434-45656gfg-84"," Garcias"," garcias","Cat","Cyst","3 Week Ago");
//		 mongoTemplate.insert(p1);
//		 mongoTemplate.insert(p2);
//	}
//	
	
	@GetMapping("/patients")
	public List<Patients> getPatients()
	{
			
		List<Patients> documents = mongoTemplate.findAll(Patients.class);
		return documents;
	}
	
	
	@GetMapping("/patient")
	public Patients getPatient(@RequestParam("key") String pkey)
	{
			
		Patients pat = mongoTemplate.findById(pkey, Patients.class);
		return pat;
	}
	
	
	@PostMapping("/addpatient")
	public void addPatient(@RequestBody Object requestBody)
	{
		System.out.println(requestBody);
		UUID pid = UUID.randomUUID();
		 String reqBody = new Gson().toJson(requestBody);
	        JSONObject jsonObject = new JSONObject(reqBody);
	    	System.out.println(jsonObject);
	    	
	    	
	    	//Adding Patient
	    	
	    	Patients patient = new Patients();
	    	patient.setKey(pid.toString());
	    	patient.setName(jsonObject.getString("name"));
	    	patient.setOwner(jsonObject.getString("owner"));
	    	patient.setOwnerContact(jsonObject.getString("ownerContact"));
	    	patient.setSpecies(jsonObject.getString("species"));
	    	patient.setBreed(jsonObject.getString("breed"));
	    	patient.setDob(jsonObject.getString("dob"));
	    	patient.setSex(jsonObject.getString("sex"));
	    	patient.setDiagnosis(jsonObject.getString("diagnosis"));
	    	patient.setReproduction(jsonObject.getString("reproduction"));
	    	
	    	Map<String,String>  histology = new HashMap<String,String>();
	    	histology.put("diagnosis", jsonObject.getString("diagnosis"));
	    	histology.put("indication", jsonObject.getString("indication"));
	    	histology.put("initMassSize", jsonObject.getString("initMassSize"));
	    	histology.put("vaccinations", jsonObject.getString("vaccinations"));
	    	histology.put("weight", jsonObject.getString("weight"));
	    	histology.put("comorbidity", jsonObject.getString("comorbidity"));
	    	patient.setHistology(histology);
	    	
	    	List<TherapyPatient> theraphies =  new ArrayList<TherapyPatient>();
	    	UUID tid = UUID.randomUUID();
	    	TherapyPatient thp = new TherapyPatient();
	    	thp.setKey(tid.toString());
	    	thp.setTherpahyName(jsonObject.getString("theraphyName"));
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
	    	thp.setTheraphyFields(theraphyFields);
	    	//Hard coded treatment
	    	Treatment treatmentOne  =  new Treatment();
	    	treatmentOne.setTreatmentName("#Treatment 1");
	    	treatmentOne.setSpecialist("John Hughes");
	    	treatmentOne.setSessionLength("30 minutes");
	    	treatmentOne.setDate("07/15/2022");
	    	
	    	Treatment treatMentTwo  =  new Treatment();
	    	treatMentTwo.setTreatmentName("#Treatment 1");
	    	treatMentTwo.setSpecialist("John Hughes");
	    	treatMentTwo.setSessionLength("30 minutes");
	    	treatMentTwo.setDate("07/15/2022");
	    	
	    	thp.getTreatments().add(treatmentOne);
	    	thp.getTreatments().add(treatMentTwo);
	    	// End of Hard coded treatment
	    	theraphies.add(thp);
	    	patient.setTheraphies(theraphies);
	    	mongoTemplate.insert(patient);
	    	
	}
	

}
