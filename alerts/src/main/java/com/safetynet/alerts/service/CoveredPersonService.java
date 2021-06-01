package com.safetynet.alerts.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynet.alerts.model.CoveredPerson;
import com.safetynet.alerts.model.Firestation;
import com.safetynet.alerts.model.MedicalRecord;
import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.model.DTO.CoveredPersonDTO;
import com.safetynet.alerts.repository.CoveredPersonRepository;
import com.safetynet.alerts.repository.DTO.CoveredPersonDTORepository;
import com.safetynet.alerts.util.Util;

import lombok.Data;

@Data
@Service
public class CoveredPersonService {

	@Autowired
	PersonService personService;

	@Autowired
	FirestationService firestationService;

	@Autowired
	MedicalRecordService medicalRecordService;

	@Autowired
	private CoveredPersonDTORepository coveredPersonDTORepository;

	@Autowired
	private CoveredPersonRepository coveredPersonRepository;

	Util util;

	public CoveredPersonDTO getCoveredPersons(final int stationNumber) {

		CoveredPersonDTO coveredPersonDTO = new CoveredPersonDTO();
		int adultcount = 0;
		int childcount = 0;
		String address = "";
		Util util = new Util();

		List<Firestation> firestations = firestationService.getFirestations();
		ArrayList<CoveredPerson> coveredPersons = new ArrayList<>();
		for (Firestation fs : firestations) {
			if (fs.getStation().equals(stationNumber)) {
				address = fs.getAddress();

				List<Person> persons = personService.getPersons();
				for (Person p : persons) {
					CoveredPerson coveredPerson = new CoveredPerson();
					if (p.getAddress().equals(address)) {
						coveredPerson.setId(p.getId());
						coveredPerson.setFirstName(p.getFirstName());
						coveredPerson.setLastName(p.getLastName());
						coveredPerson.setAddress(p.getAddress());
						coveredPerson.setPhone(p.getPhone());

						List<MedicalRecord> medicalrecords = medicalRecordService.getMedicalRecords();
						for (MedicalRecord mr : medicalrecords) {
							if (mr.getFirstName().equals(coveredPerson.getFirstName())
									&& mr.getLastName().equals(coveredPerson.getLastName())) {
								coveredPerson.setAge(util.getAge(mr.getBirthdate()));

								if (util.getAge(mr.getBirthdate()) > 18) {
									adultcount++;
								} else {
									childcount++;
								}
							}
						}
						coveredPersons.add(coveredPerson);
					}
				}

			}

			coveredPersonDTO.setStation(stationNumber);
			coveredPersonDTO.setCoveredPersons(coveredPersons);
			coveredPersonDTO.setAdults(adultcount);
			coveredPersonDTO.setChilds(childcount);
		}
		return coveredPersonDTO;
	}

}
