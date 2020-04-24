package com.eiko.app.importers.communecter.api.client;

import com.eiko.app.importers.communecter.api.core.Paginated;
import com.eiko.app.importers.communecter.model.Organization;
import feign.Param;
import feign.RequestLine;

public interface CommunecterClient {
    @RequestLine("GET /api/organization/get?tags={tags}")
    Paginated<Organization> getOrganizations(@Param("tags") String tags);

    @RequestLine("POST /api/organization/get/limit/50/index/{index}/tags/{tags}")
    Paginated<Organization> getOrganizationsByPageIndex(@Param("tags") String tags, @Param("index") String index);

}