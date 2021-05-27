package com.safetynet.alerts.controller;

import java.util.List;
import java.util.Optional;

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
	
	@Autowired
	FirestationService firestationService;
	
	 /*
	  * Get all firestations
	  * @return - The list of all mapping
	  */
	@GetMapping("/firestations")
	public List<Firestation> getFirestations() {
		return (List<Firestation>) firestationService.getFirestations();
	}
	
	 /*
	  * Delete a mapping
	  * @param - address, station
	  */
	@DeleteMapping("/firestation")
	public void deleteFirestationn(@RequestParam("id") final int givenId,
			@RequestParam("station") final int station) {
		firestationService.deleteFirestation(givenId, station);
	}
	
	/*
	 * Save a new mapping
	 * @param - An object mapping
	 * @return - The mapping object saved
	 */
	@PostMapping("/firestation")
	public Firestation createFirestation(@RequestBody Firestation firestation) {
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
		Optional<Firestation> f = firestationService.getFirestation(id);
		if(f.isPresent()) {
			Firestation currentFirestation = f.get();
			
			String address = firestation.getAddress();
			if(address != null) {
				currentFirestation.setAddress(address);
			}
			Integer station = firestation.getStation();
			if(station != null) {
				currentFirestation.setStation(station);
			}
			firestationService.saveFirestation(currentFirestation);
			return currentFirestation;
		} else {
			return null;
		}
	}

}
