package com.eiko.app.importers.communecter.mapper;

import com.eiko.app.api.model.Store;
import com.eiko.app.importers.communecter.model.Organization;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StoreMapper {


    public Store map(Organization organization, String brand) {
        Store store = new Store();
        store.setName(organization.getName());
        store.setBrand(brand);
        if (organization.getAddress() != null) {

            store.setAddress(organization.getAddress().getStreetAddress());
            store.setZip(organization.getAddress().getPostalCode());
            store.setCountry(organization.getAddress().getAddressCountry());
        } else {
            log.warn(String.format("Missing address for organisation: %s", organization.getName()));
        }
        return store;
    }
}
