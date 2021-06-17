package com.safetynet.alerts.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "firestations")
public class Firestation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private Integer id;

	private String address;

	@Column(name="station_number")
	private Integer stationNumber;
	
	public Firestation() {
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public Integer getStationNumber() {
		return stationNumber;
	}
	
	public void setStationNumber(Integer stationNumber) {
		this.stationNumber = stationNumber;
	}
	
	@Override
	public String toString() {
		return "Firestation [address=" + address + 
				", stationNumber=" + stationNumber + "]";
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Firestation that = (Firestation) o;
		return id == that.id;
	}

}