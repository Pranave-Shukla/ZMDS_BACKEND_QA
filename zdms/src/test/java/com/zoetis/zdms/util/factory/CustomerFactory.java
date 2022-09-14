package com.zoetis.zdms.util.factory;

import com.zoetis.zdms.model.Address;
import com.zoetis.zdms.model.ContactDetails;
import com.zoetis.zdms.model.Customer;
import com.zoetis.zdms.model.CustomerStatus;
import com.zoetis.zdms.model.dictionary.AccountType;
import com.zoetis.zdms.model.dictionary.BooleanValue;
import com.zoetis.zdms.model.dictionary.CustomerState;
import com.zoetis.zdms.model.dictionary.CustomerType;
import com.zoetis.zdms.model.view.CustomerLookupView;
import com.zoetis.zdms.model.view.CustomerView;
import lombok.experimental.UtilityClass;

import java.time.OffsetDateTime;

@UtilityClass
public class CustomerFactory {

    public static final String ID = "1";
    public static final CustomerStatus STATUS = CustomerStatusFactory.buildDefault();
    public static final String FIRST_NAME = "first name";
    public static final String LAST_NAME = "last name";
    public static final String TITLE = "title";
    public static final CustomerState STATE = CustomerState.ACTIVE;
    public static final String ERP_ID = "erp id";
    public static final String NATIVE_ID = "native id";
    public static final CustomerType TYPE = CustomerType.DELIVERY;
    public static final String COMPANY_NAME = "company name";
    public static final String FORMATTED_COMPANY_NAME = "formatted company name";
    public static final Address ADDRESS = AddressFactory.buildDefault();
    public static final String FORMATTED_ADDRESS = "formatted address";
    public static final String SOURCE = "source";
    public static final OffsetDateTime NATIVE_CREATED_DATE = OffsetDateTime.now();

    public static final String NAME_1 = "NAME_1";
    public static final String NAME_2 = "NAME_2";
    public static final String NAME_3 = "NAME_3";
    public static final String NAME_4 = "NAME_4";
    public static final AccountType ACCOUNT_TYPE = AccountType.FEED;
    public static final ContactDetails CONTACT_DETAILS = ContactDetails.of("EMAIL", "PHONE_NUMBER", "SEARCH_TERMS");
    public static final BooleanValue IS_DELETED = BooleanValue.FALSE;

    public Customer buildDefaultCustomer() {
        return Customer.of(ID, TITLE, FIRST_NAME, LAST_NAME, STATUS, STATE, ERP_ID, NATIVE_ID, TYPE, COMPANY_NAME, FORMATTED_COMPANY_NAME, ADDRESS, FORMATTED_ADDRESS, SOURCE, NATIVE_CREATED_DATE);
    }

    public CustomerView buildDefaultCustomerView() {
        return CustomerView.of(
                ID, ERP_ID, LocalizedCustomerStatusFactory.CUSTOMER_STATUS, LocalizedCustomerStatusFactory.LOCALIZED_STATUS, LocalizedCustomerStatusFactory.LANGUAGE.getValue(),
                LocalizedCustomerStateFactory.CUSTOMER_STATE, LocalizedCustomerStateFactory.LOCALIZED_STATE, LocalizedCustomerStateFactory.LANGUAGE.getValue(),
                FORMATTED_COMPANY_NAME, FORMATTED_ADDRESS, LocalizedCustomerTypeFactory.CUSTOMER_TYPE, LocalizedCustomerTypeFactory.LOCALIZED_TYPE,
                LocalizedCustomerTypeFactory.LANGUAGE.getValue(), SOURCE, LocalizedRejectionReasonFactory.REJECTION_REASON,
                LocalizedRejectionReasonFactory.LOCALIZED_REJECTION_REASON, LocalizedRejectionReasonFactory.LANGUAGE.getValue(), NATIVE_CREATED_DATE
        );
    }

    public CustomerLookupView buildDefaultCustomerLookupView() {
        return CustomerLookupView.of(
                ID, CONTACT_DETAILS, NAME_1, NAME_2, NAME_3, NAME_4, TITLE, ACCOUNT_TYPE, ADDRESS.getStreet() + ADDRESS.getStreetNumber(), ADDRESS.getPostalCode(), ADDRESS.getCountryCode(), ADDRESS.getCity(), IS_DELETED
        );
    }
}
