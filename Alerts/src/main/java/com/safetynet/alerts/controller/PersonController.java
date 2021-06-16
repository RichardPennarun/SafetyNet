package com.safetynet.alerts.controller;

import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.service.PersonService;

@RestController
public class PersonController {

	private static Logger logger = LogManager.getLogger(PersonController.class);

	@Autowired
	PersonService personService;

	// Get all persons, returns a list of all persons
	@GetMapping("/persons")
	public ArrayList<Person> getPersons() {
		logger.info("Request - Get all persons");
		ArrayList<Person> persons = personService.getPersons();
		logger.info("Response - Returns all persons: " + persons);
		return persons;
	}

	// Add a person, @param an object person, @return - The person object added
	@PostMapping("/person")
	public Person createPerson(@RequestBody Person person) {
		logger.info("Request - Create person @RequestBody = {} ", person);
		Person createdPerson = personService.savePerson(person);
		if (createdPerson == null) {
			logger.error("Wrong entry, missing some arguments:" + person);
			return null;
		} else {
			logger.info("Response - Person saved: " + createdPerson);
			return createdPerson;
		}
	}

	// Update existing person, @param the modified person (firstname/lastname can't be modified)
	// @return the updated person
	@PutMapping("/person")
	public Person updatePerson(@RequestBody Person person) {
		logger.info("Request - Update person @RequestBody = {} ", person);
		Person updatedPerson = personService.updatePerson(person);
		if (updatedPerson == null) {
			logger.error("Wrong entry, missing some arguments:" + person);
			return null;
		} else {
			logger.info("Response - Person updated: " + updatedPerson);
			return updatedPerson;
		}
	}

	// Delete a person by combination firstname/lastname, @param firstname/lastname
	@DeleteMapping("/person")
	public void deletePerson(@RequestParam("firstname") final String firstname,
			@RequestParam("lastname") final String lastname) {
		logger.info("Request - Delete person firstname {}, lastname {}", firstname, lastname);
		personService.deletePerson(firstname, lastname);
	}

}