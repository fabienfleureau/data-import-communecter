package com.eiko.app.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Store {

    private String name;
    private String address;
    private String country;
    private String zip;
    @JsonIgnore
    private String brand;

    @JsonProperty("user_rating")
    private int userRating;

}
