package com.zoetis.zdms.util.factory;

import com.zoetis.zdms.model.Customer;
import com.zoetis.zdms.model.CustomerStatus;
import com.zoetis.zdms.model.dictionary.BooleanValue;
import com.zoetis.zdms.model.dictionary.RejectionReason;
import lombok.experimental.UtilityClass;

import java.time.OffsetDateTime;

@UtilityClass
public class CustomerStatusFactory {

    public static final String ID = "1";
    public static final Customer CUSTOMER = CustomerFactory.buildDefaultCustomer();
    public static final com.zoetis.zdms.model.dictionary.CustomerStatus LOCAL_STATUS = com.zoetis.zdms.model.dictionary.CustomerStatus.BLOCKED;
    public static final String LOCAL_FREE_TEXT = "local free text";
    public static final BooleanValue ETL_PROCESSED = BooleanValue.FALSE;
    public static final BooleanValue APP_PROCESSED = BooleanValue.FALSE;
    public static final OffsetDateTime UPDATED_DATE = OffsetDateTime.now();
    public static final RejectionReason REJECTION_REASON = LocalizedRejectionReasonFactory.REJECTION_REASON;
    public static final String UPDATED_BY = "updated by";

    public CustomerStatus buildDefault() {
        return CustomerStatus.of(ID, CUSTOMER, LOCAL_STATUS, ETL_PROCESSED, APP_PROCESSED, UPDATED_DATE, UPDATED_BY, REJECTION_REASON, LOCAL_FREE_TEXT);
    }
}
