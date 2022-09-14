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
 * Gets or Sets SearchAuditsByField
 */
public enum SearchAuditsByFieldDto {
  
  DATA_SET("DATA_SET"),
  
  HEADER("HEADER"),
  
  MESSAGE("MESSAGE"),
  
  INITIATOR("INITIATOR"),
  
  DATE("DATE");

  private String value;

  SearchAuditsByFieldDto(String value) {
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
  public static SearchAuditsByFieldDto fromValue(String value) {
    for (SearchAuditsByFieldDto b : SearchAuditsByFieldDto.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

