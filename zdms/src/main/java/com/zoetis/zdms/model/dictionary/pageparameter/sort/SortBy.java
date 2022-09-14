package com.zoetis.zdms.model.dictionary.pageparameter.sort;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public final class SortBy {

    @AllArgsConstructor
    @Getter
    public enum Customer {

        NATIVE_STATUS("nativeStatus"),
        ERP_ID("erpId"),
        COMPANY_NAME("companyName"),
        ADDRESS("address"),
        STATE("state"),
        TYPE("type"),
        NATIVE_CREATED_DATE("nativeCreatedDate"),
        SOURCE("source"),
        REJECTION_REASON("rejectionReason");

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
