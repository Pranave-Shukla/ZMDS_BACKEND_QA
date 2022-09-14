package com.zoetis.zdms.exception.status;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorMessage {

    /* common */
    INTERNAL_SERVER_ERROR("Internal Server Error"),
    BAD_REQUEST("Bad request"),
    FORBIDDEN("Forbidden"),
    NOT_FOUND("Not found"),
    CONFLICT("Conflict"),

    /* custom */
    PRODUCT_NOT_FOUND("Product not found"),
    PRODUCT_STATUS_NOT_FOUND("Product status not found"),
    CUSTOMER_NOT_FOUND("Customer not found"),
    CUSTOMER_LOOKUP_NOT_FOUND("Customer lookup not found"),
    INCORRECT_FREE_TEXT_VALUE("Incorrect free text value");

    private final String value;
}
