package com.safetynet.alerts.service;

import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynet.alerts.model.Firestation;
import com.safetynet.alerts.model.Person;

@Service
public class PhoneAlertService {

	private static Logger logger = LogManager.getLogger(PhoneAlertService.class);

	@Autowired
	PersonService personService;

	@Autowired
	FirestationService firestationService;

	public ArrayList<String> getPhones(final int stationNumber) {

		ArrayList<String> personPhones = new ArrayList<>();
		ArrayList<String> addressList = new ArrayList<>();

		ArrayList<Firestation> firestations = firestationService.getFirestations();
		for (Firestation firestation : firestations) {
			if (firestation.getStationNumber().equals(stationNumber)) {
				logger.debug("Get addresses for station number " + stationNumber);
				addressList.add(firestation.getAddress());
			}
		}

		ArrayList<Person> persons = personService.getPersons();
		for (String address : addressList) {
			for (Person person : persons) {
				if (person.getAddress().equals(address)) {
					personPhones.add(person.getPhone());
					logger.debug("Add " + person.getPhone() + " to list");
				}
			}
		}
		return personPhones;
	}

}
