package com.safetynet.alerts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.safetynet.alerts.service.CommunityEmailService;

@RestController
public class CommunityEmailController {
	
	@Autowired
	CommunityEmailService communityEmailService;
	
	/*
	 * Get all Emails for the given city
	 * @Param -  city name
	 * @Return - A list of all emails
	 */
	@GetMapping("/communityEmail")
	public List<String> getEmails(@RequestParam("city") final String givenCity) {
		return (List<String>) communityEmailService.getEmails(givenCity);
	}

}
