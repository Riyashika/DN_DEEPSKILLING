package com.cognizant.orm_learn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.repository.CountryRepository;

import jakarta.transaction.Transactional;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Transactional
    public List<Country> GetAllCountries() {
        return countryRepository.findAll();
    }

    @Transactional
    public Country GetCountryById(String code) {
        return countryRepository.findById(code).orElse(null);
    }

    @Transactional
    public void AddCountry(Country country) {
        countryRepository.save(country);
    }

    @Transactional
    public void UpdateCountry(Country country) {
        countryRepository.save(country);
    }

    @Transactional
    public void deleteCountryById(String code) {
        countryRepository.deleteById(code);
    }
}