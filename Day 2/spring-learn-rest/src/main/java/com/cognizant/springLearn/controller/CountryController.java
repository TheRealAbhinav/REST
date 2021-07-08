package com.cognizant.springLearn.controller;

import com.cognizant.SpringLearnRestApplication;
import com.cognizant.springLearn.entity.Country;
import com.cognizant.springLearn.exception.CountryNotFoundException;
import com.cognizant.services.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Component
@RequestMapping("/countries")
public class CountryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnRestApplication.class);

    @Autowired
    private CountryService countryService;

        @RequestMapping("/country")
        public Country getCountryIndia(){
            LOGGER.info("Inside getCountryIndia()");
            Country country = countryService.getCountryIndia();
            return country;
        }

    @RequestMapping("/countryList")
    public List<Country> getCountryList(){
        LOGGER.info("Inside getCountryList()");
        List<Country> countries = countryService.getCountryList();
        return countries;
    }

    @RequestMapping("/country/{code}")
    public Country getCountryByCode(@PathVariable String code){
        LOGGER.info("Inside getCountryCode()");
        Country country = countryService.getCountryByCode(code);
        if (country != null){
            return country;
        }
        throw new CountryNotFoundException("country/"+code);
    }
    @PostMapping()
    public Country addCountry(@RequestBody @Valid Country country) {
        LOGGER.info("Started the POST request");
        LOGGER.debug("Country details: " + country);
        LOGGER.info("End!!");
        return country;
    }
}
