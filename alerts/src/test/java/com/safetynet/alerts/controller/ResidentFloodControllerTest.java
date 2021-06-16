package com.safetynet.alerts.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Before;
import org.junit.jupiter.api.Disabled;
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
import com.safetynet.alerts.model.DTO.ResidentByStationDTO;
import com.safetynet.alerts.service.CoveredPersonService;
import com.safetynet.alerts.service.FirestationService;
import com.safetynet.alerts.service.MedicalRecordService;
import com.safetynet.alerts.service.PersonService;
import com.safetynet.alerts.service.ResidentFireService;
import com.safetynet.alerts.service.ResidentFloodService;
import com.safetynet.alerts.util.Util;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ResidentFloodControllerTest {

	@Autowired
	private ResidentFloodController residentFloodController;

	@MockBean
	@Autowired
	private ResidentFloodService residentFloodService;
	
	@Autowired
	private PersonService personService;
	
	@Autowired
	private MedicalRecordService medicalRecordService;

	@Autowired
	private FirestationService firestationService;

	@Before
	private void setUp() {
		residentFloodController = new ResidentFloodController();
		residentFloodService = new ResidentFloodService();
		personService = new PersonService();
		medicalRecordService = new MedicalRecordService();
		firestationService = new FirestationService();
	}

	@Test
	public void getResidentsByStationNumberTest() {
		ArrayList<ResidentByStationDTO> residentsByStation = new ArrayList<>();
		Util util = new Util();
		String stationNumbers = "1 2";
		String address = "";
		Scanner scanner = new Scanner(stationNumbers);
		ArrayList<Integer> stations = new ArrayList<Integer>();
		while (scanner.hasNextInt()) {
			stations.add(scanner.nextInt());
		}

		for (Integer station : stations) {

			ArrayList<Firestation> firestations = firestationService.getFirestations();
			for (Firestation fs : firestations) {
				if (fs.getStationNumber().equals(station)) {
					address = fs.getAddress();
					ArrayList<Resident> residents = new ArrayList<>();
					ResidentByStationDTO residentByStation = new ResidentByStationDTO();

					ArrayList<Person> persons = personService.getPersons();
					for (Person p : persons) {
						if (p.getAddress().equals(address)) {
							Resident resident = new Resident();
							resident.setId(p.getId());
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
						residentByStation.setResidents(residents);
						residentByStation.setStationNumber(station);
						residentByStation.setAddress(address);
					}

					residentsByStation.add(residentByStation);
				}
			}
		}
		
		when(residentFloodService.getResidentsByStationNumber("1 2")).thenReturn(residentsByStation);

		ArrayList<ResidentByStationDTO> getResidentsByStation = residentFloodController.getResidentByStationNumber("1 2");
		
		assertThat(getResidentsByStation).isEqualTo(residentsByStation);
	}

	@Test
	public void getNoResidentsByStationNumberTest() {

		when(residentFloodService.getResidentsByStationNumber("1 2")).thenReturn(null);

		ArrayList<ResidentByStationDTO> getResidentsByStations = residentFloodController.getResidentByStationNumber("1 2");

		assertThat(getResidentsByStations).isEqualTo(null);
	}



}
