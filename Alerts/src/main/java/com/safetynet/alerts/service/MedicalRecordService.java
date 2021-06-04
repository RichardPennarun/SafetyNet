package com.safetynet.alerts.service; 

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;

import com.safetynet.alerts.model.MedicalRecord; 
import com.safetynet.alerts.repository.MedicalRecordRepository;

import lombok.Data; 

@Data  
@Service  
public class MedicalRecordService {
	
	private static Logger logger = LogManager.getLogger(MedicalRecordService.class); 	
	
	@Autowired 
	private MedicalRecordRepository medicalRecordRepository;  	 	
	
	public Optional<MedicalRecord> getMedicalRecord(final int id) {  		
		return medicalRecordRepository.findById(id);  		
	}  	 	
	
	public List<MedicalRecord> getMedicalRecords() {  		
		List<MedicalRecord> medicalRecords = (List<MedicalRecord>) medicalRecordRepository.findAll();  	
		logger.info("Response - All medical records:" + medicalRecords);
		return medicalRecords;
	}  	 	
	
	public MedicalRecord saveMedicalRecord(MedicalRecord medicalRecord) {  		
		MedicalRecord savedMedicalRecord = medicalRecordRepository.save(medicalRecord); 
		logger.info("Response - " + savedMedicalRecord + " saved"); 		
		return savedMedicalRecord;  		
	}  	 	
	
	public void deleteMedicalRecord(final String firstname, final String lastname) {
		int id = 0;
		List<MedicalRecord> medicalRecords = getMedicalRecords();
		
		for(MedicalRecord medicalRecord : medicalRecords) {
			if (medicalRecord.getFirstName().equals(firstname)
					&& medicalRecord.getLastName().equals(lastname)) {
				id = medicalRecord.getId();
			}
		}
		medicalRecordRepository.deleteById(id);  
		logger.info("Response - Medical record for " + firstname + " " + lastname + " deleted");
	} 
	

}