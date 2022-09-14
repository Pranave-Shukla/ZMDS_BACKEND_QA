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
 * Gets or Sets ErrorCode
 */
public enum ErrorCodeDto {
  
  INTERNAL_SERVER_ERROR("INTERNAL_SERVER_ERROR"),
  
  BAD_REQUEST("BAD_REQUEST"),
  
  FORBIDDEN("FORBIDDEN"),
  
  NOT_FOUND("NOT_FOUND"),
  
  CONFLICT("CONFLICT"),
  
  INCORRECT_FREE_TEXT_VALUE("INCORRECT_FREE_TEXT_VALUE");

  private String value;

  ErrorCodeDto(String value) {
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
  public static ErrorCodeDto fromValue(String value) {
    for (ErrorCodeDto b : ErrorCodeDto.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

