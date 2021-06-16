package com.safetynet.alerts.service;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.safetynet.alerts.model.MedicalRecord;
import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.model.Resident;
import com.safetynet.alerts.model.DTO.ResidentByAddressDTO;
import com.safetynet.alerts.util.Util;

@SpringBootTest
public class ResidentFireServiceTest {

	@Autowired
	private ResidentFireService residentFireService;
	
	@Autowired
	private PersonService personService;
	
	@Autowired
	private MedicalRecordService medicalRecordService;

	@Before
	private void setUp() {
		residentFireService = new ResidentFireService();
		personService = new PersonService();
		medicalRecordService = new MedicalRecordService();
	}

	@Test
	public void getResidentByAdressTest() {
		ResidentByAddressDTO residentByAddress = new ResidentByAddressDTO();
		ArrayList<Resident> residents = new ArrayList<>();
		Util util = new Util();

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
		residentByAddress.setResidents(residents);
		residentByAddress.setStationNumber(3);

		//when(residentFireService.getResidentByAdress("1509 Culver St")).thenReturn(residentByAddress);
		ResidentByAddressDTO getResidentsAtAddress = residentFireService.getResidentByAdress("1509 Culver St");

		assertThat(getResidentsAtAddress).isEqualTo(residentByAddress);

		//assertThat(getResidentsAtAddress.getId()).isEqualTo(residentByAddress.getId());
		//assertThat(getResidentsAtAddress.getResidents()).isEqualTo(residentByAddress.getResidents());
		//assertThat(getResidentsAtAddress.getStationNumber()).isEqualTo(residentByAddress.getStationNumber());
	}
}
