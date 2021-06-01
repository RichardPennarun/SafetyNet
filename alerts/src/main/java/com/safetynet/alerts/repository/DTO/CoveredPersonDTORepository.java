package com.safetynet.alerts.repository.DTO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.safetynet.alerts.model.DTO.CoveredPersonDTO;

@Repository
public interface CoveredPersonDTORepository extends CrudRepository <CoveredPersonDTO, Integer> {

}
