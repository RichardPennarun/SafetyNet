package com.safetynet.alerts.model.DTO;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.safetynet.alerts.model.Resident;

import lombok.Data;

@Data
@Entity
public class ResidentByAddressDTO {
	
	@Id
	@JsonIgnore
	private int id;
	
	private int station;
	
	private ArrayList<Resident> residents;

}
