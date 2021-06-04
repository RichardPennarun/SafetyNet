package com.safetynet.alerts.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.safetynet.alerts.model.PersonInfo;
import com.safetynet.alerts.service.PersonInfoService;

@RestController
public class PersonInfoController {
	
	private static Logger logger = LogManager.getLogger(PersonInfoController.class);
	
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
        logger.info("Request person info with firstname {}, lastname {}", firstname, lastname);
		PersonInfo personInfo = personInfoService.getPersonInfo(firstname,lastname);
		return personInfo;
		
	}

}
