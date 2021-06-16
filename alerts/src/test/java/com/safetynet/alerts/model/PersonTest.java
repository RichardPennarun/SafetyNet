package com.safetynet.alerts.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class PersonTest {
	
	
	@Before
	private void setUpPerTest() {
		
	}
	
	@Test
	public void getPerson() {
		
		Person p = new Person();
		p.setId(1);
		p.setFirstName("richard");
		p.setLastName("pennarun");
		p.setAddress("36 rue des envierges");
		p.setCity("paris");
		p.setZip("75020");
		p.setPhone("0663173165");
		p.setEmail("richard@mail.com");

		assertThat(p.getId()).isEqualTo(1);
		assertThat(p.getFirstName()).isEqualTo("richard");
		assertThat(p.getLastName()).isEqualTo("pennarun");
		assertThat(p.getAddress()).isEqualTo("36 rue des envierges");
		assertThat(p.getCity()).isEqualTo("paris");
		assertThat(p.getZip()).isEqualTo("75020");
		assertThat(p.getPhone()).isEqualTo("0663173165");
		assertThat(p.getEmail()).isEqualTo("richard@mail.com");
	}

}
