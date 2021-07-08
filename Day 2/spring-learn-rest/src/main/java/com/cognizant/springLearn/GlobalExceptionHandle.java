package com.cognizant.springLearn;

import com.cognizant.SpringLearnRestApplication;
import com.cognizant.springLearn.entity.CountryExceptionResponse;
import com.cognizant.springLearn.exception.CountryNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandle {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnRestApplication.class);

    @ExceptionHandler
    public ResponseEntity<CountryExceptionResponse> handleException(CountryNotFoundException exception){
        LOGGER.info("Inside handleException()");
        CountryExceptionResponse buildError = new CountryExceptionResponse();

        buildError.setTimestamp(System.currentTimeMillis());
        buildError.setStatus(HttpStatus.NOT_FOUND.value());
        buildError.setPath(exception.getMessage());
        buildError.setError("Not Found");
        buildError.setMessage("Country Not Found");

        return new ResponseEntity<>(buildError, HttpStatus.NOT_FOUND);
    }

}
