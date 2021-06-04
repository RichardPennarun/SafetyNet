package com.safetynet.alerts.model.DTO;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.safetynet.alerts.model.CoveredPerson;
import com.safetynet.alerts.model.Resident;

import lombok.Data;

@Data
@Entity
public class CoveredPersonDTO {
	
	@Id
	@JsonIgnore
	private int id;
	
	private int stationNumber;
	
	private int adults;
	
	private int children;
	
	private ArrayList<CoveredPerson> coveredPersons;


}
