package com.safetynet.alerts.service;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynet.alerts.model.Child;
import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.model.PersonInfo;
import com.safetynet.alerts.repository.ChildRepository;

@Service
public class ChildService {
	
	private static Logger logger = LogManager.getLogger(ChildService.class);

	@Autowired
	PersonService personService;

	@Autowired
	PersonInfoService personInfoService;

	public ArrayList<Child> getChildren(String address) {

		ArrayList<Child> children = new ArrayList<>();

		ArrayList<PersonInfo> personInfos = new ArrayList<PersonInfo>();
		ArrayList<Person> persons = personService.getPersons();
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
