package com.eiko.app.importers.communecter.api.client;

import com.eiko.app.importers.communecter.api.core.Paginated;
import com.eiko.app.importers.communecter.model.Organization;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommunecterClientTest {

    private CommunecterClient client;

    @BeforeEach
    public void setUp() throws Exception {
        client = Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .target(CommunecterClient.class, "https://www.communecter.org");
    }

    @Test
    public void shouldGetOrganization() {
        Paginated<Organization> biocoop = client.getOrganizations("Vrac");


        assertNotNull(biocoop);

    }
}