package com.safetynet.alerts.controller;

import java.util.ArrayList;
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

	// Get residents by address for a list of firestation numbers, @Param - a
	// stationnumber list,
	// @Return - a list of objets (Resident by address) by station
	@GetMapping("/flood/stations")
	public ArrayList<ResidentByStationDTO> getResidentByStationNumber(
			@RequestParam("station") final String stationNumbers) {
		logger.info("Request - Residents for stationNumber " + stationNumbers);
		ArrayList<ResidentByStationDTO> residents = (ArrayList<ResidentByStationDTO>) residentFloodService
				.getResidentsByStationNumber(stationNumbers);
		if (residents == null) {
			logger.error("Wrong entry:" + stationNumbers);
		} else {
			logger.info("Response - Residents at address " + stationNumbers + ": " + residents);
			return residents;
		}
		return null;
	}

}
