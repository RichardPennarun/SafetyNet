package com.safetynet.alerts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.safetynet.alerts.model.PersonInfo;
import com.safetynet.alerts.service.PersonInfoService;

@RestController
public class PersonInfoController {
	
	@Autowired
	PersonInfoService personInfoService;
	
	/*
	 * Get PersonInfo
	 * @Param - firstname,lastname
	 * @Return - a personInfo object
	 */
	@GetMapping("/personInfo")
	public PersonInfo getPersonInfo(@RequestParam("firstname") final String firstname,
			@RequestParam("lastname") final String lastname) {
		PersonInfo personInfo = personInfoService.getPersonInfo(firstname,lastname);
		return personInfo;
		
	}

}
