package com.safetynet.alerts.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class CoveredPerson {
	
	@Id
	@JsonIgnore
	private int id;
	
	private String firstName;
	
	private String lastName;
	
	private String address;
	
	private String city;
	
	private String zip;
	
	private String phone;
	
	private int age;
	
	public CoveredPerson() {
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
	
	@Override
	public String toString() {
		return "CoveredPerson [firstName=" + firstName + ", lastName=" + lastName + 
				", address=" + address + ", city=" + city + ", zip=" + zip + 
				", phone=" + phone + ", age=" + age +"]";
		
	}

}
