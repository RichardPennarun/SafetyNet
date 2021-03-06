package com.safetynet.alerts.service;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynet.alerts.model.Child;
import com.safetynet.alerts.model.MedicalRecord;
import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.model.PersonInfo;
import com.safetynet.alerts.model.Resident;
import com.safetynet.alerts.model.DTO.ResidentByAddressDTO;
import com.safetynet.alerts.repository.ChildRepository;
import com.safetynet.alerts.util.Util;

import lombok.Data;

@Data
@Service
public class ChildService {

	@Autowired
	PersonService personService;

	@Autowired
	MedicalRecordService medicalRecordService;

	@Autowired
	PersonInfoService personInfoService;

	@Autowired
	ChildRepository childRepository;

	public List<Child> getChildren(String address) {

		ArrayList<Child> children = new ArrayList<>();

		ArrayList<PersonInfo> personInfos = new ArrayList<PersonInfo>();
		List<Person> persons = personService.getPersons();
		for (Person p : persons) {
			personInfos.add(personInfoService.getPersonInfo(p.getFirstName(), p.getLastName()));
		}
		for (PersonInfo personInfo : personInfos) {
			if (personInfo.getAddress().equals(address)) {
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
								&& personInfo2.getAddress().equals(address)) {
							coresidents.add("" + personInfo2.getFirstName() + " " + personInfo2.getLastName() 
									+ ", " + personInfo2.getAge() + "");
						}
					}
					child.setCoresidents(coresidents);
					children.add(child);
				}
			}
		}
		
		
		
		
		return children;
	}

}
