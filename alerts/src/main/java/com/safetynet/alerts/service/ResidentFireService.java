package com.safetynet.alerts.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynet.alerts.model.Firestation;
import com.safetynet.alerts.model.MedicalRecord;
import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.model.Resident;
import com.safetynet.alerts.model.DTO.ResidentByAddressDTO;
import com.safetynet.alerts.repository.ResidentRepository;
import com.safetynet.alerts.repository.DTO.ResidentByAddressDTORepository;
import com.safetynet.alerts.util.Util;

@Service
public class ResidentFireService {
	
	private static Logger logger = LogManager.getLogger(ResidentFireService.class);

	@Autowired
	PersonService personService;

	@Autowired
	FirestationService firestationService;

	@Autowired
	MedicalRecordService medicalRecordService;

	public ResidentByAddressDTO getResidentByAdress(final String address) {

		ResidentByAddressDTO residentByAddress = new ResidentByAddressDTO();
		ArrayList<Resident> residents = new ArrayList<>();
		Util util = new Util();

		ArrayList<Person> persons = personService.getPersons();
		for (Person p : persons) {
			if (p.getAddress().equals(address)) {
				Resident resident = new Resident();
				int id = p.getId();
				resident.setId(id);
				resident.setFirstName(p.getFirstName());
				resident.setLastName(p.getLastName());
				resident.setPhone(p.getPhone());

				ArrayList<MedicalRecord> medicalrecords = medicalRecordService.getMedicalRecords();
				for (MedicalRecord mr : medicalrecords) {
					if (mr.getFirstName().equals(resident.getFirstName())
							&& mr.getLastName().equals(resident.getLastName())) {
						resident.setAge(util.getAge(mr.getBirthdate()));
						resident.setMedications(mr.getMedications());
						resident.setAllergies(mr.getAllergies());
					}
				}
				residents.add(resident);
			}
		}
		residentByAddress.setResidents(residents);

		ArrayList<Firestation> firestations = firestationService.getFirestations();
		for (Firestation fs : firestations) {
			if (fs.getAddress().equals(address)) {
				residentByAddress.setStationNumber(fs.getStationNumber());
			}
		}
		return residentByAddress;
	}

}
