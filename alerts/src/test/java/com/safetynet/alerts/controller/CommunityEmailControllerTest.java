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
import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.service.CommunityEmailService;
import com.safetynet.alerts.service.PersonService;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class CommunityEmailControllerTest {
	
	@Autowired
	private CommunityEmailController communityEmailController;
	
	@MockBean
	@Autowired
	private CommunityEmailService communityEmailService;

	
	@Autowired
	private PersonService personService;
	
	@Before
	private void setUp() {
		personService = new PersonService();
		communityEmailService = new CommunityEmailService();
		communityEmailController = new CommunityEmailController();
	}
	
	@Test
	public void getEmailsTest() {

		ArrayList<String> personEmails = new ArrayList<>();
		ArrayList<String> getemails = new ArrayList<>();
		ArrayList<Person> persons = (ArrayList<Person>) personService.getPersons();
		for (Person person : persons) {
			if(person.getCity().equalsIgnoreCase("Culver")) {
				personEmails.add(person.getEmail());
			}
		}
		when(communityEmailService.getEmails("Culver")).thenReturn(personEmails);
		
		getemails = (ArrayList<String>) communityEmailController.getEmails("Culver");
		
		assertThat(getemails).isEqualTo(personEmails);
	}
	
	@Test
	public void getNoEmailsTest() {

		ArrayList<String> personEmails = new ArrayList<>();
		ArrayList<String> getemails = new ArrayList<>();
		ArrayList<Person> persons = (ArrayList<Person>) personService.getPersons();
		for (Person person : persons) {
			if(person.getCity().equalsIgnoreCase("Culve")) {
				personEmails.add(person.getEmail());
			}
		}
		when(communityEmailService.getEmails("Culve")).thenReturn(personEmails);
		
		getemails = (ArrayList<String>) communityEmailController.getEmails("Culve");
		
		assertThat(getemails).isEqualTo(null);
	}
	
}
