package com.safetynet.alerts.service;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.Optional;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.safetynet.alerts.model.MedicalRecord;

@SpringBootTest
public class MedicalRecordServiceTest {
	
	@Autowired
	private MedicalRecordService medicalRecordService;
	
	@Before
	private void setUp() {
		medicalRecordService = new MedicalRecordService();
	}

	@Test
	public void getMedicalRecordsTest() {
		ArrayList<MedicalRecord> medicalRecordsList = new ArrayList<>();
		ArrayList<MedicalRecord> medicalRecords = medicalRecordService.getMedicalRecords();
		medicalRecordsList = (ArrayList<MedicalRecord>) medicalRecordService.getMedicalRecords();
		assertThat(medicalRecords).isEqualTo(medicalRecordsList);
	}

	@Test
	public void getMedicalRecordTest() {
		Optional<MedicalRecord> medicalRecord = Optional.of(new MedicalRecord());
		medicalRecord = medicalRecordService.getMedicalRecord(2);
		Optional<MedicalRecord> mr = medicalRecordService.getMedicalRecord(2);
		assertThat(mr).isEqualTo(medicalRecord);
	}

	@Test
	public void saveMedicalRecordTest() {
		MedicalRecord medicalRecordToSave = new MedicalRecord();
		medicalRecordToSave.setFirstName("richard");
		medicalRecordToSave.setLastName("pennarun");
		medicalRecordToSave.setBirthdate("02/06/1972");
		medicalRecordToSave.setMedications("Doliprane 1000");
		medicalRecordToSave.setAllergies("Courgettes");
		MedicalRecord createdMedicalRecord = medicalRecordService.saveMedicalRecord(medicalRecordToSave);
		assertThat(createdMedicalRecord).isEqualTo(medicalRecordToSave);
	}

	@Test
	public void updateMedicalRecordTest() {
		MedicalRecord medicalRecordToUpdate = new MedicalRecord();
		medicalRecordToUpdate.setId(2);
		medicalRecordToUpdate.setFirstName("Jacob");
		medicalRecordToUpdate.setLastName("Boyd");
		medicalRecordToUpdate.setBirthdate("03/06/1989");
		medicalRecordToUpdate.setMedications("pharmacol:5000mg, terazine:10mg, noznazol:250mg");
		medicalRecordToUpdate.setAllergies("chien");
		
		MedicalRecord medicalRecordToUpdate2 = new MedicalRecord();
		medicalRecordToUpdate2.setId(2);
		medicalRecordToUpdate2.setFirstName("Jaco");
		medicalRecordToUpdate2.setLastName("Boyd");
		medicalRecordToUpdate2.setBirthdate("03/06/1989");
		medicalRecordToUpdate2.setMedications("pharmacol:5000mg, terazine:10mg, noznazol:250mg");
		medicalRecordToUpdate2.setAllergies("chien");

		MedicalRecord updatedMedicalRecord = medicalRecordService.updateMedicalRecord(medicalRecordToUpdate);

		MedicalRecord updatedMedicalRecord2 = medicalRecordService.updateMedicalRecord(medicalRecordToUpdate2);
		
		assertThat(updatedMedicalRecord).isEqualTo(medicalRecordToUpdate);
		
		assertThat(updatedMedicalRecord2).isEqualTo(null);
	}


	@Test
	public void deleteMedicalRecordTest() {
		medicalRecordService.deleteMedicalRecord("John","Boyd");
		Optional<MedicalRecord> mr = medicalRecordService.getMedicalRecord(1);
		assertThat(mr).isEmpty();
	}


	@Test
	public void deleteNoMedicalRecordTest() {
		medicalRecordService.deleteMedicalRecord("John","Boy");
		Optional<MedicalRecord> mr2 = medicalRecordService.getMedicalRecord(1);
		assertThat(mr2).isNotEmpty();
	}
	
	
}
