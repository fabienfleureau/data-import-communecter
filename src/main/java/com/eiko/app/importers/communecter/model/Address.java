package com.eiko.app.importers.communecter.model;

public class Address extends Typed {

    private String streetAddress;
    private String postalCode;
    private String addressLocality;
    private String codeInsee;
    private String addressCountry;

    public Address() {
    }

    public Address(String type, String streetAddress, String postalCode, String addressLocality, String codeInsee, String addressCountry) {
        super(type);
        this.streetAddress = streetAddress;
        this.postalCode = postalCode;
        this.addressLocality = addressLocality;
        this.codeInsee = codeInsee;
        this.addressCountry = addressCountry;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getAddressLocality() {
        return addressLocality;
    }

    public void setAddressLocality(String addressLocality) {
        this.addressLocality = addressLocality;
    }

    public String getCodeInsee() {
        return codeInsee;
    }

    public void setCodeInsee(String codeInsee) {
        this.codeInsee = codeInsee;
    }

    public String getAddressCountry() {
        return addressCountry;
    }

    public void setAddressCountry(String addressCountry) {
        this.addressCountry = addressCountry;
    }
}