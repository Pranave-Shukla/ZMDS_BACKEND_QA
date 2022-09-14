package com.zoetis.zdms.util.factory;

import com.zoetis.zdms.model.dictionary.CustomerState;
import com.zoetis.zdms.model.dictionary.Language;
import com.zoetis.zdms.model.dictionary.localized.customerstate.LocalizedCustomerState;
import com.zoetis.zdms.model.dictionary.localized.customerstate.LocalizedCustomerStateId;
import lombok.experimental.UtilityClass;

@UtilityClass
public class LocalizedCustomerStateFactory {

    public static final Language LANGUAGE = Language.DE;
    public static final CustomerState CUSTOMER_STATE = CustomerState.ACTIVE;
    public static final String LOCALIZED_STATE = "localized state";

    public LocalizedCustomerState buildDefault() {
        return LocalizedCustomerState.of(new LocalizedCustomerStateId(LANGUAGE.getValue(), CUSTOMER_STATE), LOCALIZED_STATE);
    }
}
