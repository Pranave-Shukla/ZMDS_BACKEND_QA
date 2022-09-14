package com.zoetis.zdms.util.factory;

import com.zoetis.zdms.model.dictionary.CustomerType;
import com.zoetis.zdms.model.dictionary.Language;
import com.zoetis.zdms.model.dictionary.localized.customertype.LocalizedCustomerType;
import com.zoetis.zdms.model.dictionary.localized.customertype.LocalizedCustomerTypeId;
import lombok.experimental.UtilityClass;

@UtilityClass
public class LocalizedCustomerTypeFactory {

    public static final Language LANGUAGE = Language.DE;
    public static final CustomerType CUSTOMER_TYPE = CustomerType.DELIVERY;
    public static final String LOCALIZED_TYPE = "localized type";

    public LocalizedCustomerType buildDefault() {
        return LocalizedCustomerType.of(new LocalizedCustomerTypeId(LANGUAGE.getValue(), CUSTOMER_TYPE), LOCALIZED_TYPE);
    }
}
