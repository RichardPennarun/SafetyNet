package com.safetynet.alerts.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class CoveredPersonTest {
	
	
	@Before
	private void setUpPerTest() {
		
	}
	
	@Test
	public void getCoveredPerson() {
		
		CoveredPerson cp = new CoveredPerson();
		cp.setId(2);
		cp.setFirstName("richard");
		cp.setLastName("pennarun");
		cp.setAddress("36 rue des envierges");
		cp.setCity("paris");
		cp.setZip("75020");
		cp.setPhone("0663173165");
		cp.setAge(29);

		assertThat(cp.getId()).isEqualTo(2);
		assertThat(cp.getFirstName()).isEqualTo("richard");
		assertThat(cp.getLastName()).isEqualTo("pennarun");
		assertThat(cp.getAddress()).isEqualTo("36 rue des envierges");
		assertThat(cp.getCity()).isEqualTo("paris");
		assertThat(cp.getZip()).isEqualTo("75020");
		assertThat(cp.getPhone()).isEqualTo("0663173165");
		assertThat(cp.getAge()).isEqualTo(29);
	}

}
