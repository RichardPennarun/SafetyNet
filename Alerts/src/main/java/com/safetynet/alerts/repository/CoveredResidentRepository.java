package com.safetynet.alerts.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.safetynet.alerts.model.CoveredResident;

@Repository
public interface CoveredResidentRepository extends CrudRepository<CoveredResident, Integer> {

}
