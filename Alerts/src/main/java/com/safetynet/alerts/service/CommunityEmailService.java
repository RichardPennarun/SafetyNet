package com.safetynet.alerts.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynet.alerts.model.Person;

import lombok.Data;

@Data
@Service
public class CommunityEmailService {
	
	@Autowired
	PersonService personService;

	public List<String> getEmails(final String givenCity) {
		
		List<String> personEmails = new ArrayList<>();
		
		List<Person> persons = personService.getPersons();
		for (Person person : persons) {
			if(person.getCity().equals(givenCity)) {
				personEmails.add(person.getEmail());
			}
		}
		
		return personEmails;
	}
	
	

}
