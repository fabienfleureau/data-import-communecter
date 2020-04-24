package com.eiko.app.importers.communecter.service;

import com.eiko.app.api.model.Store;
import com.eiko.app.importers.communecter.api.client.CommunecterClient;
import com.eiko.app.importers.communecter.api.service.CommunecterService;
import com.eiko.app.importers.communecter.csv.Exporter;
import com.eiko.app.importers.communecter.mapper.StoreMapper;
import feign.Feign;
import feign.Logger;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class OrganizationServiceTest {

    private OrganizationService organizationService;
    private CommunecterService communecterService;

    @BeforeEach
    void setUp() {

        communecterService = new CommunecterService(Feign.builder()
                .logger(new Logger.JavaLogger().appendToFile("http.log"))
                .logLevel(Logger.Level.FULL)
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .target(CommunecterClient.class, "https://www.communecter.org"));

        organizationService = new OrganizationService(communecterService, new StoreMapper());
    }

    @Test
    void splitTags() {
        List<String> tags = organizationService.loadTags();
        assertEquals(6, tags.size());
    }

    @Test
    public void testProcess() {
        Map<String, List<Store>> storesMap = organizationService.process();
        new Exporter().exportToCsv(storesMap);
        assertNotNull(storesMap);
    }
}