package com.zoetis.zdms.model.dictionary;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum AccountType {

    SALES_REP("SALES_REP"),
    DISTRIBUTOR("DISTRIBUTOR"),
    LABORATORY("LABORATORY"),
    VET_PRACTICE("VET_PRACTICE"),
    HATCHERY("HATCHERY"),
    UNKNOWN("UNKNOWN"),
    FEED("FEED"),
    PRIVATE_LABEL("PRIVATE_LABEL"),
    PHARMACY("PHARMACY"),
    PRIVATE_FARM("PRIVATE_FARM");

    private final String value;
}
