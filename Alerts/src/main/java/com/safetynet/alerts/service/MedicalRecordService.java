package com.safetynet.alerts.service; 

import java.util.List;
import java.util.Optional; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 

import com.safetynet.alerts.model.MedicalRecord; 
import com.safetynet.alerts.repository.MedicalRecordRepository;

import lombok.Data; 

@Data  
@Service  
public class MedicalRecordService {  	 	
	
	@Autowired 
	private MedicalRecordRepository medicalRecordRepository;  	 	
	
	public Optional<MedicalRecord> getMedicalRecord(final int id) {  		
		return medicalRecordRepository.findById(id);  		
	}  	 	
	
	public List<MedicalRecord> getMedicalRecords() {  		
		return (List<MedicalRecord>) medicalRecordRepository.findAll();  		
	}  	 	
	
	public MedicalRecord saveMedicalRecord(MedicalRecord medicalRecord) {  		
		MedicalRecord savedMedicalRecord = medicalRecordRepository.save(medicalRecord);  		
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
	} 
	

}