package com.eiko.app.importers.communecter.service;

import com.eiko.app.api.model.Store;
import com.eiko.app.importers.communecter.api.service.CommunecterService;
import com.eiko.app.importers.communecter.mapper.StoreMapper;
import com.eiko.app.importers.communecter.model.Organization;
import com.eiko.app.importers.communecter.utils.Sanitizer;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.tuple.Pair;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
public class OrganizationService {

    private CommunecterService communecterService;
    private StoreMapper storeMapper;

    public OrganizationService(CommunecterService communecterService, StoreMapper storeMapper) {
        this.communecterService = communecterService;
        this.storeMapper = storeMapper;
    }

    public Map<String, List<Store>> process() {
        return process(getOrganizations(), loadStoreBrands());
    }

    public Map<String, Organization> getOrganizations() {
        Map<String, Organization> organizationMap = new LinkedHashMap<>();
        for (String tag : loadTags()) {
            Map<String, Organization> organizations = communecterService.getOrganizations(tag);
            log.info(String.format("Found %s organizations for tag: %s", organizations.size(), tag));
            organizationMap.putAll(organizations);
        }
        log.info(String.format("Found %s organizations in total", organizationMap.size()));
        return organizationMap;
    }



    public List<String> loadTags() {
        try {
            return Arrays.asList(IOUtils.resourceToString("/tags.csv", Charset.defaultCharset()).split("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public List<Pair<String, String>> loadStoreBrands() {
        try {
            return Arrays.asList(IOUtils.resourceToString("/store_brands.csv", Charset.defaultCharset()).split("\n")).stream()
                    .map(brand -> Pair.of(Sanitizer.sanitizeBrand(brand), brand))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }


    public Map<String, List<Store>> process(Map<String, Organization> organizationMap, List<Pair<String, String>> storeBrands) {
        return organizationMap.values().stream()
                .map(organization -> processOrganization(organization, storeBrands))
                .filter(store -> store.getBrand() != null)
                .collect(Collectors.groupingBy(Store::getBrand));
    }

    private Store processOrganization(Organization organization, List<Pair<String, String>> storeBrands) {
        return storeMapper.map(organization, getBrand(organization, storeBrands).orElse(null));
    }

    public boolean isValidOrganization(Organization organization, List<String> storeBrands) {
        String organizationName = Sanitizer.sanitizeOrganizationName(organization.getName());
        return storeBrands.stream().anyMatch(organizationName::contains);
    }

    public Optional<String> getBrand(Organization organization, List<Pair<String, String>> storeBrands) {
        String organizationName = Sanitizer.sanitizeOrganizationName(organization.getName());
        return storeBrands.stream()
                .filter(storeBrand -> organizationName.contains(storeBrand.getKey()))
                .findAny()
                .map(Pair::getValue);
    }



}
