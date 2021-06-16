package com.safetynet.alerts.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class PersonInfo {
	
	@Id
	@JsonIgnore
	private int id;
	
	private String firstName;
	
	private String lastName;
	
	private String address;
	
	private String city;
	
	private String zip;
	
	private int age;
	
	private String email;
	
	private String medications;
	
	private String allergies;
	
	public PersonInfo() {
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
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getZip() {
		return zip;
	}
	
	public void setZip(String zip) {
		this.zip = zip;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
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
		return "PersonInfo [firstName=" + firstName + ", lastName=" + lastName + 
				", address=" + address + ", city=" + city + ", zip=" + zip + ", age=" + age + 
				", email=" + email + ", medications=" + medications + ", allergies=" + allergies +"]";
		
	}
	
	

}


