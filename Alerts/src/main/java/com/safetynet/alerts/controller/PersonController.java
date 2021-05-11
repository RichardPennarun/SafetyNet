package com.safetynet.alerts.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.service.PersonService;

@RestController
public class PersonController {
	
	@Autowired
	PersonService personService;
	
	 // @return - An Iterable object of persons full filled
	@GetMapping("/persons")
	public Iterable<Person> getPersons() {
		return personService.getPersons();
	}
	
	 // @param id The id of the person
	 // @return a person object full filled
	@GetMapping("/person/{id}")
	public Person getPerson(@PathVariable("id") final int id) {
		Optional<Person> person = personService.getPerson(id);
		if(person.isPresent()) {
			return person.get();
		} else {
			return null;
		}
	}
	
	//@param id - The id of the person to delete
	@DeleteMapping("/person/{id}")
	public void deletePerson(@PathVariable("id") final int id) {
		personService.deletePerson(id);
	}
	
	// @param person An object person
	// @return The person object saved
	@PostMapping("/person")
	public Person createPerson(@RequestBody Person person) {
		return personService.savePerson(person);
	}
	
	//@param id - The id of the person to update
	//@param person - The person object updated
	//@return
	@PutMapping("/person/{id}")
	public Person updatePerson(@PathVariable("id") final int id, 
			@RequestBody Person person) {
		Optional<Person> p = personService.getPerson(id);
		if(p.isPresent()) {
			Person currentPerson = p.get();
			
			String firstName = person.getFirstName();
			if(firstName != null) {
				currentPerson.setFirstName(firstName);
			}
			String lastName = person.getLastName();
			if(lastName != null) {
				currentPerson.setLastName(lastName);
			}
			String address = person.getAddress();
			if(address != null) {
				currentPerson.setAddress(address);
			}
			String city = person.getCity();
			if(city != null) {
				currentPerson.setCity(city);
			}
			Integer zip = person.getZip();
			if(zip != null) {
				currentPerson.setZip(zip);
			}
			String phone = person.getPhone();
			if(phone != null) {
				currentPerson.setPhone(phone);
			}
			String email = person.getEmail();
			if(email != null) {
				currentPerson.setEmail(email);
			}
			personService.savePerson(currentPerson);
			return currentPerson;
		} else {
			return null;
		}
	}
	

}
