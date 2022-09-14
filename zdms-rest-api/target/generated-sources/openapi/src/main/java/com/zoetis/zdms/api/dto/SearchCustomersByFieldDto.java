package com.zoetis.zdms.api.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;


import java.util.*;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets SearchCustomersByField
 */
public enum SearchCustomersByFieldDto {
  
  NATIVE_STATUS("NATIVE_STATUS"),
  
  ERP_ID("ERP_ID"),
  
  COMPANY_NAME("COMPANY_NAME"),
  
  ADDRESS("ADDRESS"),
  
  STATE("STATE"),
  
  TYPE("TYPE"),
  
  NATIVE_CREATED_DATE("NATIVE_CREATED_DATE"),
  
  SOURCE("SOURCE"),
  
  REJECTION_REASON("REJECTION_REASON");

  private String value;

  SearchCustomersByFieldDto(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static SearchCustomersByFieldDto fromValue(String value) {
    for (SearchCustomersByFieldDto b : SearchCustomersByFieldDto.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

