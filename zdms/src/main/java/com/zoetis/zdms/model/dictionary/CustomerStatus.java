package com.zoetis.zdms.model.dictionary;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CustomerStatus {

    IN_REVIEW("IN_REVIEW"),
    VALIDATED("VALIDATED"),
    BLOCKED("BLOCKED");

    private final String value;
}

