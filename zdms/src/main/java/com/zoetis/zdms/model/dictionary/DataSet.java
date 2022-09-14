package com.zoetis.zdms.model.dictionary;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum DataSet {

    CUSTOMER("CUSTOMER"),
    PRODUCT("PRODUCT");

    private final String value;

}
