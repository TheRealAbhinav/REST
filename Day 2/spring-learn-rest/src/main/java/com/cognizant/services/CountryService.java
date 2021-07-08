package com.cognizant.services;

import com.cognizant.springLearn.entity.Country;
import com.cognizant.springLearn.entity.CountryExceptionResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Repository
public class CountryService implements CountryDAO{
    @Override
    public List<Country> getCountryList() {

        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        Country country = (Country) context.getBean("countryList", Country.class);

        return country.getCountries();
    }

    @Override
    public Country getCountryByCode(String code) {

        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        Country country = (Country) context.getBean("countryList", Country.class);
        List<Country> countries = country.getCountries();

        for(Country c : countries){
            if (c.getCode().compareToIgnoreCase(code) == 0){
//                LOGGER.info("getCountryCode() END\nCountry = "+c);
                return c;
            }
        }

        return null;
    }

    @Override
    public Country getCountryIndia() {
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        Country country = (Country) context.getBean("country", Country.class);
        return country;
    }

    @Override
    public CountryExceptionResponse getErrorResponse(String exceptionMessage) {

        CountryExceptionResponse buildError = new CountryExceptionResponse();

        buildError.setTimestamp(System.currentTimeMillis());
        buildError.setStatus(HttpStatus.NOT_FOUND.value());
        buildError.setPath(exceptionMessage);
        buildError.setError("Not Found");
        buildError.setMessage("Country Not Found");

        return buildError;
    }
}
