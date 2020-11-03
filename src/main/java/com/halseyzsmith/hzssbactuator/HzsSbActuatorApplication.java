package com.halseyzsmith.hzssbactuator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
public class HzsSbActuatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(HzsSbActuatorApplication.class, args);
	}

}
