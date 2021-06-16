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
import com.safetynet.alerts.model.DTO.CoveredPersonDTO;
import com.safetynet.alerts.service.CoveredPersonService;
import com.safetynet.alerts.service.FirestationService;
import com.safetynet.alerts.service.MedicalRecordService;
import com.safetynet.alerts.service.PersonService;
import com.safetynet.alerts.util.Util;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class CoveredPersonControllerTest {

	@Autowired
	private CoveredPersonController coveredPersonController;

	@MockBean
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
		coveredPersonController = new CoveredPersonController();
		coveredPersonService = new CoveredPersonService();
		firestationService = new FirestationService();
		personService = new PersonService();
		medicalRecordService = new MedicalRecordService();
	}

	@Test
	public void getCoveredPersonsTest() {
		Util util = new Util();
		ArrayList<CoveredPerson> cp = new ArrayList<>();
		CoveredPersonDTO coveredPersons = new CoveredPersonDTO();
		
		ArrayList<Firestation> firestations = firestationService.getFirestations();
		for (Firestation fs : firestations) {
			if (fs.getStationNumber().equals(3)) {
				ArrayList<Person> persons = personService.getPersons();
				for (Person p : persons) {
					if (p.getAddress().equals(fs.getAddress())) {
						CoveredPerson coveredPerson = new CoveredPerson();
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
						cp.add(coveredPerson);
					}
				}

			}
			coveredPersons.setStationNumber(3);
			coveredPersons.setAdults(5);
			coveredPersons.setChildren(3);
			coveredPersons.setCoveredPersons(cp);
		}
		
		when(coveredPersonService.getCoveredPersons(3)).thenReturn(coveredPersons);

		CoveredPersonDTO getCoveredPersons = coveredPersonController.getCoveredPersons(3);
		
		assertThat(getCoveredPersons).isEqualTo(coveredPersons);
	}

	@Test
	public void getNoCoveredPersonsTest() {

		when(coveredPersonService.getCoveredPersons(7)).thenReturn(null);

		CoveredPersonDTO getCoveredPersons = coveredPersonController.getCoveredPersons(7);

		assertThat(getCoveredPersons).isEqualTo(null);
	}
}
