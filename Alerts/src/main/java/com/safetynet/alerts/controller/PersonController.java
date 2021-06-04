package com.safetynet.alerts.controller;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	/*
	 * Get all persons
	 * @return - The list of all persons
	 */
	@GetMapping("/persons")
	public List<Person> getPersons() {
        logger.info("Request - Get all persons");
		List<Person> persons = personService.getPersons();
		return persons;
	}
	
	/*
	 * Save a new person
	 * @param - An object person
	 * @return - The person object saved
	 */
	@PostMapping("/person")
	public Person createPerson(@RequestBody Person person) {
		logger.info("Request create person @RequestBody = {} ", person);
		return personService.savePerson(person);
	}
	
	/*
	 * Update existing person
	 * @param  - id
	 * @param - The person with modifications
	 * firstname/lastname can't be modified 
	 * @return - The modified person
	 */
	@PutMapping("/person/{id}")
	public Person updatePerson(@PathVariable("id") final int id, 
			@RequestBody Person person) {
		logger.info("Request update person @RequestBody = {} ", person);
		Optional<Person> p = personService.getPerson(id);
		if(p.isPresent()) {
			Person modifiedPerson = p.get();
			
			String address = person.getAddress();
			if(address != null) {
				modifiedPerson.setAddress(address);
			}
			String city = person.getCity();
			if(city != null) {
				modifiedPerson.setCity(city);
			}
			String zip = person.getZip();
			if(zip != null) {
				modifiedPerson.setZip(zip);
			}
			String phone = person.getPhone();
			if(phone != null) {
				modifiedPerson.setPhone(phone);
			}
			String email = person.getEmail();
			if(email != null) {
				modifiedPerson.setEmail(email);
			}
			personService.savePerson(modifiedPerson);
			return modifiedPerson;
		} else {
			return null;
		}
	}
	
	/*
	 * Delete a person by combination firstname/lastname
	 * @param - firstname, lastname
	 */
	@DeleteMapping("/person")
	public void deletePerson(@RequestParam("firstname") final String firstname,
						@RequestParam("lastname") final String lastname) {
        logger.info("Request Delete person firstname {}, lastname {}", firstname, lastname);
		personService.deletePerson(firstname, lastname);
        logger.info("Person deleted firstname {}, lastname {}", firstname, lastname);
	}

}