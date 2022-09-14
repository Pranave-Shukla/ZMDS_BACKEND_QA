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
 * Gets or Sets NullableProductAvailability
 */
public enum NullableProductAvailabilityDto {
  
  AVAILABLE("AVAILABLE"),
  
  NOT_AVAILABLE("NOT_AVAILABLE"),
  
  SHORT_TERM_NOT_AVAILABLE("SHORT_TERM_NOT_AVAILABLE"),
  
  MEDIUM_TERM_NOT_AVAILABLE("MEDIUM_TERM_NOT_AVAILABLE"),
  
  LONG_TERM_NOT_AVAILABLE("LONG_TERM_NOT_AVAILABLE");

  private String value;

  NullableProductAvailabilityDto(String value) {
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
  public static NullableProductAvailabilityDto fromValue(String value) {
    for (NullableProductAvailabilityDto b : NullableProductAvailabilityDto.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    return null;
  }
}

