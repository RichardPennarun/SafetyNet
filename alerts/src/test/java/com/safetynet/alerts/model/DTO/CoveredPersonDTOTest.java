package com.safetynet.alerts.model.DTO;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class CoveredPersonDTOTest {
	
	
	@Before
	private void setUpPerTest() {
		
	}
	
	@Test
	public void getCoveredPerson() {
		
		CoveredPersonDTO cp = new CoveredPersonDTO();
		cp.setId(2);
		cp.setStationNumber(2);
		cp.setAdults(2);
		cp.setChildren(11);
		cp.setCoveredPersons(null);

		assertThat(cp.getId()).isEqualTo(2);
		assertThat(cp.getStationNumber()).isEqualTo(2);
		assertThat(cp.getAdults()).isEqualTo(2);
		assertThat(cp.getChildren()).isEqualTo(11);
		assertThat(cp.getCoveredPersons()).isEqualTo(null);
	}

}
