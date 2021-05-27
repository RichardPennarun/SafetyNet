package com.safetynet.alerts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.safetynet.alerts.model.CoveredResident;
import com.safetynet.alerts.service.ResidentService;

@RestController
public class ResidentController {
	
	@Autowired
	ResidentService residentService;
	
	/*
	 * Get residents at a given address
	 * @Param - an address String
	 * @Return - a list of Resident object and a firestation object
	 */
	@GetMapping("/resident")
	public CoveredResident getCoveredResidents(@RequestParam("address") final String address) {
		CoveredResident coveredResident = residentService.getCoveredResidents(address);
		
		return coveredResident;
	}

}
