package com.safetynet.alerts.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynet.alerts.model.Person;

import lombok.Data;

@Data
@Service
public class CommunityEmailService {
	
	private static Logger logger = LogManager.getLogger(CommunityEmailService.class);
	
	@Autowired
	PersonService personService;

	public List<String> getEmails(final String city) {
		
		List<String> personEmails = new ArrayList<>();
		
		List<Person> persons = personService.getPersons();
		for (Person person : persons) {
			if(person.getCity().equalsIgnoreCase(city)) {
				personEmails.add(person.getEmail());
			}
		}
		logger.debug("Returns email list for " + city + ":  " + personEmails);
    	return personEmails;
	}
	
}
