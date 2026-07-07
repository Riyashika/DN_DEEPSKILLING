package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.model.CountryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;


@RestController
public class CountryController {

    @Autowired
    @Qualifier("in")
    private CountryModel country;

    @RequestMapping (value = "/country",method = RequestMethod.GET)
    public CountryModel getCountryIndia() {
        return country;
    }

}