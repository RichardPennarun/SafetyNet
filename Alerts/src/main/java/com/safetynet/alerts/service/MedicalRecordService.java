package com.safetynet.alerts.service;

import java.util.ArrayList;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynet.alerts.model.MedicalRecord;
import com.safetynet.alerts.repository.MedicalRecordRepository;

@Service
public class MedicalRecordService {

	private static Logger logger = LogManager.getLogger(MedicalRecordService.class);

	@Autowired
	private MedicalRecordRepository medicalRecordRepository;

	// GET a mr by id
	public Optional<MedicalRecord> getMedicalRecord(final int id) {
		logger.debug("Get a medicalRecord by its id : " + id);
		return medicalRecordRepository.findById(id);
	}

	// GET all mr
	public ArrayList<MedicalRecord> getMedicalRecords() {
		ArrayList<MedicalRecord> medicalRecords = (ArrayList<MedicalRecord>) medicalRecordRepository.findAll();
		logger.debug("medicalRecordRepository.findAll()");
		return medicalRecords;
	}

	// POST a mr
	public MedicalRecord saveMedicalRecord(MedicalRecord medicalRecord) {
		MedicalRecord savedMedicalRecord = medicalRecordRepository.save(medicalRecord);
		logger.debug("Save medicalRecord : " + medicalRecord);
		return savedMedicalRecord;
	}

	// PUT a mr
	public MedicalRecord updateMedicalRecord(MedicalRecord medicalRecord) {
		int id = 0;
		ArrayList<MedicalRecord> medicalRecords = getMedicalRecords();
		for (MedicalRecord mr : medicalRecords) {
			if (mr.getFirstName().equals(medicalRecord.getFirstName())
					&& mr.getLastName().equals(medicalRecord.getLastName())) {
				id = mr.getId();
				logger.debug("Find the medicalRecord to update");
			}
		}
		Optional<MedicalRecord> medicalRecordToUpdate = getMedicalRecord(id);
		if (medicalRecordToUpdate.isPresent()) {
			MedicalRecord modifiedMedicalRecord = medicalRecordToUpdate.get();
			// firstName and lastName non modifiable
			String birthdate = medicalRecord.getBirthdate();
			if (birthdate != null) {
				modifiedMedicalRecord.setBirthdate(birthdate);
			}
			String medications = medicalRecord.getMedications();
			if (medications != null) {
				modifiedMedicalRecord.setMedications(medications);
			}
			String allergies = medicalRecord.getAllergies();
			if (allergies != null) {
				modifiedMedicalRecord.setAllergies(allergies);
			}
			saveMedicalRecord(modifiedMedicalRecord);
			logger.debug("Save the updated medicalRecord");
			return modifiedMedicalRecord;
		} else {
			return null;
		}
	}

	// DELETE a mr by firstname/lastname
	public void deleteMedicalRecord(final String firstname, final String lastname) {
		int id = 0;
		ArrayList<MedicalRecord> medicalRecords = getMedicalRecords();
		for (MedicalRecord medicalRecord : medicalRecords) {
			if (medicalRecord.getFirstName().equals(firstname) && medicalRecord.getLastName().equals(lastname)) {
				id = medicalRecord.getId();
			}
		}
		if (id != 0) {
			logger.info("Response - Medical record for " + firstname + " " + lastname + " deleted");
			medicalRecordRepository.deleteById(id);
		} else {
			logger.error("Wrong entry: " + firstname + " " + lastname + " not in database");
		}
	}

}