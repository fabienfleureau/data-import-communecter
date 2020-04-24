package com.eiko.app.importers.communecter.utils;

import org.apache.commons.lang3.StringUtils;


public class Sanitizer {

    public static String sanitizeBrand(String brandRaw) {
        return StringUtils.toRootLowerCase(brandRaw).replaceAll("-","");
    }

    public static String sanitizeOrganizationName(String organizationName) {
        return StringUtils.toRootLowerCase(organizationName)
                .replaceAll("-","")
                .replaceAll("_","")
                .replaceAll(" ","")
                .replaceAll("'","");
    }
}
