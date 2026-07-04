package com.cognizant.orm_learn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.repository.CountryRepository;

import jakarta.transaction.Transactional;

@Service
public class CountryService {

    @Autowired
    public CountryRepository countryRepository;

    @Transactional
    public List<Country> GetAllCountries(){
        return countryRepository.findAll();
    }
    @Transactional
    public Country GetCountryById(String code){
        return countryRepository.findById(code).orElse(null);
    }

    @Transactional
    public void AddCountry(Country country){
        countryRepository.save(country);
        System.out.println("Country added successfully");
    }

    @Transactional
    public void deleteCountryById(String code){
        countryRepository.deleteById(code);
        System.out.println("Country deleted successfully");
    }
    @Transactional
    public void UpdateCountry(Country country){
        String code = country.getCode();
        Optional<Country> optional = countryRepository.findById(code);
        if(optional.isPresent()) countryRepository.save(country);
    }

}
