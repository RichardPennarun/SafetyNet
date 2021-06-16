package com.safetynet.alerts.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Before;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.safetynet.alerts.controller.ChildController;
import com.safetynet.alerts.controller.CoveredPersonController;
import com.safetynet.alerts.model.Child;
import com.safetynet.alerts.model.CoveredPerson;
import com.safetynet.alerts.model.Firestation;
import com.safetynet.alerts.model.MedicalRecord;
import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.model.PersonInfo;
import com.safetynet.alerts.model.Resident;
import com.safetynet.alerts.model.DTO.CoveredPersonDTO;
import com.safetynet.alerts.model.DTO.ResidentByAddressDTO;
import com.safetynet.alerts.model.DTO.ResidentByStationDTO;
import com.safetynet.alerts.repository.PersonInfoRepository;
import com.safetynet.alerts.repository.PersonRepository;
import com.safetynet.alerts.util.Util;

@SpringBootTest
public class ChildServiceTest {

	@Autowired
	private ChildService childService;

	@Autowired
	private PersonService personService;

	@Autowired
	private PersonInfoService personInfoService;

	@Before
	private void setUp() {
		childService = new ChildService();
		personService = new PersonService();
		personInfoService = new PersonInfoService();
	}

	@Test
	public void getChildrenTest() {
		ArrayList<Child> children = new ArrayList<>();
		
		ArrayList<PersonInfo> personInfos = new ArrayList<PersonInfo>();
		ArrayList<Person> persons = personService.getPersons();
		for (Person p : persons) {
			personInfos.add(personInfoService.getPersonInfo(p.getFirstName(), p.getLastName()));
		}
		for (PersonInfo personInfo : personInfos) {
			if (personInfo.getAddress().equals("1509 Culver St")) {
				if(personInfo.getAge() <= 18) {
					ArrayList<String> coresidents = new ArrayList<String>();
					Child child = new Child();
					child.setId(personInfo.getId());
					child.setFirstName(personInfo.getFirstName());
					child.setLastName(personInfo.getLastName());
					child.setAge(personInfo.getAge());
					for (PersonInfo personInfo2 : personInfos) {
						if (!child.getFirstName().equals(personInfo2.getFirstName()) 
								&& child.getLastName().equals(personInfo2.getLastName())
								&& personInfo2.getAddress().equals("1509 Culver St")) {
							coresidents.add("" + personInfo2.getFirstName() + " " + personInfo2.getLastName() 
									+ ", " + personInfo2.getAge() + "");
						}
					}
					child.setCoresidents(coresidents);
					children.add(child);
				}
			}
		}

		ArrayList<Child> getChildren = childService.getChildren("1509 Culver St");
		
		assertThat(getChildren).isEqualTo(children);
	}



}
