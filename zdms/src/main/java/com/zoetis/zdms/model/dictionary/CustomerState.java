package com.zoetis.zdms.model.dictionary;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CustomerState {

    ACTIVE("ACTIVE"),
    DELETED("DELETED");

    private final String value;
}

