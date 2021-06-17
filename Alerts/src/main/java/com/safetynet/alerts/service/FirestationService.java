package com.safetynet.alerts.service;

import java.util.ArrayList;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynet.alerts.model.Firestation;
import com.safetynet.alerts.repository.FirestationRepository;

@Service
public class FirestationService {

	private static Logger logger = LogManager.getLogger(FirestationService.class);

	@Autowired
	private FirestationRepository firestationRepository;

	// GET a firestation by id
	public Optional<Firestation> getFirestation(final int id) {
		logger.debug("Get a firestation by its id: " + id);
		return firestationRepository.findById(id);
	}

	// GET all firestations
	public ArrayList<Firestation> getFirestations() {
		ArrayList<Firestation> firestations = (ArrayList<Firestation>) firestationRepository.findAll();
		logger.debug("firestationnRepository.findAll()");
		return firestations;
	}

	// POST a firestation
	public Firestation saveFirestation(Firestation firestation) {
		Firestation savedFirestation = firestationRepository.save(firestation);
		logger.debug("Save firestation: " + firestation);
		return savedFirestation;
	}

	// PUT a firestation
	public Firestation updateFirestation(Firestation firestation) {
		int id = 0;
		ArrayList<Firestation> firestations = getFirestations();
		for (Firestation fs : firestations) {
			if (fs.getAddress().equals(firestation.getAddress())) {
				id = fs.getId();
				logger.debug("Find the firestation to update");
			}
		}
		Optional<Firestation> firestationToUpdate = getFirestation(id);
		if (firestationToUpdate.isPresent()) {
			Firestation modifiedFirestation = firestationToUpdate.get();
			String address = firestation.getAddress();
			if (address != null) {
				modifiedFirestation.setAddress(address);
			}
			Integer stationNumber = firestation.getStationNumber();
			if (stationNumber != null) {
				modifiedFirestation.setStationNumber(stationNumber);
			}
			saveFirestation(modifiedFirestation);
			logger.debug("Save the updated firestation");
			return modifiedFirestation;
		} else {
			return null;
		}
	}

	public void deleteFirestationByAddress(final String address) {
		int id = 0;
		ArrayList<Firestation> firestations = getFirestations();
		for (Firestation firestation : firestations) {
			if (firestation.getAddress().equals(address)) {
				id = firestation.getId();
			}
		}
		if (id != 0) {
			logger.info("Response - Mapping for address " + address + " deleted");
			firestationRepository.deleteById(id);
		} else {
			logger.error("Wrong entry: " + address + " not in database");
		}
	}

	public void deleteFirestationByStationNumber(final int stationNumber) {
		ArrayList<Firestation> firestations = getFirestations();
		ArrayList<Integer> stationIds = new ArrayList<Integer>();
		for (Firestation firestation : firestations) {
			if (firestation.getStationNumber().equals(stationNumber)) {
				stationIds.add(firestation.getId());
			}
		}
		for (int id : stationIds) {
			if (id != 0) {
				logger.info("Response - Mappings for station number " + stationNumber + " deleted");
				firestationRepository.deleteById(id);
			} else {
				logger.error("Wrong entry: station number " + stationNumber + " not in database");
			}
		}
	}
}