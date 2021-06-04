package com.safetynet.alerts.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.safetynet.alerts.model.DTO.CoveredPersonDTO;
import com.safetynet.alerts.service.CoveredPersonService;

@RestController
public class CoveredPersonController {
	
	private static Logger logger = LogManager.getLogger(CoveredPersonController.class);
	
	@Autowired
	CoveredPersonService coveredPersonService;
	
	/*
	 * Get persons covered by a station
	 * @Param - a station numbre int
	 * @Return - list of persons + children/adults count
	 */
	@GetMapping("/firestation")
	public CoveredPersonDTO getCoveredPersons(@RequestParam("stationNumber") 
			final int stationNumber) {
        logger.info("Request covered persons for station number {}", stationNumber);
		
		return coveredPersonService.getCoveredPersons(stationNumber);
	}

}
