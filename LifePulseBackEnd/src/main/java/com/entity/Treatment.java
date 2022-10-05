package com.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Treatment {
	
	
	
	@Field
    private String treatmentName;
	
	
	@Field
    private String specialist;
	
	@Field
    private String sessionLength;
	
	@Field
	private String date;

	

	public String getSpecialist() {
		return specialist;
	}

	public void setSpecialist(String specialist) {
		this.specialist = specialist;
	}

	public String getSessionLength() {
		return sessionLength;
	}

	public void setSessionLength(String sessionLength) {
		this.sessionLength = sessionLength;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTreatmentName() {
		return treatmentName;
	}

	public void setTreatmentName(String treatmentName) {
		this.treatmentName = treatmentName;
	}
	
	
	
	
	

}
