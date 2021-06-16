package com.safetynet.alerts.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.safetynet.alerts.model.MedicalRecord;
import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.model.PersonInfo;
import com.safetynet.alerts.repository.PersonInfoRepository;
import com.safetynet.alerts.repository.PersonRepository;
import com.safetynet.alerts.util.Util;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class PersonInfoServiceTest {
	
	@Autowired
	private PersonInfoService personInfoService;
	
	@MockBean
	@Autowired
	private PersonInfo personInfo;
	
	@Before
	private void setUp() {
		personInfoService = new PersonInfoService();
		personInfo = new PersonInfo();
	}

	@Test
	public void getPersonInfoTest() {
		
		personInfo = personInfoService.getPersonInfo("John", "Boyd");

		assertThat(personInfo.getId()).isEqualTo(1);
		assertThat(personInfo.getFirstName()).isEqualTo("John");
		assertThat(personInfo.getLastName()).isEqualTo("Boyd");
		assertThat(personInfo.getAddress()).isEqualTo("1509 Culver St");
		assertThat(personInfo.getCity()).isEqualTo("Culver");
		assertThat(personInfo.getZip()).isEqualTo("97451");
		assertThat(personInfo.getAge()).isEqualTo(37);
		assertThat(personInfo.getEmail()).isEqualTo("jaboyd@email.com");
		assertThat(personInfo.getMedications()).isEqualTo("aznol:350mg, hydrapermazol:100mg");
		assertThat(personInfo.getAllergies()).isEqualTo("nillacilan");

	}

}
