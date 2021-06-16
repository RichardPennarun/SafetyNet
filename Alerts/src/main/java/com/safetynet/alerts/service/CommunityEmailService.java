package com.safetynet.alerts.service;

import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynet.alerts.model.Person;

@Service
public class CommunityEmailService {
	
	private static Logger logger = LogManager.getLogger(CommunityEmailService.class);
	
	@Autowired
	PersonService personService;

	public ArrayList<String> getEmails(final String city) {
		
		ArrayList<String> personEmails = new ArrayList<>();

		logger.debug("Get all persons");
		ArrayList<Person> persons = (ArrayList<Person>) personService.getPersons();
		for (Person person : persons) {
			if(person.getCity().equalsIgnoreCase(city)) {
				personEmails.add(person.getEmail());
				logger.debug("Add " + person.getEmail() + " to list");
			}
		}
    	return personEmails;
	}
	
}
