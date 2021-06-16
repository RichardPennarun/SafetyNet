package com.safetynet.alerts.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class ResidentTest {
	
	
	@Before
	private void setUpPerTest() {
		
	}
	
	@Test
	public void getResident() {
		
		Resident resident = new Resident();
		resident.setId(3);
		resident.setFirstName("richard");
		resident.setLastName("pennarun");
		resident.setPhone("0663173165");
		resident.setAge(24);
		resident.setMedications("Doliprane");
		resident.setAllergies(null);

		assertThat(resident.getId()).isEqualTo(3);
		assertThat(resident.getFirstName()).isEqualTo("richard");
		assertThat(resident.getLastName()).isEqualTo("pennarun");
		assertThat(resident.getPhone()).isEqualTo("0663173165");
		assertThat(resident.getAge()).isEqualTo(24);
		assertThat(resident.getMedications()).isEqualTo("Doliprane");
		assertThat(resident.getAllergies()).isEqualTo(null);
	}

}
