package com.zoetis.zdms.api.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.zoetis.zdms.api.dto.CustomerNativeStatusDto;
import com.zoetis.zdms.api.dto.RejectionReasonDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;


import java.util.*;

/**
 * CustomerPartialDto
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-08-22T09:15:08.643330200-04:00[America/New_York]")
public class CustomerPartialDto   {
  @JsonProperty("nativeStatus")
  private CustomerNativeStatusDto nativeStatus;

  @JsonProperty("rejectionReason")
  private RejectionReasonDto rejectionReason;

  @JsonProperty("freeText")
  private String freeText;

  public CustomerPartialDto nativeStatus(CustomerNativeStatusDto nativeStatus) {
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

  public CustomerPartialDto rejectionReason(RejectionReasonDto rejectionReason) {
    this.rejectionReason = rejectionReason;
    return this;
  }

  /**
   * Get rejectionReason
   * @return rejectionReason
  */
  @ApiModelProperty(value = "")

  @Valid

  public RejectionReasonDto getRejectionReason() {
    return rejectionReason;
  }

  public void setRejectionReason(RejectionReasonDto rejectionReason) {
    this.rejectionReason = rejectionReason;
  }

  public CustomerPartialDto freeText(String freeText) {
    this.freeText = freeText;
    return this;
  }

  /**
   * Get freeText
   * @return freeText
  */
  @ApiModelProperty(value = "")

@Size(max = 127) 
  public String getFreeText() {
    return freeText;
  }

  public void setFreeText(String freeText) {
    this.freeText = freeText;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CustomerPartialDto customerPartial = (CustomerPartialDto) o;
    return Objects.equals(this.nativeStatus, customerPartial.nativeStatus) &&
        Objects.equals(this.rejectionReason, customerPartial.rejectionReason) &&
        Objects.equals(this.freeText, customerPartial.freeText);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nativeStatus, rejectionReason, freeText);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CustomerPartialDto {\n");
    
    sb.append("    nativeStatus: ").append(toIndentedString(nativeStatus)).append("\n");
    sb.append("    rejectionReason: ").append(toIndentedString(rejectionReason)).append("\n");
    sb.append("    freeText: ").append(toIndentedString(freeText)).append("\n");
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

