package com.cognizant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringLearnRestApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnRestApplication.class);

	public static void main(String[] args) {

		LOGGER.info("Inside Main");

		SpringApplication.run(SpringLearnRestApplication.class, args);

		LOGGER.info("Main End");
	}

}
