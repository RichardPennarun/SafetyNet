package com.safetynet.alerts.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.repository.PersonRepository;

import lombok.Data;

@Data
@Service
public class PersonService {
	
	@Autowired
	private PersonRepository personRepository;
	
	public Optional<Person> getPerson(final int id) {
		return personRepository.findById(id);
	}
	
	public Iterable<Person> getPersons() {
		return personRepository.findAll();
	}
	
	public Person savePerson(Person person) {
		Person savePerson = personRepository.save(person);
		return savePerson;
	}
	
	public void deletePerson(final int id) {
		personRepository.deleteById(id);
	}
}