package com.safetynet.alerts.controller;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	 /*
	  * Get all firestations
	  * @return - The list of all mapping
	  */
	@GetMapping("/firestations")
	public List<Firestation> getFirestations() {
        logger.info("Request - Get all firestation");
		return (List<Firestation>) firestationService.getFirestations();
	}
	
	/*
	 * Save a new mapping
	 * @param - An object mapping
	 * @return - The mapping object saved
	 */
	@PostMapping("/firestation")
	public Firestation createFirestation(@RequestBody Firestation firestation) {
		logger.info("Request - Create firestation @RequestBody = {} ", firestation);
		return firestationService.saveFirestation(firestation);
	}
	
	/*
	 * Update existing mapping
	 * @param  - id
	 * @param - The mapping with modifications
	 * @return - The modified mapping
	 */
	@PutMapping("/firestation/{id}")
	public Firestation updateFirestation(@PathVariable("id") final int id, 
			@RequestBody Firestation firestation) {
		logger.info("Request - Update firestation @RequestBody = {} ", firestation);
		Optional<Firestation> f = firestationService.getFirestation(id);
		if(f.isPresent()) {
			Firestation currentFirestation = f.get();
			
			String address = firestation.getAddress();
			if(address != null) {
				currentFirestation.setAddress(address);
			}
			Integer station = firestation.getStationNumber();
			if(station != null) {
				currentFirestation.setStationNumber(station);
			}
			firestationService.saveFirestation(currentFirestation);
			return currentFirestation;
		} else {
			return null;
		}
	}
	
	 /*
	  * Delete a mapping by address
	  * @param - address
	  */
	@DeleteMapping("/deleteAddress")
	public void deleteMappingWithAddress(@RequestParam("address") final String address) {
		logger.info("Request - Delete mapping for address {}", address);
		firestationService.deleteFirestationByAddress(address);
	}
	
	 /*
	  * Delete a mapping by station
	  * @param - station number
	  */
	@DeleteMapping("/deleteFirestation")
	public void deleteMappingsWithStationNumber(@RequestParam("stationNumber") final int stationNumber) {
		logger.info("Request - Delete all mappings for firestation number {}", stationNumber);
		firestationService.deleteFirestationByStationNumber(stationNumber);
	}

}
