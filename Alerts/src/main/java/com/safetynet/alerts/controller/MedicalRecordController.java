package com.safetynet.alerts.controller;

import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.safetynet.alerts.model.MedicalRecord;
import com.safetynet.alerts.service.MedicalRecordService;

@RestController
public class MedicalRecordController {
	
	private static Logger logger = LogManager.getLogger(MedicalRecordController.class);
	
	@Autowired
	MedicalRecordService medicalRecordService;
	
	// Get all medicalRecords, returns a list of all medicalRecords
	@GetMapping("/medicalrecords")
	public ArrayList<MedicalRecord> getMedicalRecords() {
        logger.info("Request - Get all medicalRecords");
		 ArrayList<MedicalRecord> medicalRecords = medicalRecordService.getMedicalRecords();
			logger.info("Response - Returns all medicalRecords: " + medicalRecords);
			return medicalRecords;
	}
	
	// Add a medicalRecord, @param an object medicalRecord, @return - The medicalRecord object added
	@PostMapping("/medicalrecord")
	public MedicalRecord createMedicalRecord(@RequestBody MedicalRecord medicalRecord) {
		logger.info("Request - Create medicalRecord @RequestBody = {} ", medicalRecord);
		MedicalRecord createdMedicalRecord = medicalRecordService.saveMedicalRecord(medicalRecord);
		if (createdMedicalRecord == null) {
			logger.error("Wrong entry, missing some arguments:" + medicalRecord);
			return null;
		} else {
			logger.info("Response - medicalRecord saved: " + createdMedicalRecord);
			return createdMedicalRecord;
		}
	}
	
	// Update existing medicalRecord, @param the modified medicalRecord (firstname/lastname can't be modified)
	// @return the updated medicalRecord
	@PutMapping("/medicalrecord")
	public MedicalRecord updateMedicalRecord(@RequestBody MedicalRecord medicalRecord) {
		logger.info("Request - Update medicalRecord @RequestBody = {} ", medicalRecord);
		MedicalRecord updatedMedicalRecord = medicalRecordService.updateMedicalRecord(medicalRecord);
		if(updatedMedicalRecord == null) {
			logger.error("Wrong entry, missing some arguments:" + medicalRecord);
			return null;
		} else {
			logger.info("Response - medicalRecord updated: " + updatedMedicalRecord);
			return updatedMedicalRecord;
		}
	}
	
	// Delete a medicalRecord by combination firstname/lastname, @param firstname/lastname
	@DeleteMapping("/medicalrecord")
	public void deleteMedicalRecord(@RequestParam("firstname") final String firstname,
			@RequestParam("lastname") final String lastname) {
		logger.info("Request - Delete medical record with firstname {}, lastname {}", firstname, lastname);
		medicalRecordService.deleteMedicalRecord(firstname, lastname);
	}

}
