package com.safetynet.alerts.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.safetynet.alerts.model.Firestation;
import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.service.CommunityEmailService;
import com.safetynet.alerts.service.FirestationService;
import com.safetynet.alerts.service.PersonService;
import com.safetynet.alerts.service.PhoneAlertService;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class PhoneAlertControllerTest {
	
	@Autowired
	private PhoneAlertController phoneAlertController;
	
	@MockBean
	@Autowired
	private PhoneAlertService phoneAlertService;
	
	@Autowired
	private PersonService personService;
	
	@Autowired
	private FirestationService firestationService;
	
	@Before
	private void setUp() {
		personService = new PersonService();
		firestationService = new FirestationService();
		phoneAlertService = new PhoneAlertService();
		phoneAlertController = new PhoneAlertController();
	}
	
	@Test
	public void getPhonesTest() {

		ArrayList<String> getphones = new ArrayList<>();
		ArrayList<String> personPhones = new ArrayList<>();
		ArrayList<String> addressList = new ArrayList<>();

		ArrayList<Firestation> firestations = firestationService.getFirestations();
		for (Firestation firestation : firestations) {
			if (firestation.getStationNumber().equals(2)) {
				addressList.add(firestation.getAddress());
			}
		}
		ArrayList<Person> persons = personService.getPersons();
		for (String address : addressList) {
			for (Person person : persons) {
				if (person.getAddress().equals(address)) {
					personPhones.add(person.getPhone());
				}
			}
		}
		when(phoneAlertService.getPhones(2)).thenReturn(personPhones);
		
		getphones = (ArrayList<String>) phoneAlertController.getPhones(2);
		
		assertThat(getphones).isEqualTo(personPhones);
	}
	
	
	@Test
	public void getNoPhonesTest() {

		ArrayList<String> getphones = new ArrayList<>();
		ArrayList<String> personPhones = new ArrayList<>();
		ArrayList<String> addressList = new ArrayList<>();

		ArrayList<Firestation> firestations = firestationService.getFirestations();
		for (Firestation firestation : firestations) {
			if (firestation.getStationNumber().equals(6)) {
				addressList.add(firestation.getAddress());
			}
		}
		ArrayList<Person> persons = personService.getPersons();
		for (String address : addressList) {
			for (Person person : persons) {
				if (person.getAddress().equals(address)) {
					personPhones.add(person.getPhone());
				}
			}
		}
		when(phoneAlertService.getPhones(6)).thenReturn(personPhones);
		
		getphones = (ArrayList<String>) phoneAlertController.getPhones(6);
		
		assertThat(getphones).isEqualTo(null);
	}
	
}
