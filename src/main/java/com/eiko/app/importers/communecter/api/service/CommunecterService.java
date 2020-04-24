package com.eiko.app.importers.communecter.api.service;

import com.eiko.app.importers.communecter.api.client.CommunecterClient;
import com.eiko.app.importers.communecter.api.core.Paginated;
import com.eiko.app.importers.communecter.model.Organization;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CommunecterService {

    private CommunecterClient communecterClient;

    public CommunecterService(CommunecterClient communecterClient) {
        this.communecterClient = communecterClient;
    }

    public Map<String, Organization> getOrganizations(String tag) {
        return getOrganizations(tag, 0);
    }

    private Map<String, Organization> getOrganizations(String tag, int index) {
        Map<String, Organization> organizations = new LinkedHashMap<>();
        Paginated<Organization> organizationsPage = communecterClient.getOrganizationsByPageIndex(tag, Integer.toString(index));
        organizations.putAll(organizationsPage.getEntities());
        if (organizationsPage.getMeta().getLimit() == 50) {
            organizations.putAll(getOrganizations(tag, 50 + index));
        }
        return organizations;
    }
}
