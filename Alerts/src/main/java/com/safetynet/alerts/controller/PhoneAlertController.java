package com.safetynet.alerts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.safetynet.alerts.service.PhoneAlertService;

@RestController
public class PhoneAlertController {
	
	@Autowired
	PhoneAlertService phoneAlertService;
	
	/*
	 * Get phones from residents within a firestation zone
	 * @Param - station number
	 * @Return - A list of phone number
	 */
	@GetMapping("/phoneAlert")
	public List<String> getPhones(@RequestParam("firestation") final int stationNumber) {
		return (List<String>) phoneAlertService.getPhones(stationNumber);
		
	}

}
