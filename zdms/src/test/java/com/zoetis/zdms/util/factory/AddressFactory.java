package com.zoetis.zdms.util.factory;

import com.zoetis.zdms.model.Address;
import lombok.experimental.UtilityClass;

@UtilityClass
public class AddressFactory {

    public static final String COUNTRY_CODE = "country code";
    public static final String CITY = "city";
    public static final String POSTAL_CODE = "000-000";
    public static final String STREET = "street";
    public static final String STREET_NUMBER = "street number";

    public Address buildDefault() {
        return Address.of(COUNTRY_CODE, CITY, POSTAL_CODE, STREET, STREET_NUMBER);
    }
}
