package com.safetynet.alerts.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.safetynet.alerts.model.Child;

@Repository
public interface ChildRepository extends CrudRepository<Child, Integer> {

}
