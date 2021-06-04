package com.safetynet.alerts.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.safetynet.alerts.model.DTO.ResidentByStationDTO;
import com.safetynet.alerts.service.ResidentFloodService;

@RestController
public class ResidentFloodController {
	
	private static Logger logger = LogManager.getLogger(ResidentFloodController.class);
	
	@Autowired
	ResidentFloodService residentFloodService;
	
	/*
	 * Get residents by address for a list of firestations by numbers (flood alert)
	 * @Param - a stationnumber list
	 * @Return - a list of objets (Resident by address) by station
	 */
	@GetMapping("/flood/stations")
	public List<ResidentByStationDTO> getResidentByStationNumber(@RequestParam("station") 
	final String stationNumbers) {
        logger.info("Request residents for stationNumber {}", stationNumbers);
		
		return (List<ResidentByStationDTO>) residentFloodService.getResidentsByStationNumber(stationNumbers);
	}

}
