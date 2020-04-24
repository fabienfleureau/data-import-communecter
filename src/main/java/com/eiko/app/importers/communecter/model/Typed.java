package com.eiko.app.importers.communecter.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Typed {

    @JsonProperty("@type")
    private String type;

    public Typed() {
    }

    public Typed(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
