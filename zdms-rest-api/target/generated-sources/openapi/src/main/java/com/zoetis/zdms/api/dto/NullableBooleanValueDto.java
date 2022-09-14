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
 * Gets or Sets NullableBooleanValue
 */
public enum NullableBooleanValueDto {
  
  TRUE("TRUE"),
  
  FALSE("FALSE");

  private String value;

  NullableBooleanValueDto(String value) {
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
  public static NullableBooleanValueDto fromValue(String value) {
    for (NullableBooleanValueDto b : NullableBooleanValueDto.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    return null;
  }
}

