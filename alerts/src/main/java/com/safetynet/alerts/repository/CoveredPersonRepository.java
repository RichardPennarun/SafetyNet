package com.safetynet.alerts.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.safetynet.alerts.model.CoveredPerson;

@Repository
public interface CoveredPersonRepository extends CrudRepository<CoveredPerson, Integer> {

}
