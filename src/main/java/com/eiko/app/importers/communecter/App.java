package com.eiko.app.importers.communecter;

import com.eiko.app.api.model.Store;
import com.eiko.app.importers.communecter.api.client.CommunecterClient;
import com.eiko.app.importers.communecter.api.service.CommunecterService;
import com.eiko.app.importers.communecter.csv.Exporter;
import com.eiko.app.importers.communecter.mapper.StoreMapper;
import com.eiko.app.importers.communecter.service.OrganizationService;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;


public class App 
{
    public static void main( String[] args) throws FileNotFoundException {

        System.out.println("Processing stores api");
        CommunecterService communecterService = new CommunecterService(Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .target(CommunecterClient.class, "https://www.communecter.org"));

        OrganizationService organizationService = new OrganizationService(communecterService, new StoreMapper());
        Map<String, List<Store>> storesMap = organizationService.process();
        List<String> storeLines = new Exporter().exportToCsv(storesMap);


        storeLines.forEach(System.out::println);

        PrintWriter printWriter = new PrintWriter("/output/stores.csv");
        storeLines.forEach(printWriter::println);
    }
}
