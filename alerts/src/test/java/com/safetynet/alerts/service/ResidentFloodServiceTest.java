package com.safetynet.alerts.service;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.safetynet.alerts.model.Firestation;
import com.safetynet.alerts.model.MedicalRecord;
import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.model.Resident;
import com.safetynet.alerts.model.DTO.ResidentByStationDTO;
import com.safetynet.alerts.util.Util;

@SpringBootTest
public class ResidentFloodServiceTest {

	@Autowired
	private ResidentFloodService residentFloodService;

	@Autowired
	private FirestationService firestationService;
	
	@Autowired
	private PersonService personService;
	
	@Autowired
	private MedicalRecordService medicalRecordService;
	
	Scanner scanner;

	@Before
	private void setUp() {
		residentFloodService = new ResidentFloodService();
		firestationService = new FirestationService();
		personService = new PersonService();
		medicalRecordService = new MedicalRecordService();
	}

	@Test
	public void getResidentsByStationNumberTest() {
		ArrayList<ResidentByStationDTO> residentsByStation = new ArrayList<>();
		Util util = new Util();
		String stationNumbers = "1 2";
		String address = "";
		scanner = new Scanner(stationNumbers);
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

		ArrayList<ResidentByStationDTO> getResidentsByStation = residentFloodService.getResidentsByStationNumber("1 2");
		
		assertThat(getResidentsByStation).isEqualTo(residentsByStation);

		//assertThat(getResidentsAtAddress.getId()).isEqualTo(residentByAddress.getId());
		//assertThat(getResidentsAtAddress.getResidents()).isEqualTo(residentByAddress.getResidents());
		//assertThat(getResidentsAtAddress.getStationNumber()).isEqualTo(residentByAddress.getStationNumber());
	}
}
