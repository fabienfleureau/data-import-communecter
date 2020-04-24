package com.eiko.app.importers.communecter.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Organization extends Typed {

    private String name;
    private Address address;
    private Geo geo;

    private String description;
    private String email;
    private String image;
    private String typeCommunecter;
    private String api;
    private String slug;

    private List<String> tags;

    public Organization() {
    }

    public Organization(String name, Address address, Geo geo, String description, String email, String image, String typeCommunecter, String api, String slug, List<String> tags) {
        this.name = name;
        this.address = address;
        this.geo = geo;
        this.description = description;
        this.email = email;
        this.image = image;
        this.typeCommunecter = typeCommunecter;
        this.api = api;
        this.slug = slug;
        this.tags = tags;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Geo getGeo() {
        return geo;
    }

    public void setGeo(Geo geo) {
        this.geo = geo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTypeCommunecter() {
        return typeCommunecter;
    }

    public void setTypeCommunecter(String typeCommunecter) {
        this.typeCommunecter = typeCommunecter;
    }

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}