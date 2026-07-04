package com.cognizant.orm_learn;

import java.util.List;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.service.CountryService;

@SpringBootApplication
public class OrmLearnApplication {
	
	public static Logger logger = LoggerFactory.getLogger(OrmLearnApplication.class);
	public static CountryService service;
	
	public static void main(String[] args) {
		
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
		service = context.getBean(CountryService.class);
		
		testGetAllCountries();
		
	}
	public static void testGetAllCountries() {
		logger.info("Start");
		List<Country> countries = service.GetAllCountries();
		logger.debug("countries={}",countries);
		logger.info("End");
	}

}
