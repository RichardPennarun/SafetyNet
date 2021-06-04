package com.safetynet.alerts.controller;

import java.util.List;

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
	
	/*
	 * Get all Emails for the given city
	 * @Param -  city name
	 * @Return - A list of all emails
	 */
	@GetMapping("/communityEmail")
	public List<String> getEmails(@RequestParam("city") final String  city){
        logger.info("Request - Residents emails list for city: " + city);
        List<String> getemails = communityEmailService.getEmails(city);
        if (getemails.isEmpty()) {
        	logger.error("Wrong entry:" + city);	
        }
        logger.info("Response - Emails list for " + city + ": " + getemails);
        return getemails;
        
	}

}
