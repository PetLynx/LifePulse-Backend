package com.entity;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Patients {
	
	
	

	public Patients(String key, String name, String owner, String species, String diagnosis, String lastSession) {
		
		this.key = key;
		this.name = name;
		this.owner = owner;
		this.species = species;
		this.diagnosis = diagnosis;
		this.lastSession = lastSession;
	}



	@Id
    private String key;
    
	
	@Field
    private String name;
	
	
	@Field
    private String owner;
	
	@Field
    private String species;
	
	
	@Field
    private String diagnosis;
	
	
	
	@Field
    private String lastSession;



	



	public String getKey() {
		return key;
	}



	public void setKey(String key) {
		this.key = key;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getOwner() {
		return owner;
	}



	public void setOwner(String owner) {
		this.owner = owner;
	}



	public String getSpecies() {
		return species;
	}



	public void setSpecies(String species) {
		this.species = species;
	}



	public String getDiagnosis() {
		return diagnosis;
	}



	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}



	public String getLastSession() {
		return lastSession;
	}



	public void setLastSession(String lastSession) {
		this.lastSession = lastSession;
	}
	
	
	
	

}
