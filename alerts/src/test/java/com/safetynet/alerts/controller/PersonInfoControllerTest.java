package com.safetynet.alerts.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.safetynet.alerts.model.PersonInfo;
import com.safetynet.alerts.service.PersonInfoService;
import com.safetynet.alerts.util.Util;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class PersonInfoControllerTest {
	
	@Autowired
	private PersonInfoController personInfoController;

	@MockBean
	@Autowired
	private PersonInfoService personInfoService;
	
	private PersonInfo personInfo;
	
	Util util;
	
	@Before
	private void setUp() {
		personInfoController = new PersonInfoController();
		personInfoService = new PersonInfoService();
	}
	
	@Test
	public void getPersonInfoTest() {
		
		personInfo = new PersonInfo();
		personInfo.setId(1);
		personInfo.setFirstName("John");
		personInfo.setLastName("Boyd");
		personInfo.setAddress("1509 Culver St");
		personInfo.setCity("Culver");
		personInfo.setZip("97451");
		personInfo.setEmail("jaboyd@email.com");
		personInfo.setAge(37);
		personInfo.setMedications("aznol:350mg, hydrapermazol:100mg");
		personInfo.setAllergies("nillacilan");
		
		when(personInfoService.getPersonInfo("John", "Boyd")).thenReturn(personInfo);
		
		PersonInfo getPersonInfo = personInfoController.getPersonInfo("John", "Boyd");
		
		assertThat(getPersonInfo).isEqualTo(personInfo);
	}
	
	@Test
	public void getNoPersonInfoTest() {
		
		when(personInfoService.getPersonInfo("John", "Boy")).thenReturn(null);
		
		PersonInfo getPersonInfo = personInfoController.getPersonInfo("John", "Boy");
		
		assertThat(getPersonInfo).isEqualTo(null);
	}
	
}
