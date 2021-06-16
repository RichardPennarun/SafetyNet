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

import com.safetynet.alerts.model.Firestation;
import com.safetynet.alerts.service.FirestationService;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class FirestationControllerTest {
	
	@Autowired
	private FirestationController firestationController;
	
	@MockBean
	@Autowired
	private FirestationService firestationService;
	
	@Before
	private void setUp() {
		firestationService = new FirestationService();
		firestationController = new FirestationController ();
	}

	@Test
	public void getFirestationnsTest() {
		ArrayList<Firestation> firestationsList = new ArrayList<>();
		ArrayList<Firestation> firestations = firestationService.getFirestations();
		when(firestationService.getFirestations()).thenReturn(firestations);
		firestationsList = (ArrayList<Firestation>) firestationController.getFirestations();
		assertThat(firestations).isEqualTo(firestationsList);
	}

	@Test
	public void createFirestationTest() {
		Firestation firestation = new Firestation();
		firestation.setAddress("36 rue des Envierges");
		firestation.setStationNumber(4);
		when(firestationService.saveFirestation(firestation)).thenReturn(firestation);
		Firestation createdFirestation = firestationController.createFirestation(firestation);
		assertThat(createdFirestation).isEqualTo(firestation);
	}

	@Test
	public void createNoFirestationTest() {
		Firestation firestation = new Firestation();
		firestation.setAddress(null);
		firestation.setStationNumber(4);
		when(firestationService.saveFirestation(firestation)).thenReturn(null);
		Firestation createdFirestation = firestationController.createFirestation(firestation);
		assertThat(createdFirestation).isEqualTo(null);
	}

	@Test
	public void updateFirestationTest() {
		Firestation firestation = new Firestation();
		firestation.setAddress("36 rue des Envierges");
		firestation.setStationNumber(4);
		when(firestationService.updateFirestation(firestation)).thenReturn(firestation);
		Firestation updatedFirestation = firestationController.updateFirestation(firestation);
		assertThat(updatedFirestation).isEqualTo(firestation);
	}

	@Test
	public void updateNoFirestationTest() {
		Firestation firestation = new Firestation();
		firestation.setAddress(null);
		firestation.setStationNumber(4);
		when(firestationService.updateFirestation(firestation)).thenReturn(null);
		Firestation updatedFirestation = firestationController.updateFirestation(firestation);
		assertThat(updatedFirestation).isEqualTo(null);
	}


	@Test
	public void deleteMappingWithAddressTest() {
		firestationController.deleteMappingWithAddress("112 Steppes Pl");
	}


	@Test
	public void deleteMappingsWithStationNumberTest() {
		firestationController.deleteMappingsWithStationNumber(3);
	}
	
	
}
