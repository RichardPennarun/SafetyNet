package com.safetynet.alerts.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynet.alerts.model.MedicalRecord;
import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.model.PersonInfo;
import com.safetynet.alerts.repository.PersonInfoRepository;
import com.safetynet.alerts.util.Util;

@Service
public class PersonInfoService {
	
	private static Logger logger = LogManager.getLogger(PersonInfoService.class);
	
	@Autowired
	PersonService personService;
	
	@Autowired
	MedicalRecordService medicalRecordService;
	
	Util util;
	
	public PersonInfo getPersonInfo(final String firstname, final String lastname) {
		
		PersonInfo personInfo = new PersonInfo();
		Util util = new Util();
		
		ArrayList<Person> persons = personService.getPersons();
		logger.debug("Get all persons");
		for (Person p : persons) {
			if(p.getFirstName().equals(firstname) && p.getLastName().equals(lastname)) {
				personInfo.setId(p.getId());
				personInfo.setFirstName(p.getFirstName());
				personInfo.setLastName(p.getLastName());
				personInfo.setAddress(p.getAddress());
				personInfo.setCity(p.getCity());
				personInfo.setZip(p.getZip());
				personInfo.setEmail(p.getEmail());
			}
		}
		
		ArrayList<MedicalRecord> medicalRecords = medicalRecordService.getMedicalRecords();
		logger.debug("Get all medicalRecords");
		for (MedicalRecord mr : medicalRecords) {
			if(mr.getFirstName().equals(firstname) && mr.getLastName().equals(lastname)) {
				personInfo.setAge(util.getAge(mr.getBirthdate()));
				personInfo.setMedications(mr.getMedications());
				personInfo.setAllergies(mr.getAllergies());
			}
		}
    	return personInfo;
	}

}
