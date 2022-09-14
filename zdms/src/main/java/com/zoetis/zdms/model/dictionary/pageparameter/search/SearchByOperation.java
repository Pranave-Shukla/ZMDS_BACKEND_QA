package com.zoetis.zdms.model.dictionary.pageparameter.search;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SearchByOperation {

    IN("IN"),
    LIKE("LIKE");

    private final String value;
}
