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
 * Gets or Sets ProductAvailability
 */
public enum ProductAvailabilityDto {
  
  AVAILABLE("AVAILABLE"),
  
  NOT_AVAILABLE("NOT_AVAILABLE"),
  
  SHORT_TERM_NOT_AVAILABLE("SHORT_TERM_NOT_AVAILABLE"),
  
  MEDIUM_TERM_NOT_AVAILABLE("MEDIUM_TERM_NOT_AVAILABLE"),
  
  LONG_TERM_NOT_AVAILABLE("LONG_TERM_NOT_AVAILABLE");

  private String value;

  ProductAvailabilityDto(String value) {
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
  public static ProductAvailabilityDto fromValue(String value) {
    for (ProductAvailabilityDto b : ProductAvailabilityDto.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

