package com.cognizant.springLearn.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Country {

    @NotNull
    @Size(min = 2, max = 2, message = "Country code should be 2 characters")
    private String code;
    private String name;

    @JsonIgnore
    private List<Country> countries;

    public Country(List<Country> countries) {
        this.countries = countries;
    }
}
