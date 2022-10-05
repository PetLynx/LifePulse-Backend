package com.entity;

import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class TherapyPatient {
	
	@Id
    private String key;
	@Field
	private String therpahyName;
	@Field
	private Map<String,String> theraphyFields;
	@Field
	private Map<String,List<Treatment>> treatments;
	
	
	
	
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getTherpahyName() {
		return therpahyName;
	}
	public void setTherpahyName(String therpahyName) {
		this.therpahyName = therpahyName;
	}
	public Map<String, String> getTheraphyFields() {
		return theraphyFields;
	}
	public void setTheraphyFields(Map<String, String> theraphyFields) {
		this.theraphyFields = theraphyFields;
	}
	public Map<String, List<Treatment>> getTreatments() {
		return treatments;
	}
	public void setTreatments(Map<String, List<Treatment>> treatments) {
		this.treatments = treatments;
	}
	
	
	
	
	
	
	

}




