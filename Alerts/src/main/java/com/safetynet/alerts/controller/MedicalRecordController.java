package com.safetynet.alerts.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.safetynet.alerts.model.MedicalRecord;
import com.safetynet.alerts.service.MedicalRecordService;

@RestController
public class MedicalRecordController {
	
	@Autowired
	MedicalRecordService medicalRecordService;
	
	 /*
	  * Get all medical records
	  * @return - The list of all medical records
	  */
	@GetMapping("/medicalrecords")
	public List<MedicalRecord> getMedicalRecords() {
		return (List<MedicalRecord>) medicalRecordService.getMedicalRecords();
	}
	
	/*
	 * Delete a meical record
	 * @param - firstname, lastname
	 */
	@DeleteMapping("/medicalrecord")
	public void deleteMedicalRecordn(@RequestParam("firstname") final String firstname,
			@RequestParam("lastname") final String lastname) {
		medicalRecordService.deleteMedicalRecord(firstname, lastname);
	}
	
	/*
	 * Save a new meicalRecord
	 * @param - An object medicalRecord
	 * @return - The meicalRecord object saved
	 */
	@PostMapping("/medicalrecord")
	public MedicalRecord createMedicalRecord(@RequestBody MedicalRecord medicalRecord) {
		return medicalRecordService.saveMedicalRecord(medicalRecord);
	}
	
	/*
	 * Update existing medicalRecord
	 * @param  - id
	 * @param - The medicalRecord with modifications
	 * firstname/lastname can't be modified
	 * @return - The modified medicalRecord
	 */
	@PutMapping("/medicalrecord/{id}")
	public MedicalRecord updateMedicalRecord(@PathVariable("id") final int id, 
			@RequestBody MedicalRecord medicalRecord) {
		Optional<MedicalRecord> mr = medicalRecordService.getMedicalRecord(id);
		if(mr.isPresent()) {
			MedicalRecord currentMedicalRecord = mr.get();
			
			String birthdate = medicalRecord.getBirthdate();
			if(birthdate != null) {
				currentMedicalRecord.setBirthdate(birthdate);
			}
			String medications = medicalRecord.getMedications();
			if(medications != null) {
				currentMedicalRecord.setMedications(medications);
			}
			String allergies = medicalRecord.getAllergies();
			if(allergies != null) {
				currentMedicalRecord.setAllergies(allergies);
			}
			medicalRecordService.saveMedicalRecord(currentMedicalRecord);
			return currentMedicalRecord;
		} else {
			return null;
		}
	}

}
