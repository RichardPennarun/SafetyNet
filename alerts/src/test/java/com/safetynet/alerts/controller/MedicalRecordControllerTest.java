package com.safetynet.alerts.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.safetynet.alerts.model.MedicalRecord;
import com.safetynet.alerts.service.MedicalRecordService;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class MedicalRecordControllerTest {
	
	@Autowired
	private MedicalRecordController medicalRecordController;
	
	@MockBean
	@Autowired
	private MedicalRecordService medicalRecordService;
	
	@Before
	private void setUp() {
		medicalRecordService = new MedicalRecordService();
		medicalRecordController = new MedicalRecordController ();
	}

	@Test
	public void getMedicalRecordsTest() {
		ArrayList<MedicalRecord> medicalRecordsList = new ArrayList<>();
		ArrayList<MedicalRecord> medicalRecords = medicalRecordService.getMedicalRecords();
		when(medicalRecordService.getMedicalRecords()).thenReturn(medicalRecords);
		medicalRecordsList = (ArrayList<MedicalRecord>) medicalRecordController.getMedicalRecords();
		assertThat(medicalRecords).isEqualTo(medicalRecordsList);
	}

	@Test
	public void createMedicalRecordTest() {
		MedicalRecord medicalRecord = new MedicalRecord();
		medicalRecord.setFirstName("richard");
		medicalRecord.setLastName("pennarun");
		medicalRecord.setBirthdate("02/06/1972");
		medicalRecord.setMedications("Doliprane 500");
		medicalRecord.setAllergies("Brocoli");
		when(medicalRecordService.saveMedicalRecord(medicalRecord)).thenReturn(medicalRecord);
		MedicalRecord createdMedicalRecord = medicalRecordController.createMedicalRecord(medicalRecord);
		assertThat(createdMedicalRecord).isEqualTo(medicalRecord);
	}

	@Test
	public void createNoMedicalRecordTest() {
		MedicalRecord medicalRecord = new MedicalRecord();
		medicalRecord.setFirstName("richard");
		medicalRecord.setLastName(null);
		medicalRecord.setBirthdate("02/06/1972");
		medicalRecord.setMedications("Doliprane 500");
		medicalRecord.setAllergies("Brocoli");
		when(medicalRecordService.saveMedicalRecord(medicalRecord)).thenReturn(null);
		MedicalRecord createdMedicalRecord = medicalRecordController.createMedicalRecord(medicalRecord);
		assertThat(createdMedicalRecord).isEqualTo(null);
	}

	@Test
	public void updateMedicalRecordTest() {
		MedicalRecord medicalRecord = new MedicalRecord();
		medicalRecord.setFirstName("richard");
		medicalRecord.setLastName("pennarun");
		medicalRecord.setBirthdate("02/06/1972");
		medicalRecord.setMedications("Doliprane 500");
		medicalRecord.setAllergies("Brocoli");
		when(medicalRecordService.updateMedicalRecord(medicalRecord)).thenReturn(medicalRecord);
		MedicalRecord updatedMedicalRecord = medicalRecordController.updateMedicalRecord(medicalRecord);
		assertThat(updatedMedicalRecord).isEqualTo(medicalRecord);
	}

	@Test
	public void updateNoMedicalRecordTest() {
		MedicalRecord medicalRecord = new MedicalRecord();
		medicalRecord.setFirstName("richard");
		medicalRecord.setLastName(null);
		medicalRecord.setBirthdate("02/06/1972");
		medicalRecord.setMedications("Doliprane 500");
		medicalRecord.setAllergies("Brocoli");
		when(medicalRecordService.updateMedicalRecord(medicalRecord)).thenReturn(null);
		MedicalRecord updatedMedicalRecord = medicalRecordController.updateMedicalRecord(medicalRecord);
		assertThat(updatedMedicalRecord).isEqualTo(null);
	}


	@Test
	public void deleteMedicalRecordTest() {
		medicalRecordController.deleteMedicalRecord("John","Boyd");
	}
	
	
}
