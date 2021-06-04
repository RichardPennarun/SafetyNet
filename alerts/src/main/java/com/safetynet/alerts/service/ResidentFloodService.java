package com.safetynet.alerts.service;

import java.util.ArrayList;
import java.util.List;
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
import com.safetynet.alerts.repository.ResidentRepository;
import com.safetynet.alerts.repository.DTO.ResidentByStationDTORepository;
import com.safetynet.alerts.util.Util;

import lombok.Data;

@Data
@Service
public class ResidentFloodService {

	private static Logger logger = LogManager.getLogger(ResidentFloodService.class);

	@Autowired
	PersonService personService;

	@Autowired
	FirestationService firestationService;

	@Autowired
	MedicalRecordService medicalRecordService;

	@Autowired
	private ResidentByStationDTORepository residentByStationDTORepository;

	@Autowired
	private ResidentRepository residentRepository;

	Util util;

	private List<Integer> station;

	public List<ResidentByStationDTO> getResidentsByStationNumber(final String stationNumbers) {

		ArrayList<ResidentByStationDTO> residentsByStation = new ArrayList<>();
		Util util = new Util();
		String address = "";

		Scanner scanner = new Scanner(stationNumbers);
		List<Integer> stations = new ArrayList<Integer>();
		while (scanner.hasNextInt()) {
			stations.add(scanner.nextInt());
		}

		for (Integer station : stations) {

			List<Firestation> firestations = firestationService.getFirestations();
			for (Firestation fs : firestations) {
				if (fs.getStationNumber().equals(station)) {
					address = fs.getAddress();
					ArrayList<Resident> residents = new ArrayList<>();
					ResidentByStationDTO residentByStation = new ResidentByStationDTO();

					List<Person> persons = personService.getPersons();
					for (Person p : persons) {
						if (p.getAddress().equals(address)) {
							Resident resident = new Resident();
							resident.setId(p.getId());
							resident.setFirstName(p.getFirstName());
							resident.setLastName(p.getLastName());
							resident.setPhone(p.getPhone());

							List<MedicalRecord> medicalrecords = medicalRecordService.getMedicalRecords();
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
						residentByStation.setResidents(residents);
						residentByStation.setStationNumber(station);
						residentByStation.setAddress(address);
					}

					residentsByStation.add(residentByStation);
				}
			}
		}
		logger.info("Response - Residents list for station number" + stationNumbers + ":  " + residentsByStation);
    	
		return residentsByStation;

	}

}
