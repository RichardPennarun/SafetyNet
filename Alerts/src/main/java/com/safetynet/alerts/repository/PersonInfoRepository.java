package com.safetynet.alerts.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.safetynet.alerts.model.PersonInfo;

@Repository
public interface PersonInfoRepository extends CrudRepository <PersonInfo, Integer>{

}
