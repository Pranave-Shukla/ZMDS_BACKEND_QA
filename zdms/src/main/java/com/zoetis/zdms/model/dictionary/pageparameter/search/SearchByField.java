package com.zoetis.zdms.model.dictionary.pageparameter.search;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public final class SearchByField {

    @AllArgsConstructor
    @Getter
    public enum Customer {

        NATIVE_STATUS("NATIVE_STATUS"),
        ERP_ID("ERP_ID"),
        COMPANY_NAME("COMPANY_NAME"),
        ADDRESS("ADDRESS"),
        STATE("STATE"),
        TYPE("TYPE"),
        NATIVE_CREATED_DATE("NATIVE_CREATED_DATE"),
        SOURCE("SOURCE"),
        REJECTION_REASON("REJECTION_REASON");

        private final String value;
    }

    @AllArgsConstructor
    @Getter
    public enum Product {

        IS_VISIBLE("IS_VISIBLE"),
        AVAILABILITY("AVAILABILITY"),
        PRODUCT_ID("PRODUCT_ID"),
        DESCRIPTION("DESCRIPTION"),
        MINIMUM_ORDER_QUANTITY("MINIMUM_ORDER_QUANTITY"),
        MAXIMUM_ORDER_QUANTITY("MAXIMUM_ORDER_QUANTITY"),
        HAS_MEDIA("HAS_MEDIA"),
        SOURCE("SOURCE");

        private final String value;
    }

    @AllArgsConstructor
    @Getter
    public enum Audit {

        DATA_SET("DATA_SET"),
        HEADER("HEADER"),
        MESSAGE("MESSAGE"),
        INITIATOR("INITIATOR"),
        DATE("DATE");

        private final String value;
    }
}
