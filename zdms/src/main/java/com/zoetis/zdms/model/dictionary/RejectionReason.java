package com.zoetis.zdms.model.dictionary;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum RejectionReason {

    ADDRESS("ADDRESS"),
    NAME("NAME"),
    OTHER("OTHER"),
    REFERENCE("REFERENCE");

    private final String value;
}


