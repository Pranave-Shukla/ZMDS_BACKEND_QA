package com.zoetis.zdms.model.dictionary;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CustomerType {

    DELIVERY("DELIVERY"),
    VET_PRACTICE("VET_PRACTICE"),
    OTHER("OTHER");

    private final String value;
}

