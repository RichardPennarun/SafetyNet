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
import com.safetynet.alerts.service.PersonService;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class PersonControllerTest {
	
	@Autowired
	private PersonController personController;
	
	@MockBean
	@Autowired
	private PersonService personService;
	
	@Before
	private void setUp() {
		personService = new PersonService();
		personController = new PersonController ();
	}

	@Test
	public void getPersonsTest() {
		ArrayList<Person> personsList = new ArrayList<>();
		ArrayList<Person> persons = personService.getPersons();
		when(personService.getPersons()).thenReturn(persons);
		personsList = (ArrayList<Person>) personController.getPersons();
		assertThat(persons).isEqualTo(personsList);
	}

	@Test
	public void createPersonTest() {
		Person person = new Person();
		person.setFirstName("richard");
		person.setLastName("pennarun");
		person.setAddress("36 rue des Envierges");
		person.setCity("Paris");
		person.setZip("75020");
		person.setPhone("0655555555");
		person.setEmail("richard@mail.com");
		when(personService.savePerson(person)).thenReturn(person);
		Person createdPerson = personController.createPerson(person);
		assertThat(createdPerson).isEqualTo(person);
	}

	@Test
	public void createNoPersonTest() {
		Person person = new Person();
		person.setFirstName("richard");
		person.setLastName(null);
		person.setAddress("36 rue des Envierges");
		person.setCity("Paris");
		person.setZip("75020");
		person.setPhone("0655555555");
		person.setEmail("richard@mail.com");
		when(personService.savePerson(person)).thenReturn(null);
		Person createdPerson = personController.createPerson(person);
		assertThat(createdPerson).isEqualTo(null);
	}

	@Test
	public void updatePersonTest() {
		Person person = new Person();
		person.setFirstName("richard");
		person.setLastName("pennarun");
		person.setAddress("36 rue des Envierges");
		person.setCity("Paris");
		person.setZip("75020");
		person.setPhone("0655555555");
		person.setEmail("richard@mail.com");
		when(personService.updatePerson(person)).thenReturn(person);
		Person updatedPerson = personController.updatePerson(person);
		assertThat(updatedPerson).isEqualTo(person);
	}

	@Test
	public void updateNoPersonTest() {
		Person person = new Person();
		person.setFirstName("richard");
		person.setLastName(null);
		person.setAddress("36 rue des Envierges");
		person.setCity("Paris");
		person.setZip("75020");
		person.setPhone("0655555555");
		person.setEmail("richard@mail.com");
		when(personService.updatePerson(person)).thenReturn(null);
		Person updatedPerson = personController.updatePerson(person);
		assertThat(updatedPerson).isEqualTo(null);
	}


	@Test
	public void deletePersonTest() {
		personController.deletePerson("John","Boyd");
	}
	
	
}
