package com.safetynet.alerts.controller;

import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.safetynet.alerts.model.Firestation;
import com.safetynet.alerts.service.FirestationService;

@RestController
public class FirestationController {
	
	private static Logger logger = LogManager.getLogger(FirestationController.class);
	
	@Autowired
	FirestationService firestationService;
	
	 // Get all firestations, returns a list of all mappings
	@GetMapping("/firestations")
	public ArrayList<Firestation> getFirestations() {
        logger.info("Request - Get all firestations");
		ArrayList<Firestation> firestations = firestationService.getFirestations();
		logger.info("Response - Returns all firestations: " + firestations);
		return firestations;
	}
	
	// Add a new mapping, @param - An object mapping, @return - The mapping object saved
	@PostMapping("/firestation")
	public Firestation createFirestation(@RequestBody Firestation firestation) {
		logger.info("Request - Create firestation @RequestBody = {} ", firestation);
		Firestation createdFirestation = firestationService.saveFirestation(firestation);
		if (createdFirestation == null) {
			logger.error("Wrong entry, missing some arguments:" + createdFirestation);
			return null;
		} else {
			logger.info("Response - Firestation saved: " + createdFirestation);
			return createdFirestation;
		}
	}
	
	// Update existing mapping, @param - The mapping with modifications, @return - The modified mapping
	@PutMapping("/firestation")
	public Firestation updateFirestation(@RequestBody Firestation firestation) {
		logger.info("Request - Update firestation @RequestBody = {} ", firestation);
		Firestation updatedFirestation = firestationService.updateFirestation(firestation);
		if (updatedFirestation == null) {
			logger.error("Wrong entry, missing some arguments:" + firestation);
			return null;
		} else {
			logger.info("Response - Firestation updated: " + updatedFirestation);
			return updatedFirestation;
		}
	}
	
	 // Delete a mapping by its address, @param - address
	@DeleteMapping("/deleteAddress")
	public void deleteMappingWithAddress(@RequestParam("address") final String address) {
		logger.info("Request - Delete mapping for an address {}", address);
		firestationService.deleteFirestationByAddress(address);
	}
	
	 // Delete a mapping by station, @param - a station number
	@DeleteMapping("/deleteFirestation")
	public void deleteMappingsWithStationNumber(@RequestParam("stationNumber") final int stationNumber) {
		logger.info("Request - Delete all mappings for firestation number {}", stationNumber);
		firestationService.deleteFirestationByStationNumber(stationNumber);
	}

}
