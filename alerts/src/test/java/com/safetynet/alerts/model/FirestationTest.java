package com.safetynet.alerts.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class FirestationTest {
	
	
	@Before
	private void setUpPerTest() {
		
	}
	
	@Test
	public void getFirestation() {
		
		Firestation fs = new Firestation();
		fs.setId(5);
		fs.setAddress("36 rue des envierges");
		fs.setStationNumber(4);

		assertThat(fs.getId()).isEqualTo(5);
		assertThat(fs.getAddress()).isEqualTo("36 rue des envierges");
		assertThat(fs.getStationNumber()).isEqualTo(4);
	}

}
