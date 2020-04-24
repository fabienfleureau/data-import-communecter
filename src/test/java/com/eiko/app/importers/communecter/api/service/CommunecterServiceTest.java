package com.eiko.app.importers.communecter.api.service;

import com.eiko.app.importers.communecter.api.client.CommunecterClient;
import com.eiko.app.importers.communecter.model.Organization;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CommunecterServiceTest {

    private CommunecterService communecterService;

    @BeforeEach
    public void setUp() throws Exception {
        communecterService = new CommunecterService(Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .target(CommunecterClient.class, "https://www.communecter.org"));
    }

    @Test
    public void shouldGetOrganization() {
        Map<String, Organization> vracOrganizations = communecterService.getOrganizations("Vrac");


        assertNotNull(vracOrganizations);

    }

}