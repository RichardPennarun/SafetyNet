package com.safetynet.alerts.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.safetynet.alerts.model.CoveredPerson;
import com.safetynet.alerts.model.Firestation;
import com.safetynet.alerts.model.MedicalRecord;
import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.model.Resident;
import com.safetynet.alerts.model.DTO.CoveredPersonDTO;
import com.safetynet.alerts.model.DTO.ResidentByAddressDTO;
import com.safetynet.alerts.service.CoveredPersonService;
import com.safetynet.alerts.service.FirestationService;
import com.safetynet.alerts.service.MedicalRecordService;
import com.safetynet.alerts.service.PersonService;
import com.safetynet.alerts.service.ResidentFireService;
import com.safetynet.alerts.util.Util;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ResidentFireControllerTest {

	@Autowired
	private ResidentFireController residentFireController;

	@MockBean
	@Autowired
	private ResidentFireService residentFireService;
	
	@Autowired
	private PersonService personService;
	
	@Autowired
	private MedicalRecordService medicalRecordService;

	@Autowired
	FirestationService firestationService;

	@Before
	private void setUp() {
		residentFireController = new ResidentFireController();
		residentFireService = new ResidentFireService();
		personService = new PersonService();
		medicalRecordService = new MedicalRecordService();
		firestationService = new FirestationService();
	}

	@Test
	public void getResidentByAdressTest() {
		ResidentByAddressDTO residentsAtAddress = new ResidentByAddressDTO();
		Util util = new Util();
		ArrayList<Resident> residents = new ArrayList<>();
		ArrayList<Person> persons = personService.getPersons();
		for (Person p : persons) {
			if (p.getAddress().equals("1509 Culver St")) {
				Resident resident = new Resident();
				int id = p.getId();
				resident.setId(id);
				resident.setFirstName(p.getFirstName());
				resident.setLastName(p.getLastName());
				resident.setPhone(p.getPhone());

				ArrayList<MedicalRecord> medicalrecords = medicalRecordService.getMedicalRecords();
				for (MedicalRecord mr : medicalrecords) {
					if (mr.getFirstName().equals(resident.getFirstName())
							&& mr.getLastName().equals(resident.getLastName())) {
						resident.setAge(util.getAge(mr.getBirthdate()));
						resident.setMedications(mr.getMedications());
						resident.setAllergies(mr.getAllergies());
					}
				}
				residents.add(resident);
			}
		}
		residentsAtAddress.setResidents(residents);

		ArrayList<Firestation> firestations = firestationService.getFirestations();
		for (Firestation fs : firestations) {
			if (fs.getAddress().equals("1509 Culver St")) {
				residentsAtAddress.setStationNumber(fs.getStationNumber());
			}
		}
		
		when(residentFireService.getResidentByAdress("1509 Culver St")).thenReturn(residentsAtAddress);

		ResidentByAddressDTO getResidentsAtAddress = residentFireController.getResidentByAddress("1509 Culver St");
		
		assertThat(getResidentsAtAddress).isEqualTo(residentsAtAddress);
	}

	@Test
	public void getNoResidentByAdressTest() {

		when(residentFireService.getResidentByAdress("1509 Culver St")).thenReturn(null);

		ResidentByAddressDTO getResidentsAtAddress = residentFireController.getResidentByAddress("1509 Culver St");

		assertThat(getResidentsAtAddress).isEqualTo(null);
	}



}
