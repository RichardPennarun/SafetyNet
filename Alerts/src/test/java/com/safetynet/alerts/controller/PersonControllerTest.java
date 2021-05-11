package com.safetynet.alerts.controller;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.repository.PersonRepository;
import com.safetynet.alerts.service.PersonService;

public class PersonControllerTest {

	PersonController personController;
	
	@Mock
	PersonRepository personRepository;
	
	@Mock
	PersonService personService;
	
	@Disabled
	@Test
	public void deletePerson() {
		Person p = new Person();
		//when(personService.deletePerson(0)).thenReturn(1);
		new PersonController().deletePerson(p.getId());
		//parkingService.processIncomingVehicle();
		//personController.deletePerson(id);
		//verify(personRepository, Mockito.times(1)).deleteById(p.getId());
		
	}	
	
}
