package com.safetynet.alerts.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class PersonInfo {
	
	@Id
	@JsonIgnore
	private int id;
	
	private String firstName;
	
	private String lastName;
	
	private String address;
	
	private int age;
	
	private String email;
	
	private String medications;
	
	private String allergies;

}
