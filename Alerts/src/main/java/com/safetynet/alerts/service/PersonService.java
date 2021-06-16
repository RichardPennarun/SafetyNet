package com.safetynet.alerts.service;

import java.util.ArrayList;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.repository.PersonRepository;


@Service
public class PersonService {

	private static Logger logger = LogManager.getLogger(PersonService.class);

	@Autowired
	private PersonRepository personRepository;

	// GET a person by id
	public Optional<Person> getPerson(final int id) {
		return personRepository.findById(id);
	}

	// GET all persons
	public ArrayList<Person> getPersons() {
		ArrayList<Person> persons = (ArrayList<Person>) personRepository.findAll();
		return persons;
	}

	// POST a person
	public Person savePerson(Person person) {
		Person savedPerson = personRepository.save(person);
		return savedPerson;
	}

	// PUT a person
	public Person updatePerson(Person person) {
		int id = 0;
		ArrayList<Person> persons = getPersons();
		for (Person p : persons) {
			if (p.getFirstName().equals(person.getFirstName()) && p.getLastName().equals(person.getLastName())) {
				id = p.getId();
			}
		}
		Optional<Person> personToUpdate = getPerson(id);
		if (personToUpdate.isPresent()) {
			Person modifiedPerson = personToUpdate.get();
			// firstName and lastName non modifiable
			String address = person.getAddress();
			if (address != null) {
				modifiedPerson.setAddress(address);
			}
			String city = person.getCity();
			if (city != null) {
				modifiedPerson.setCity(city);
			}
			String zip = person.getZip();
			if (zip != null) {
				modifiedPerson.setZip(zip);
			}
			String phone = person.getPhone();
			if (phone != null) {
				modifiedPerson.setPhone(phone);
			}
			String email = person.getEmail();
			if (email != null) {
				modifiedPerson.setEmail(email);
			}
			savePerson(modifiedPerson);
			return modifiedPerson;
		} else {
			return null;
		}
	}

	// DELETE a person by firstname/lastname
	public void deletePerson(final String firstname, final String lastname) {
		int id = 0;
		ArrayList<Person> persons = getPersons();
		for (Person person : persons) {
			if (person.getFirstName().equals(firstname) && person.getLastName().equals(lastname)) {
				id = person.getId();
			}
		}
		if (id != 0) {
			logger.info("Response - " + firstname + " " + lastname + " deleted");
			personRepository.deleteById(id);
		} else {
			logger.error("Wrong entry: " + firstname + " " + lastname + " not in database");
		}
	}

}