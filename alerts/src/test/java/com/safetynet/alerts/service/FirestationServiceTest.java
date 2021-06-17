package com.safetynet.alerts.service;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.Optional;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.safetynet.alerts.model.Firestation;

@SpringBootTest
public class FirestationServiceTest {

	@Autowired
	private FirestationService firestationService;
	
	@Before
	private void setUp() {
		firestationService = new FirestationService();
	}

	@Test
	public void getFirestationServicesTest() {
		ArrayList<Firestation> firestationsList = new ArrayList<>();
		ArrayList<Firestation> firestations = firestationService.getFirestations();
		firestationsList = (ArrayList<Firestation>) firestationService.getFirestations();
		assertThat(firestations).isEqualTo(firestationsList);
	}

	@Test
	public void getFirestationTest() {
		Optional<Firestation> firestation = Optional.of(new Firestation());
		firestation = firestationService.getFirestation(2);
		Optional<Firestation> fs = firestationService.getFirestation(2);
		assertThat(fs).isEqualTo(firestation);
	}


	@Test
	public void saveFirestationTest() {
		Firestation firestationToSave = new Firestation();
		firestationToSave.setAddress("36 rue des Envierges");
		firestationToSave.setStationNumber(4);
		Firestation createdFirestation = firestationService.saveFirestation(firestationToSave);
		assertThat(createdFirestation).isEqualTo(firestationToSave);
	}

	@Test
	public void updateFirestationTest() {
		Firestation firestationToUpdate = new Firestation();
		firestationToUpdate.setId(1);
		firestationToUpdate.setAddress("36 rue des Envierges");
		firestationToUpdate.setStationNumber(4);

		Firestation firestationToUpdate2 = new Firestation();
		firestationToUpdate2.setId(1);
		firestationToUpdate2.setAddress("150 Culver St");
		firestationToUpdate2.setStationNumber(4);
		
		Firestation updatedFirestation = firestationService.updateFirestation(firestationToUpdate);

		
		Firestation updatedFirestation2 = firestationService.updateFirestation(firestationToUpdate2);
		
		assertThat(updatedFirestation.getAddress()).isEqualTo(firestationToUpdate.getAddress());
		assertThat(updatedFirestation2).isEqualTo(null);
	}


	@Test
	public void deleteFirestationByAddressTest() {
		firestationService.deleteFirestationByAddress("112 Steppes Pl");
	}


	@Test
	public void deleteFirestationByStationNumberTest() {
		firestationService.deleteFirestationByStationNumber(3);
	}
	
	
}
