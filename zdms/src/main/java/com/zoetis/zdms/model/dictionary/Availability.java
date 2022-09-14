package com.zoetis.zdms.model.dictionary;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Availability {

    AVAILABLE("AVAILABLE"),
    NOT_AVAILABLE("NOT_AVAILABLE"),
    SHORT_TERM_NOT_AVAILABLE("SHORT_TERM_NOT_AVAILABLE"),
    MEDIUM_TERM_NOT_AVAILABLE("MEDIUM_TERM_NOT_AVAILABLE"),
    LONG_TERM_NOT_AVAILABLE("LONG_TERM_NOT_AVAILABLE");

    private final String value;
}


