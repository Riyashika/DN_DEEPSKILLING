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

AddCountry("SO","RIYASHIKA");
GetCountryById("SO");
DeleteCountryById("US");
UpdateCountryById("IN","INDIA");
GetAllCountries();
	}
	public static void GetAllCountries() {
		logger.info("Getting all countries");
		List<Country> countries = service.GetAllCountries();
		for(Country country : countries) System.out.println(country.toString());
		logger.info("All countries successfully");
	}
	public static void AddCountry(String code, String name){
		logger.info("Adding country with code {} and name {}", code, name);
		service.AddCountry(new Country(code,name));
		logger.info("Country added successfully");
	}
	public static void GetCountryById(String code){
		logger.info("Getting Country by code", code);
		service.GetCountryById(code);
		logger.debug("Country retrieved successfully", service.GetCountryById(code));
	}
	public static void DeleteCountryById(String code){
		logger.info("Deleting Country by code");
		service.deleteCountryById(code);
		logger.debug("Country deleted successfully", service.GetCountryById(code));
	}
	public static void UpdateCountryById(String code, String name){
		logger.info("Updating Country by code");
		service.UpdateCountry(new Country(code,name));
		logger.info("Country updated successfully", service.GetCountryById(code));
	}
}
