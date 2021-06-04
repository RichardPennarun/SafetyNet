package com.safetynet.alerts.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynet.alerts.model.Firestation;
import com.safetynet.alerts.repository.FirestationRepository;

import lombok.Data;

@Data
@Service
public class FirestationService {
	
	private static Logger logger = LogManager.getLogger(FirestationService.class);
	
	@Autowired
	private FirestationRepository firestationRepository;
	
	public Optional<Firestation> getFirestation(final int id) {
		return firestationRepository.findById(id);
	}
	
	public List<Firestation> getFirestations() {
		List<Firestation> firestations = (List<Firestation>) firestationRepository.findAll();
		logger.info("Response - All mappings:" + firestations);
		return firestations;
	}
	
	public Firestation saveFirestation(Firestation firestation) {
		Firestation savedFirestation = firestationRepository.save(firestation);
		logger.info("Response - " + savedFirestation + " saved");
		return savedFirestation;
	} 	 	 	
	
	public void deleteFirestationByAddress(final String address) {
		int id = 0;
		List<Firestation> firestations = getFirestations();
		
		for(Firestation firestation : firestations) {
			if (firestation.getAddress().equals(address)) {
				id = firestation.getId();
			}
		}
		firestationRepository.deleteById(id);  
		logger.info("Response - Mapping for address " + address + " deleted");
	} 	
	
	public void deleteFirestationByStationNumber(final int stationNumber) {
		List<Firestation> firestations = getFirestations();
		List<Integer> stationIds = new ArrayList<Integer>();
		for(Firestation firestation : firestations) {
			if (firestation.getStationNumber().equals(stationNumber)) {
				stationIds.add(firestation.getId());
			}
		}
		for (int id : stationIds) {
			firestationRepository.deleteById(id);  
		}
		logger.info("Response - Mappings for station number " + stationNumber + " deleted");
	} 
}