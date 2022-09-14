package com.zoetis.zdms.api.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.zoetis.zdms.api.dto.CustomerLookupDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;


import java.util.*;

/**
 * CustomerLookupResponseDto
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-08-22T09:15:08.643330200-04:00[America/New_York]")
public class CustomerLookupResponseDto   {
  @JsonProperty("customerLookup")
  private CustomerLookupDto customerLookup;

  public CustomerLookupResponseDto customerLookup(CustomerLookupDto customerLookup) {
    this.customerLookup = customerLookup;
    return this;
  }

  /**
   * Get customerLookup
   * @return customerLookup
  */
  @ApiModelProperty(value = "")

  @Valid

  public CustomerLookupDto getCustomerLookup() {
    return customerLookup;
  }

  public void setCustomerLookup(CustomerLookupDto customerLookup) {
    this.customerLookup = customerLookup;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CustomerLookupResponseDto customerLookupResponse = (CustomerLookupResponseDto) o;
    return Objects.equals(this.customerLookup, customerLookupResponse.customerLookup);
  }

  @Override
  public int hashCode() {
    return Objects.hash(customerLookup);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CustomerLookupResponseDto {\n");
    
    sb.append("    customerLookup: ").append(toIndentedString(customerLookup)).append("\n");
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

