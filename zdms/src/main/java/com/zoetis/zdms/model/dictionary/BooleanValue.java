package com.zoetis.zdms.model.dictionary;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum BooleanValue {

    TRUE("TRUE"),
    FALSE("FALSE");

    private final String value;
}
