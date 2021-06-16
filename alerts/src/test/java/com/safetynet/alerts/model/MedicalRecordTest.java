package com.safetynet.alerts.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class MedicalRecordTest {
	
	
	@Before
	private void setUpPerTest() {
		
	}
	
	@Test
	public void getMedicalRecord() {
		
		MedicalRecord mr = new MedicalRecord();
		mr.setId(2);
		mr.setFirstName("richard");
		mr.setLastName("pennarun");
		mr.setBirthdate("02/06/1972");
		mr.setMedications("Doliprane");
		mr.setAllergies(null);

		assertThat(mr.getId()).isEqualTo(2);
		assertThat(mr.getFirstName()).isEqualTo("richard");
		assertThat(mr.getLastName()).isEqualTo("pennarun");
		assertThat(mr.getBirthdate()).isEqualTo("02/06/1972");
		assertThat(mr.getMedications()).isEqualTo("Doliprane");
		assertThat(mr.getAllergies()).isEqualTo(null);
	}

}
