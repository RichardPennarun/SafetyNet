package com.safetynet.alerts.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class UtilTests {
	
	private static Util util;
	
	@BeforeAll
	private static void setUp() {
		util = new Util();
	}
	
	@BeforeEach
	private void setUpPerTest() {
		
	}
	
	@Test
	public void getAgeUnder20() {
		assertThat(util.getAge("06/30/2001")).isEqualTo(19);
	}
	
	@Test
	public void getAgeover20() {
		assertThat(util.getAge("05/30/2001")).isEqualTo(20);
	}
	
	@Test
	public void getAgeAt20() { // Check the day you're running this test
		assertThat(util.getAge("06/17/2001")).isEqualTo(20);
	}

}

