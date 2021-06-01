package com.safetynet.alerts.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.safetynet.alerts.model.DTO.ResidentByAddressDTO;
import com.safetynet.alerts.repository.ResidentRepository;
import com.safetynet.alerts.repository.DTO.ResidentByAddressDTORepository;
import com.safetynet.alerts.util.Util;

public class CoveredResidentServiceTest {
	
	
	@Before
	private static void setUp() {
		ResidentService residentService = new ResidentService();
		PersonService personService = new PersonService();
		FirestationService firestationService = new FirestationService();
		MedicalRecordService medicalRecordService = new MedicalRecordService();
		ResidentByAddressDTORepository residentByAddressDTORepository;
		ResidentRepository residentRepository;
		Util util = new Util(); 
	}
	
	@Test
	public void getCoveredResidentsTest() {
		// GIVEN
		
		
		
		//assertThat(residentService.getCoveredResidents("1509 Culver St")).isNotNull();
	}


}
