package com.safetynet.alerts.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class CoveredResident {
	
	@Id
	@JsonIgnore
	private int id;
	
	private int station;
	
	private ArrayList<Resident> residents;

}
