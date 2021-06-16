package com.safetynet.alerts.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Resident {
	
	@Id
	@JsonIgnore
	private int id;
	
	private String firstName;
	
	private String lastName;
	
	private String phone;
	
	private int age;
	
	private String medications;
	
	private String allergies;
	
	public Resident() {
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getMedications() {
		return medications;
	}
	
	public void setMedications(String medications) {
		this.medications = medications;
	}
	
	public String getAllergies() {
		return allergies;
	}
	
	public void setAllergies(String allergies) {
		this.allergies = allergies;
	}
	
	@Override
	public String toString() {
		return "Resident [firstName=" + firstName + ", lastName=" + lastName + 
				", phone=" + phone + ", age=" + age + ", medications=" + medications + 
				", allergies=" + allergies +"]";
		
	}

}
