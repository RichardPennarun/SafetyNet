package com.safetynet.alerts.controller;

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

import com.safetynet.alerts.model.Child;
import com.safetynet.alerts.model.CoveredPerson;
import com.safetynet.alerts.model.Firestation;
import com.safetynet.alerts.model.MedicalRecord;
import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.model.PersonInfo;
import com.safetynet.alerts.model.Resident;
import com.safetynet.alerts.model.DTO.CoveredPersonDTO;
import com.safetynet.alerts.model.DTO.ResidentByAddressDTO;
import com.safetynet.alerts.service.ChildService;
import com.safetynet.alerts.service.CoveredPersonService;
import com.safetynet.alerts.service.FirestationService;
import com.safetynet.alerts.service.MedicalRecordService;
import com.safetynet.alerts.service.PersonInfoService;
import com.safetynet.alerts.service.PersonService;
import com.safetynet.alerts.service.ResidentFireService;
import com.safetynet.alerts.util.Util;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ChildControllerTest {

	@Autowired
	private ChildController childController;

	@MockBean
	@Autowired
	private ChildService childService;
	
	@Autowired
	private PersonService personService;
	
	@Autowired
	private PersonInfoService personInfoService;

	@Before
	private void setUp() {
		childController = new ChildController();
		childService = new ChildService();
		personService = new PersonService();
		personInfoService = new PersonInfoService();
	}

	@Test
	public void getChildrenAtAddressTest() {
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
		
		when(childService.getChildren("1509 Culver St")).thenReturn(children);

		ArrayList<Child> getChildren = childController.getChildrenAtAddress("1509 Culver St");
		
		assertThat(getChildren).isEqualTo(children);
	}

	@Test
	public void getNoChildrenAtAddressTest() {

		when(childService.getChildren("1509 Culver St")).thenReturn(null);

		ArrayList<Child> getChildren = childController.getChildrenAtAddress("1509 Culver St");

		assertThat(getChildren).isEqualTo(null);
	}



}
