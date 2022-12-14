package com.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.json.JSONArray;
import org.json.JSONObject;
import com.dto.PatientRequest;
import com.entity.Patients;
import com.entity.TherapyPatient;
import com.entity.Treatment;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

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
	
	
	@PostMapping("/updatePatient")
	public void updatePatient(@RequestBody Object requestBody)
	{
		
		 String reqBody = new Gson().toJson(requestBody);
	        JSONObject jsonObject = new JSONObject(reqBody);
	    	System.out.println(jsonObject);
	    	Patients patient = mongoTemplate.findById(jsonObject.getString("id"), Patients.class);
	    	patient.setName(jsonObject.getString("name"));
	    	patient.setOwner(jsonObject.getString("owner"));
	    	patient.setOwnerContact(jsonObject.getString("ownerContact"));
	    	patient.setSpecies(jsonObject.getString("species"));
	    	patient.setBreed(jsonObject.getString("breed"));
	    	patient.setDob(jsonObject.getString("dob"));
	    	patient.setSex(jsonObject.getString("sex"));
	    	patient.setDiagnosis(jsonObject.getString("diagnosis"));
	    	patient.setReproduction(jsonObject.getString("reproduction"));
	    	
	    	
	    	JSONArray allergie = jsonObject.getJSONArray("allergyList");
	    	
	    	//Adding Patient
	    	
	    	List<String> list = new ArrayList<String>();     
	    	JSONArray jsonArray = (JSONArray)allergie; 
	    	if (jsonArray != null) { 
	    	   int len = jsonArray.length();
	    	   for (int i=0;i<len;i++){ 
	    	    list.add(jsonArray.get(i).toString());
	    	   } 
	    	} 
	    	patient.setAllergies(list);
	    	Map<String,String>  histology = new HashMap<String,String>();
	    	histology.put("diagnosis", jsonObject.getString("diagnosis"));
	    	histology.put("indication", jsonObject.getString("indication"));
	    	histology.put("initMassSize", jsonObject.getString("initMassSize"));
	    	histology.put("vaccinations", jsonObject.getString("vaccinations"));
	    	histology.put("weight", jsonObject.getString("weight"));
	    	histology.put("comorbidity", jsonObject.getString("comorbidity"));
	    	patient.setHistology(histology);
	    	mongoTemplate.save(patient);
	    	
	    	
	}
	
	@PostMapping("/addpatient")
	public void addPatient(@RequestBody Object requestBody)
	{
		System.out.println(requestBody);
		UUID pid = UUID.randomUUID();
		 String reqBody = new Gson().toJson(requestBody);
	        JSONObject jsonObject = new JSONObject(reqBody);
	    	System.out.println(jsonObject);
	    	
	    	JSONArray allergie = jsonObject.getJSONArray("allergyList");
	    	
	    	//Adding Patient
	    	
	    	List<String> list = new ArrayList<String>();     
	    	JSONArray jsonArray = (JSONArray)allergie; 
	    	if (jsonArray != null) { 
	    	   int len = jsonArray.length();
	    	   for (int i=0;i<len;i++){ 
	    	    list.add(jsonArray.get(i).toString());
	    	   } 
	    	} 
	    	
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
	    	
	    	patient.setAllergies(list);
	    	
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
	    
	    	
	    	
	    	
	    	
	    	
	    	// End of Hard coded treatment
	    	theraphies.add(thp);
	    	patient.setTheraphies(theraphies);
	    	mongoTemplate.insert(patient);
	    	
	}
	@DeleteMapping("/patient/{patientId}")
	public String deletePatient(@PathVariable String patientId) {

		Patients patient = mongoTemplate.findById(patientId, Patients.class);
		mongoTemplate.remove(patient);
	
	return "Delete successful";
	}
	
	@PostMapping("/addtherapy/{patientId}")
	public void addPatientTheraphy(@RequestBody Object requestBody, @PathVariable String patientId)
	{
	Patients patient = mongoTemplate.findById(patientId, Patients.class);
	String reqBody = new Gson().toJson(requestBody);
	       JSONObject jsonObject = new JSONObject(reqBody);
	    System.out.println(jsonObject);
	   
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
	   
	    List<TherapyPatient> therapies = patient.getTheraphies();
	    therapies.add(thp);
	    patient.setTheraphies(therapies);
	    mongoTemplate.save(patient);
	   

	}

	

}
