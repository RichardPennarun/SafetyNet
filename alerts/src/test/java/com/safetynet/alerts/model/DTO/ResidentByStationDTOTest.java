package com.safetynet.alerts.model.DTO;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class ResidentByStationDTOTest {
	
	
	@Before
	private void setUpPerTest() {
		
	}
	
	@Test
	public void getResidentByStationDTO() {
		
		ResidentByStationDTO residentByStation = new ResidentByStationDTO();
		residentByStation.setId(2);
		residentByStation.setStationNumber(2);
		residentByStation.setAddress("36 rue des envierges");
		residentByStation.setResidents(null);

		assertThat(residentByStation.getId()).isEqualTo(2);
		assertThat(residentByStation.getStationNumber()).isEqualTo(2);
		assertThat(residentByStation.getAddress()).isEqualTo("36 rue des envierges");
		assertThat(residentByStation.getResidents()).isEqualTo(null);
	}

}
