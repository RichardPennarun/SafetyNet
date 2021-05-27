package com.safetynet.alerts;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.function.IntPredicate;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.safetynet.alerts.util.Util;

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
	public void getAgeTest() {
		
		assertThat(util.getAge("26/05/2001")).isEqualTo(20);
		assertThat(util.getAge("27/05/2001")).isEqualTo(20);
		assertThat(util.getAge("28/05/2001")).isEqualTo(19);
	}

}
