package com.eiko.app.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Credentials {

    @JsonProperty("user_email")
    private String userEmail;
    @JsonProperty("user_password")
    private String userPassword;

}
