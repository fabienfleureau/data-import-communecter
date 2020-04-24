package com.eiko.app.importers.communecter.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Geo extends Typed {

    private float latitude;
    private float longitude;

    public Geo() {
    }

    public Geo(String type, float latitude, float longitude) {
        super(type);
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }
}
