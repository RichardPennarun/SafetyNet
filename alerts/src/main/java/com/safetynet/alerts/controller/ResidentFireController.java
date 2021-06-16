package com.safetynet.alerts.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.safetynet.alerts.model.DTO.ResidentByAddressDTO;
import com.safetynet.alerts.service.ResidentFireService;

@RestController
public class ResidentFireController {
	
	private static Logger logger = LogManager.getLogger(ResidentFireController.class);
	
	@Autowired
	ResidentFireService residentFireService;
	
	// Get residents at a given address (fire alert), @Param - an address String
	// @Return - a list of Resident object, and a firestation object
	@GetMapping("/fire")
	public ResidentByAddressDTO getResidentByAddress(@RequestParam("address") 
			final String address) {
        logger.info("Request - Residents at adddress" + address);
        ResidentByAddressDTO residents = residentFireService.getResidentByAdress(address);
        if (residents == null) {
        	logger.error("Wrong entry:" + address);	
        } else {
        	logger.info("Response - Residents at address " + address + ": " + residents);
        	return residents;
        }
		return null;
	}

}
