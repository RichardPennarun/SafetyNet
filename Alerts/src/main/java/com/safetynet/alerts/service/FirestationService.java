package com.safetynet.alerts.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynet.alerts.model.Firestation;
import com.safetynet.alerts.model.MedicalRecord;
import com.safetynet.alerts.repository.FirestationRepository;

import lombok.Data;

@Data
@Service
public class FirestationService {
	
	@Autowired
	private FirestationRepository firestationRepository;
	
	public Optional<Firestation> getFirestation(final int id) {
		return firestationRepository.findById(id);
	}
	
	public List<Firestation> getFirestations() {
		return (List<Firestation>) firestationRepository.findAll();
	}
	
	public Firestation saveFirestation(Firestation firestation) {
		Firestation savedFirestation = firestationRepository.save(firestation);
		return savedFirestation;
	} 	 	
	
	public void deleteFirestation(final int givenId, final int station) {
		int id = 0;
		List<Firestation> firestations = getFirestations();
		
		for(Firestation firestation : firestations) {
			if (firestation.getId().equals(givenId)
					&& firestation.getStation().equals(station)) {
				id = firestation.getId();
			}
		}
		firestationRepository.deleteById(id);  
	} 
}