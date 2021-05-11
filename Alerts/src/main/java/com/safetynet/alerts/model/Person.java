package com.safetynet.alerts.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "persons")
public class Person {
	
	@Id
	@GeneratedValue
	private Integer id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
	private String lastName;
	
	private String address;
	
	private String city;
	
	private Integer zip;
	
	private String phone;
	
	private String email;

}