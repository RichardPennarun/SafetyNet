package com.safetynet.alerts.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.anything;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.safetynet.alerts.service.CommunityEmailService;
import com.safetynet.alerts.util.Util;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class CommunityEmailControllerTest {
	
	private static CommunityEmailController communityEmailController;
	
	@Mock
	@Autowired
	private static CommunityEmailService communityEmailService;
	
	@BeforeAll
	private static void setUp() {
		communityEmailController = new CommunityEmailController();
	}

	
	@BeforeEach
	private void setUpPerTest() {
		
	}
	
	@Test
	public void getEmailsTest() {
		List<String> getemails = communityEmailController.getEmails("culver");
		assertThat(getemails.isEmpty()).isFalse();
	}
	

}
