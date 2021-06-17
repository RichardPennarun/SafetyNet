package com.safetynet.alerts.model.DTO;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.safetynet.alerts.model.CoveredPerson;

@Entity
public class CoveredPersonDTO {
	
	@Id
	@JsonIgnore
	private int id;
	
	private int stationNumber;
	
	private int adults;
	
	private int children;
	
	private ArrayList<CoveredPerson> coveredPersons;
	
	public CoveredPersonDTO() {
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getStationNumber() {
		return stationNumber;
	}
	
	public void setStationNumber(int stationNumber) {
		this.stationNumber = stationNumber;
	}
	
	public int getAdults() {
		return adults;
	}
	
	public void setAdults(int adults) {
		this.adults = adults;
	}
	
	public int getChildren() {
		return children;
	}
	
	public void setChildren(int children) {
		this.children = children;
	}
	
	public ArrayList<CoveredPerson> getCoveredPersons() {
		return coveredPersons;
	}
	
	public void setCoveredPersons(ArrayList<CoveredPerson> coveredPersons) {
		this.coveredPersons = coveredPersons;
	}
	
	@Override
	public String toString() {
		return "CoveredPersonDTO [stationNumber=" + stationNumber + 
				", adults=" + adults + ", children=" + children +
				", coveredPersons=" + coveredPersons + "]";
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		CoveredPersonDTO that = (CoveredPersonDTO) o;
		return id == that.id;
	}

}
