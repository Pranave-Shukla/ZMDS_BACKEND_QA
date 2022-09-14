package com.zoetis.zdms.api.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.zoetis.zdms.api.dto.CustomerNativeStatusDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;


import java.util.*;

/**
 * LocalizedCustomerNativeStatusDto
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-08-22T09:15:08.643330200-04:00[America/New_York]")
public class LocalizedCustomerNativeStatusDto   {
  @JsonProperty("nativeStatus")
  private CustomerNativeStatusDto nativeStatus;

  @JsonProperty("localizedNativeStatus")
  private String localizedNativeStatus;

  public LocalizedCustomerNativeStatusDto nativeStatus(CustomerNativeStatusDto nativeStatus) {
    this.nativeStatus = nativeStatus;
    return this;
  }

  /**
   * Get nativeStatus
   * @return nativeStatus
  */
  @ApiModelProperty(value = "")

  @Valid

  public CustomerNativeStatusDto getNativeStatus() {
    return nativeStatus;
  }

  public void setNativeStatus(CustomerNativeStatusDto nativeStatus) {
    this.nativeStatus = nativeStatus;
  }

  public LocalizedCustomerNativeStatusDto localizedNativeStatus(String localizedNativeStatus) {
    this.localizedNativeStatus = localizedNativeStatus;
    return this;
  }

  /**
   * Get localizedNativeStatus
   * @return localizedNativeStatus
  */
  @ApiModelProperty(value = "")


  public String getLocalizedNativeStatus() {
    return localizedNativeStatus;
  }

  public void setLocalizedNativeStatus(String localizedNativeStatus) {
    this.localizedNativeStatus = localizedNativeStatus;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LocalizedCustomerNativeStatusDto localizedCustomerNativeStatus = (LocalizedCustomerNativeStatusDto) o;
    return Objects.equals(this.nativeStatus, localizedCustomerNativeStatus.nativeStatus) &&
        Objects.equals(this.localizedNativeStatus, localizedCustomerNativeStatus.localizedNativeStatus);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nativeStatus, localizedNativeStatus);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LocalizedCustomerNativeStatusDto {\n");
    
    sb.append("    nativeStatus: ").append(toIndentedString(nativeStatus)).append("\n");
    sb.append("    localizedNativeStatus: ").append(toIndentedString(localizedNativeStatus)).append("\n");
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

