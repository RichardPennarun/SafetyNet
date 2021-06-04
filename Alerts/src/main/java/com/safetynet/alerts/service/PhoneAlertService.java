package com.safetynet.alerts.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynet.alerts.model.Firestation;
import com.safetynet.alerts.model.Person;

import lombok.Data;

@Data
@Service
public class PhoneAlertService {
	
	private static Logger logger = LogManager.getLogger(PhoneAlertService.class);
	
	@Autowired
	PersonService personService;
	
	@Autowired
	FirestationService firestationService;
	
	public List<String> getPhones(final int stationNumber) {
		
		List<String> personPhones = new ArrayList<>();
		
		List<String>addressList = new ArrayList<>();
		
		List<Firestation> firestations = firestationService.getFirestations();
		for (Firestation firestation : firestations) {
			if(firestation.getStationNumber().equals(stationNumber)) {
				addressList.add(firestation.getAddress());
			}
		}
		
		List<Person> persons = personService.getPersons();
		for (String address : addressList) {
			for (Person person : persons) {
				if(person.getAddress().equals(address)) {
					personPhones.add(person.getPhone());
				}
			}
		}
		logger.info("Response - Phone list for station number " + stationNumber + ":  " + personPhones);
    	
		return personPhones;
	}
	
	

}
