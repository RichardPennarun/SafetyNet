package com.safetynet.alerts.service;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.safetynet.alerts.model.CoveredPerson;
import com.safetynet.alerts.model.Firestation;
import com.safetynet.alerts.model.MedicalRecord;
import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.model.DTO.CoveredPersonDTO;
import com.safetynet.alerts.util.Util;

@SpringBootTest
public class CoveredPersonServiceTest {

	@Autowired
	private CoveredPersonService coveredPersonService;

	@Autowired
	private FirestationService firestationService;

	@Autowired
	private PersonService personService;

	@Autowired
	private MedicalRecordService medicalRecordService;

	@Before
	private void setUp() {
		coveredPersonService = new CoveredPersonService();
		firestationService = new FirestationService();
		personService = new PersonService();
		medicalRecordService = new MedicalRecordService();
	}

	@Test
	public void getCoveredPersonsTest() {
		CoveredPersonDTO coveredPersonDTO = new CoveredPersonDTO();
		Util util = new Util();
		String address = "";
		int stationNumber = 3;

		ArrayList<Firestation> firestations = firestationService.getFirestations();
		for (Firestation fs : firestations) {
			if (fs.getStationNumber().equals(stationNumber)) {
				address = fs.getAddress();
				ArrayList<Person> persons = personService.getPersons();
				for (Person p : persons) {
					CoveredPerson coveredPerson = new CoveredPerson();
					if (p.getAddress().equals(address)) {
						ArrayList<CoveredPerson> coveredPersons = new ArrayList<>();
						coveredPerson.setId(p.getId());
						coveredPerson.setFirstName(p.getFirstName());
						coveredPerson.setLastName(p.getLastName());
						coveredPerson.setAddress(p.getAddress());
						coveredPerson.setCity(p.getCity());
						coveredPerson.setZip(p.getZip());
						coveredPerson.setPhone(p.getPhone());

						ArrayList<MedicalRecord> medicalrecords = medicalRecordService.getMedicalRecords();
						for (MedicalRecord mr : medicalrecords) {
							if (mr.getFirstName().equals(coveredPerson.getFirstName())
									&& mr.getLastName().equals(coveredPerson.getLastName())) {
								coveredPerson.setAge(util.getAge(mr.getBirthdate()));
							}
						}
						coveredPersons.add(coveredPerson);
						coveredPersonDTO.setStationNumber(3);
						coveredPersonDTO.setAdults(5);
						coveredPersonDTO.setChildren(3);
						coveredPersonDTO.setCoveredPersons(coveredPersons);
					}
				}
			}
		}

		CoveredPersonDTO getCoveredPersons = coveredPersonService.getCoveredPersons(3);

		assertThat(getCoveredPersons).isEqualTo(coveredPersonDTO);
	}
}
