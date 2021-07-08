package com.cognizant.springLearn.entity;

import lombok.*;

@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CountryExceptionResponse {

    private long timestamp;
    private int status;
    private String error;
    private String  message;
    private String path;

}
