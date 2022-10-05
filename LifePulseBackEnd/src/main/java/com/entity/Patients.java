package com.entity;
import java.util.List;
import java.util.Map;

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


	@Field
    private String breed;
	
	@Field
    private String dob;

	@Field
    private String sex;
	
	@Field
    private String reproduction;
	
	
	
	@Field
	private Map<String,String> histology;
	
	@Field
	private TherapyPatient theraphies;
	
	
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



	public String getBreed() {
		return breed;
	}



	public void setBreed(String breed) {
		this.breed = breed;
	}



	public String getDob() {
		return dob;
	}



	public void setDob(String dob) {
		this.dob = dob;
	}



	public String getSex() {
		return sex;
	}



	public void setSex(String sex) {
		this.sex = sex;
	}



	public String getReproduction() {
		return reproduction;
	}



	public void setReproduction(String reproduction) {
		this.reproduction = reproduction;
	}
	
	
	
	

}
