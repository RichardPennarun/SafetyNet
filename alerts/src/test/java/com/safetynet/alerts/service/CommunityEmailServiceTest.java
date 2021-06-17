package com.safetynet.alerts.service;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.safetynet.alerts.model.Person;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class CommunityEmailServiceTest {
	
	@Autowired
	private CommunityEmailService communityEmailService;


	@Autowired
	private PersonService personService;
	
	@Before
	private void setUp() {
		personService = new PersonService();
		communityEmailService = new CommunityEmailService();
	}
	
	@Test
	public void getEmailsTest() {

		ArrayList<String> personEmails = new ArrayList<>();
		ArrayList<String> getemails = new ArrayList<>();
		ArrayList<Person> persons = personService.getPersons();
		for (Person person : persons) {
			if(person.getCity().equalsIgnoreCase("Culver")) {
				personEmails.add(person.getEmail());
			}
		}
		
		//when(communityEmailService.getEmails("Culver")).thenReturn(personEmails);
		
		getemails = (ArrayList<String>) communityEmailService.getEmails("Culver");
		
		assertThat(getemails).isEqualTo(personEmails);
	}
	
}
