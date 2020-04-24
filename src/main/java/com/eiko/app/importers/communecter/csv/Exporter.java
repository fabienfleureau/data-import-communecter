package com.eiko.app.importers.communecter.csv;

import com.eiko.app.api.model.Store;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
public class Exporter {

    public List<String> exportToCsv(Map<String, List<Store>> storesMap) {
        return storesMap.entrySet().stream()
                .flatMap(entry -> entry.getValue().stream()
                        .map(store -> String.format("%s,%s,%s,%s,%s",
                                store.getBrand(),
                                store.getName(),
                                store.getAddress(),
                                store.getZip(),
                                store.getCountry(),
                                store.getUserRating())))
                .collect(Collectors.toList());

    }
}
