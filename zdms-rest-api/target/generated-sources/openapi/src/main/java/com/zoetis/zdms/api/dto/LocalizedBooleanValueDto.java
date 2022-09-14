package com.zoetis.zdms.api.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.zoetis.zdms.api.dto.BooleanValueDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;


import java.util.*;

/**
 * LocalizedBooleanValueDto
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-08-22T09:15:08.643330200-04:00[America/New_York]")
public class LocalizedBooleanValueDto   {
  @JsonProperty("value")
  private BooleanValueDto value;

  @JsonProperty("localizedValue")
  private String localizedValue;

  public LocalizedBooleanValueDto value(BooleanValueDto value) {
    this.value = value;
    return this;
  }

  /**
   * Get value
   * @return value
  */
  @ApiModelProperty(value = "")

  @Valid

  public BooleanValueDto getValue() {
    return value;
  }

  public void setValue(BooleanValueDto value) {
    this.value = value;
  }

  public LocalizedBooleanValueDto localizedValue(String localizedValue) {
    this.localizedValue = localizedValue;
    return this;
  }

  /**
   * Get localizedValue
   * @return localizedValue
  */
  @ApiModelProperty(value = "")


  public String getLocalizedValue() {
    return localizedValue;
  }

  public void setLocalizedValue(String localizedValue) {
    this.localizedValue = localizedValue;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LocalizedBooleanValueDto localizedBooleanValue = (LocalizedBooleanValueDto) o;
    return Objects.equals(this.value, localizedBooleanValue.value) &&
        Objects.equals(this.localizedValue, localizedBooleanValue.localizedValue);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value, localizedValue);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LocalizedBooleanValueDto {\n");
    
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    localizedValue: ").append(toIndentedString(localizedValue)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

