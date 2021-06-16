package com.safetynet.alerts.controller;


import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.safetynet.alerts.service.CommunityEmailService;

@RestController
public class CommunityEmailController {
	
	private static Logger logger = LogManager.getLogger(CommunityEmailController.class);
	
	@Autowired
	CommunityEmailService communityEmailService;
	
	// Get all Emails for the given city, @Param - city name, @Return - A list of emails
	@GetMapping("/communityEmail")
	public ArrayList<String> getEmails(@RequestParam("city") final String  city){
        logger.info("Request - Emails list for city=" + city);
        ArrayList<String> getemails = communityEmailService.getEmails(city);
        if (getemails.isEmpty()) {
        	logger.error("Wrong entry:" + city);	
        } else {
        	logger.info("Response - Emails list for " + city + ": " + getemails);
        	return getemails;
        }
		return null;
	}

}
