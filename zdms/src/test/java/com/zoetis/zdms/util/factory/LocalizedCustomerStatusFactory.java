package com.zoetis.zdms.util.factory;

import com.zoetis.zdms.model.dictionary.localized.customerstatus.LocalizedCustomerStatus;
import com.zoetis.zdms.model.dictionary.CustomerStatus;
import com.zoetis.zdms.model.dictionary.Language;
import com.zoetis.zdms.model.dictionary.localized.customerstatus.LocalizedCustomerStatusId;
import lombok.experimental.UtilityClass;

@UtilityClass
public class LocalizedCustomerStatusFactory {

    public static final Language LANGUAGE = Language.DE;
    public static final CustomerStatus CUSTOMER_STATUS = CustomerStatus.IN_REVIEW;
    public static final String LOCALIZED_STATUS = "localized status";

    public LocalizedCustomerStatus buildDefault() {
        return LocalizedCustomerStatus.of(new LocalizedCustomerStatusId(LANGUAGE.getValue(), CUSTOMER_STATUS), LOCALIZED_STATUS);
    }
}
