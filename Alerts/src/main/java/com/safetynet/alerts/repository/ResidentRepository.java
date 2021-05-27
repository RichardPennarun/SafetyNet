package com.safetynet.alerts.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.safetynet.alerts.model.Resident;

@Repository
public interface ResidentRepository extends CrudRepository<Resident, Integer>  {

}
