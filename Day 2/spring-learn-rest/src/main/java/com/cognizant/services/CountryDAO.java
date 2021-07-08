package com.cognizant.services;

import com.cognizant.springLearn.entity.Country;
import com.cognizant.springLearn.entity.CountryExceptionResponse;

import java.util.List;

public interface CountryDAO {
    public List<Country> getCountryList();
    public Country getCountryByCode(String code);
    public Country getCountryIndia();
    public CountryExceptionResponse getErrorResponse(String exceptionMessage);
}
