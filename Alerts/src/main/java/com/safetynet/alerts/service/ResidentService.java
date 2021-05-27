package com.safetynet.alerts.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.safetynet.alerts.model.CoveredResident;
import com.safetynet.alerts.model.Firestation;
import com.safetynet.alerts.model.MedicalRecord;
import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.model.Resident;
import com.safetynet.alerts.repository.CoveredResidentRepository;
import com.safetynet.alerts.repository.ResidentRepository;
import com.safetynet.alerts.util.Util;

import lombok.Data;

@Data
@Service
public class ResidentService {
	
	@Autowired
	PersonService personService;
	
	@Autowired
	FirestationService firestationService;
	
	@Autowired
	MedicalRecordService medicalRecordService;
	
	@Autowired
	private CoveredResidentRepository coveredResidentRepository;
	
	@Autowired
	private ResidentRepository residentRepository;

	Util util;
	
	public CoveredResident getCoveredResidents(final String address) {
				
		CoveredResident coveredResident = new CoveredResident(); 
		
		int id=0;
		String firstname = null;
		String lastname = null;
		List<Resident> residents = null;
		Util util = new Util();
		
		List<Person> persons = personService.getPersons();
		residents = new ArrayList<>();
		for (Person p : persons) {
			if (p.getAddress().equals(address)) {
				Resident resident = new Resident();
				id = p.getId();
				firstname = p.getFirstName();
				lastname = p.getLastName();
				resident.setId(id);
				resident.setFirstName(firstname);
				resident.setLastName(lastname);
				resident.setPhone(p.getPhone());
				
				List<MedicalRecord> medicalrecords = medicalRecordService.getMedicalRecords();
				for (MedicalRecord mr : medicalrecords) {
					if (mr.getFirstName().equals(firstname) && mr.getLastName().equals(lastname)) {
						resident.setId(id);
						resident.setAge(util.getAge(mr.getBirthdate()));
						resident.setMedications(mr.getMedications());
						resident.setAllergies(mr.getAllergies());
					}
				residents.add(resident);
				}
			}
		}

		//coveredResident.setResidents(residents);
		
		List<Firestation> firestations = firestationService.getFirestations();
		for (Firestation fs : firestations) {
			if (fs.getAddress().equals(address)) {
				coveredResident.setStation(fs.getStation());
			}
		}
		
		return coveredResident;
	}

}
