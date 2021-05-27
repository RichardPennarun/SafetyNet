package com.safetynet.alerts.util;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Util {
	
	public int getAge(String birthdate) {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate localBirthdate = LocalDate.parse(birthdate, formatter);
        LocalDate today = LocalDate.now();
        Period age = Period.between(localBirthdate, today);
        
        return age.getYears();
	}

}
