package com.safetynet.alerts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.safetynet.alerts.model.DTO.ResidentByAddressDTO;
import com.safetynet.alerts.model.DTO.ResidentByStationDTO;
import com.safetynet.alerts.service.ResidentService;

@RestController
public class ResidentController {
	
	@Autowired
	ResidentService residentService;
	
	/*
	 * Get residents at a given address (fire alert)
	 * @Param - an address String
	 * @Return - a list of Resident object and a firestation object
	 */
	@GetMapping("/fire")
	public ResidentByAddressDTO getResidentByAddress(@RequestParam("address") 
			final String address) {
		
		return residentService.getResidentByAdress(address);
	}
	
	/*
	 * Get residents by address for a given firestation (flood alert)
	 * @Param - a stationnumber int
	 * @Return - a list of objets (Resident by address) by station
	 */
	@GetMapping("/flood/stations")
	public List<ResidentByStationDTO> getResidentByStation(@RequestParam("station") 
	final int station) {
		
		return (List<ResidentByStationDTO>) residentService.getResidentsByStation(station);
	}

}
