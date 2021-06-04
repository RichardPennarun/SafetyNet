package com.safetynet.alerts.controller;

import java.util.List;

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
	
	/*
	 * Get phones from residents within a firestation zone
	 * @Param - station number
	 * @Return - A list of phone number
	 */
	@GetMapping("/phoneAlert")
	public List<String> getPhones(@RequestParam("firestation") final int stationNumber) {
        logger.info("Request phone numbers for station number {}", stationNumber);
		List<String> phoneNumbers = phoneAlertService.getPhones(stationNumber);
		return phoneNumbers;
		
	}

}
