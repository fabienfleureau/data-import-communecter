package com.eiko.app.importers.communecter.api.core;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@NoArgsConstructor
@Getter
@Setter
public class Paginated<T> {

    private Meta meta;
    private Map<String, T> entities;

}
