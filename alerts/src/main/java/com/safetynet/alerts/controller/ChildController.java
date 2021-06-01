package com.safetynet.alerts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.safetynet.alerts.model.Child;
import com.safetynet.alerts.service.ChildService;

@RestController
public class ChildController {

	@Autowired
	ChildService childService;
	
	/*
	 * Get children at address
	 * @Param - an address String
	 * @Retrun - a list of children objects
	 */
	@GetMapping("/childAlert")
	public List<Child> getChildren(@RequestParam("address") final String address) {
		
		return (List<Child>) childService.getChildren(address);
		
	}
}
