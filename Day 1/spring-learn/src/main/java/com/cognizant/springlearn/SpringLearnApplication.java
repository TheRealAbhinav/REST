package com.cognizant.springlearn;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

@SpringBootApplication
public class SpringLearnApplication {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
	
	public static String displayDate() {
		
		LOGGER.info("inside: displayDate()");
		
		ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
		SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
		
		Date date = new Date();
		String currentDate = format.format(date);
		return currentDate;
//		System.out.println("Current Date = "+currentDate);
	 }

	public static String displayCountry() {
		
		LOGGER.info("inside: displayCountry()");
		
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country country = (Country) context.getBean("country", Country.class);
		return country.toString();
	}
	
	public static boolean testScope() {
		
		LOGGER.info("inside: testScope()");
		
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country country1 = (Country) context.getBean("country", Country.class);
		Country country2 = (Country) context.getBean("country", Country.class);
		return country1.equals(country2);
	}
	
	public static String displayCountries() {
		
		LOGGER.info("inside: displayCountries()");
		
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country country = (Country) context.getBean("countryList", Country.class);
		List<String> countries = country.getCountries();
		return countries.toString();
	}
	
	public static void main(String[] args) {
		
		SpringApplication.run(SpringLearnApplication.class, args);
		
		LOGGER.info("Start");
		
		String date = displayDate();
		
		LOGGER.info("date = "+date);
		
		String country = displayCountry();
		
		LOGGER.info("country = "+country);
		
		boolean countryScopeTest = testScope();
		
		LOGGER.info("country scope test = "+countryScopeTest);		//Add scope="prototype" in XML
		
		String countries = displayCountries();
		
		LOGGER.info("country List = "+countries);
		
		LOGGER.info("End");
	
	}

}
