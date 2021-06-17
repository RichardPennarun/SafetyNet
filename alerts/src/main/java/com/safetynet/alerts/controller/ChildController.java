package com.safetynet.alerts.controller;

import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.safetynet.alerts.model.Child;
import com.safetynet.alerts.service.ChildService;

@RestController
public class ChildController {
	
	private static Logger logger = LogManager.getLogger(ChildController.class);

	@Autowired
	ChildService childService;
	
	// Get children at address, @Param - an address String, @Retrun - a list of children objects
	@GetMapping("/childAlert")
	public ArrayList<Child> getChildrenAtAddress(@RequestParam("address") final String address) {
        logger.info("Request - Children at address: " + address);
		
		ArrayList<Child> children = childService.getChildren(address);
		if (children == null) {
        	logger.info("No child at address: " + address);	
        } else {
        	logger.info("Response - Children at address " + address + ": " + children);
        	return children;
        }
		return null;
	}
}
