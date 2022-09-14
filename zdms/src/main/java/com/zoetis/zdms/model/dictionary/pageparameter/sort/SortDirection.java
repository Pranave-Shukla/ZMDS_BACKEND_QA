package com.zoetis.zdms.model.dictionary.pageparameter.sort;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SortDirection {

    ASC("ASC"),
    DESC("DESC");

    private final String value;
}
