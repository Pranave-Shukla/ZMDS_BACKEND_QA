package com.zoetis.zdms.api.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.zoetis.zdms.api.dto.CustomerPartialDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;


import java.util.*;

/**
 * CustomerPartialRequestDto
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-08-22T09:15:08.643330200-04:00[America/New_York]")
public class CustomerPartialRequestDto   {
  @JsonProperty("customerPartial")
  private CustomerPartialDto customerPartial;

  public CustomerPartialRequestDto customerPartial(CustomerPartialDto customerPartial) {
    this.customerPartial = customerPartial;
    return this;
  }

  /**
   * Get customerPartial
   * @return customerPartial
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public CustomerPartialDto getCustomerPartial() {
    return customerPartial;
  }

  public void setCustomerPartial(CustomerPartialDto customerPartial) {
    this.customerPartial = customerPartial;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CustomerPartialRequestDto customerPartialRequest = (CustomerPartialRequestDto) o;
    return Objects.equals(this.customerPartial, customerPartialRequest.customerPartial);
  }

  @Override
  public int hashCode() {
    return Objects.hash(customerPartial);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CustomerPartialRequestDto {\n");
    
    sb.append("    customerPartial: ").append(toIndentedString(customerPartial)).append("\n");
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

