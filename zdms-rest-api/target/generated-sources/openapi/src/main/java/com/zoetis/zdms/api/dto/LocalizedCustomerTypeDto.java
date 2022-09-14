package com.zoetis.zdms.api.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.zoetis.zdms.api.dto.CustomerTypeDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;


import java.util.*;

/**
 * LocalizedCustomerTypeDto
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-08-22T09:15:08.643330200-04:00[America/New_York]")
public class LocalizedCustomerTypeDto   {
  @JsonProperty("type")
  private CustomerTypeDto type;

  @JsonProperty("localizedType")
  private String localizedType;

  public LocalizedCustomerTypeDto type(CustomerTypeDto type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
  */
  @ApiModelProperty(value = "")

  @Valid

  public CustomerTypeDto getType() {
    return type;
  }

  public void setType(CustomerTypeDto type) {
    this.type = type;
  }

  public LocalizedCustomerTypeDto localizedType(String localizedType) {
    this.localizedType = localizedType;
    return this;
  }

  /**
   * Get localizedType
   * @return localizedType
  */
  @ApiModelProperty(value = "")


  public String getLocalizedType() {
    return localizedType;
  }

  public void setLocalizedType(String localizedType) {
    this.localizedType = localizedType;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LocalizedCustomerTypeDto localizedCustomerType = (LocalizedCustomerTypeDto) o;
    return Objects.equals(this.type, localizedCustomerType.type) &&
        Objects.equals(this.localizedType, localizedCustomerType.localizedType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, localizedType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LocalizedCustomerTypeDto {\n");
    
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    localizedType: ").append(toIndentedString(localizedType)).append("\n");
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

