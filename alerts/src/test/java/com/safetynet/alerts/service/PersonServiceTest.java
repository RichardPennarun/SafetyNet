package com.safetynet.alerts.service;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.Optional;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.repository.PersonRepository;

@SpringBootTest
public class PersonServiceTest {
	
	@Autowired
	private PersonService personService;
	
	@Before
	private void setUp() {
		personService = new PersonService();
	}

	@Test
	public void getPersonsTest() {
		ArrayList<Person> personsList = new ArrayList<>();
		ArrayList<Person> persons = personService.getPersons();
		personsList = (ArrayList<Person>) personService.getPersons();
		assertThat(persons).isEqualTo(personsList);
	}

	@Test
	public void getPersonTest() {
		Optional<Person> person = Optional.of(new Person());
		person = personService.getPerson(2);
		Optional<Person> p = personService.getPerson(2);
		assertThat(p).isEqualTo(person);
	}

	@Test
	public void savePersonTest() {
		Person personToSave = new Person();
		personToSave.setFirstName("richard");
		personToSave.setLastName("pennarun");
		personToSave.setAddress("36 rue des Envierges");
		personToSave.setCity("Paris");
		personToSave.setZip("75020");
		personToSave.setPhone("0655555555");
		personToSave.setEmail("richard@mail.com");
		//when(personRepository.save(personToSave)).thenReturn(personToSave);
		Person createdPerson = personService.savePerson(personToSave);
		assertThat(createdPerson).isEqualTo(personToSave);
		//assertThat(createdPerson.getFirstName()).isEqualTo("richard");
		//assertThat(createdPerson.getLastName()).isEqualTo("pennarun");
		//assertThat(createdPerson.getAddress()).isEqualTo("36 rue des Envierges");
		//assertThat(createdPerson.getCity()).isEqualTo("Paris");
		//assertThat(createdPerson.getZip()).isEqualTo("75020");
		//assertThat(createdPerson.getPhone()).isEqualTo("0655555555");
		//assertThat(createdPerson.getEmail()).isEqualTo("richard@mail.com");
	}

	@Test
	public void updatePersonTest() {
		Person personToUpdate = new Person();
		personToUpdate.setId(2);
		personToUpdate.setFirstName("Jacob");
		personToUpdate.setLastName("Boyd");
		personToUpdate.setAddress("1509 Culver St");
		personToUpdate.setCity("Culver");
		personToUpdate.setZip("97451");
		personToUpdate.setPhone("841-874-6514");
		personToUpdate.setEmail("jaboyd@email.com");
		

		Person personToUpdate2 = new Person();
		personToUpdate2.setId(2);
		personToUpdate2.setFirstName("Jacob");
		personToUpdate2.setLastName("Boy");
		personToUpdate2.setAddress("1509 Culver St");
		personToUpdate2.setCity("Culver");
		personToUpdate2.setZip("97451");
		personToUpdate2.setPhone("841-874-6514");
		personToUpdate2.setEmail("jaboyd@email.com");

		Person updatedPerson = personService.updatePerson(personToUpdate);

		Person updatedPerson2 = personService.updatePerson(personToUpdate2);
		//when(personRepository.findAll()).thenReturn(persons);
		//Optional<Person> personToUpdate = personService.getPerson(2);
		//when(personRepository.findById(2)).thenReturn(personToUpdate);
		//assertThat(personToUpdate).isPresent();
		//when(personService.updatePerson(personToUpdate)).thenReturn(personToUpdate);

		assertThat(updatedPerson2).isEqualTo(null);
		assertThat(updatedPerson).isEqualTo(personToUpdate);
	}


	@Test
	public void deletePersonTest() {
		//Optional<Person> person = personService.getPerson(1);
		personService.deletePerson("John","Boyd");
		Optional<Person> person = personService.getPerson(1);
		assertThat(person).isEmpty();
		
	}
	
	
}
