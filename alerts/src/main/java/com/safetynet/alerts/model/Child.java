package com.safetynet.alerts.model;

import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.safetynet.alerts.model.DTO.ResidentByStationDTO;

@Entity
public class Child {
	
	@Id
	@JsonIgnore
	private int id;
	
	private String firstName;
	
	private String lastName;
	
	private int age;
	
	private ArrayList<String> coresidents;

	public Child() {
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
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public ArrayList<String> getCoresidents() {
		return coresidents;
	}
	
	public void setCoresidents(ArrayList<String> coresidents) {
		this.coresidents = coresidents;
	}
	
	@Override
	public String toString() {
		return "Child [firstName=" + firstName + ", lastName=" + lastName + 
				", age=" + age + ", coresidents=" + coresidents +"]";
		
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Child that = (Child) o;
		return id == that.id;
	}

}

