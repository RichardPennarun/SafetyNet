package com.safetynet.alerts.service;

import java.util.ArrayList;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynet.alerts.model.Firestation;
import com.safetynet.alerts.model.MedicalRecord;
import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.model.Resident;
import com.safetynet.alerts.model.DTO.ResidentByStationDTO;
import com.safetynet.alerts.util.Util;

@Service
public class ResidentFloodService {

	private static Logger logger = LogManager.getLogger(ResidentFloodService.class);

	@Autowired
	PersonService personService;

	@Autowired
	FirestationService firestationService;

	@Autowired
	MedicalRecordService medicalRecordService;
	
	Scanner scanner;

	public ArrayList<ResidentByStationDTO> getResidentsByStationNumber(final String stationNumbers) {

		ArrayList<ResidentByStationDTO> residentsByStation = new ArrayList<>();
		Util util = new Util();
		String address = "";

		scanner = new Scanner(stationNumbers);
		ArrayList<Integer> stations = new ArrayList<Integer>();
		while (scanner.hasNextInt()) {
			stations.add(scanner.nextInt());
			logger.debug("Get stationNumbers from String");
		}

		for (Integer station : stations) {

			ArrayList<Firestation> firestations = firestationService.getFirestations();
			for (Firestation fs : firestations) {
				if (fs.getStationNumber().equals(station)) {
					address = fs.getAddress();
					logger.debug("Get address from stationNumber");
					ArrayList<Resident> residents = new ArrayList<>();
					ResidentByStationDTO residentByStation = new ResidentByStationDTO();

					ArrayList<Person> persons = personService.getPersons();
					for (Person p : persons) {
						if (p.getAddress().equals(address)) {
							logger.debug("Get infos about resident in model Person");
							Resident resident = new Resident();
							resident.setId(p.getId());
							resident.setFirstName(p.getFirstName());
							resident.setLastName(p.getLastName());
							resident.setPhone(p.getPhone());

							ArrayList<MedicalRecord> medicalrecords = medicalRecordService.getMedicalRecords();
							for (MedicalRecord mr : medicalrecords) {
								if (mr.getFirstName().equals(resident.getFirstName())
										&& mr.getLastName().equals(resident.getLastName())) {
									logger.debug("Get infos about resident in model MedicalRecord");
									resident.setAge(util.getAge(mr.getBirthdate()));
									resident.setMedications(mr.getMedications());
									resident.setAllergies(mr.getAllergies());
								}
							}
							residents.add(resident);
							logger.debug("Add resident to list");
						}
						logger.debug("Create a DTO");
						residentByStation.setResidents(residents);
						residentByStation.setStationNumber(station);
						residentByStation.setAddress(address);
					}
					logger.debug("Add DTO to list");
					residentsByStation.add(residentByStation);
				}
			}
		}
		return residentsByStation;

	}

}
