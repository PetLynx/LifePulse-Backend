package com.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

public class Devices {

	
	
	public Devices(String key, String deviceName, String site, String room, String status, String lastUsed) {
		super();
		this.key = key;
		this.deviceName = deviceName;
		this.site = site;
		this.room = room;
		this.status = status;
		this.lastUsed = lastUsed;
	}



	@Id
    private String key;
    
	
	@Field
    private String deviceName;
	
	
	@Field
    private String site;
	
	@Field
    private String room;
	
	
	@Field
    private String status;
	
	
	
	@Field
	 private String lastUsed;



	



	public String getKey() {
		return key;
	}



	public void setKey(String key) {
		this.key = key;
	}



	public String getDeviceName() {
		return deviceName;
	}



	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}



	public String getSite() {
		return site;
	}



	public void setSite(String site) {
		this.site = site;
	}



	public String getRoom() {
		return room;
	}



	public void setRoom(String room) {
		this.room = room;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public String getLastUsed() {
		return lastUsed;
	}



	public void setLastUsed(String lastUsed) {
		this.lastUsed = lastUsed;
	}
}
