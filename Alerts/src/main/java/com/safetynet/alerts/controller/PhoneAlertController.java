package com.safetynet.alerts.controller;

import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.safetynet.alerts.service.PhoneAlertService;

@RestController
public class PhoneAlertController {
	
	private static Logger logger = LogManager.getLogger(PhoneAlertController.class);
	
	@Autowired
	PhoneAlertService phoneAlertService;
	
	// Get phones for a firestation,* @Param - a station number, @Return - A list of phones
	@GetMapping("/phoneAlert")
	public ArrayList<String> getPhones(@RequestParam("firestation") final int stationNumber) {
        logger.info("Request - Phones for station number {}", stationNumber);
        ArrayList<String> phoneNumbers = phoneAlertService.getPhones(stationNumber);
        if (phoneNumbers.isEmpty()) {
        	logger.error("Wrong entry: stationNumber" + stationNumber);	
        } else {
        	logger.info("Response - Emails list for stationNumber" + stationNumber + 
        			": " + phoneNumbers);
        	return phoneNumbers;
        }
		return null;
		
	}

}
