package com.safetynet.alerts.model.DTO;


import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.safetynet.alerts.model.Resident;

@Entity
public class ResidentByAddressDTO {
	
	@Id
	@JsonIgnore
	private int id;
	
	private int stationNumber;
	
	private ArrayList<Resident> residents;
	
	public ResidentByAddressDTO() {
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
	
	public ArrayList<Resident> getResidents() {
		return residents;
	}
	
	public void setResidents(ArrayList<Resident> residents) {
		this.residents = residents;
	}
	
	@Override
	public String toString() {
		return "ResidentByAddressDTO [stationNumber=" + stationNumber + 
				", residents=" + residents +"]";
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		ResidentByAddressDTO that = (ResidentByAddressDTO) o;
		return id == that.id;
	}

}














