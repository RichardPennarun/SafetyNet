package com.safetynet.alerts.model.DTO;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class ResidentByAddressDTOTest {
	
	
	@Before
	private void setUpPerTest() {
		
	}
	
	@Test
	public void getResidentByAddressDTO() {
		
		ResidentByAddressDTO residentByAddress = new ResidentByAddressDTO();
		residentByAddress.setId(2);
		residentByAddress.setStationNumber(2);
		residentByAddress.setResidents(null);

		assertThat(residentByAddress.getId()).isEqualTo(2);
		assertThat(residentByAddress.getStationNumber()).isEqualTo(2);
		assertThat(residentByAddress.getResidents()).isEqualTo(null);
	}

}
