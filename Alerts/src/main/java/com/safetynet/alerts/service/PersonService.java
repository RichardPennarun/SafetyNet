package com.safetynet.alerts.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.repository.PersonRepository;

import lombok.Data;

@Data
@Service
public class PersonService {
	

	private static Logger logger = LogManager.getLogger(PersonService.class);
	
	@Autowired
	private PersonRepository personRepository;
	
	public Optional<Person> getPerson(final int id) {
		return personRepository.findById(id);
	}
	
	public List<Person> getPersons() {
		List<Person> persons = (List<Person>) personRepository.findAll();
		logger.info("Response - All persons:" + persons);
		return persons;
	}
		
	public Person savePerson(Person person) {
		Person savedPerson = personRepository.save(person);
		logger.info("Response - " + savedPerson + " saved");
		return savedPerson;
	}
		
	public void deletePerson(final String firstname, final String lastname) {
		int id = 0;
		List<Person> persons = getPersons();
		
		for (Person person : persons) {
			if(person.getFirstName().equals(firstname) 
					&& person.getLastName().equals(lastname)) {
				id = person.getId();
			}
		}
		
		personRepository.deleteById(id);
		logger.info("Response - " + firstname + " " + lastname + " deleted");
	}
	
}