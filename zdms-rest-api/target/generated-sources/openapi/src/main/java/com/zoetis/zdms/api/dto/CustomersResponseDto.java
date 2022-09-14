package com.zoetis.zdms.api.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.zoetis.zdms.api.dto.CustomerDto;
import com.zoetis.zdms.api.dto.PageInfoDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;


import java.util.*;

/**
 * CustomersResponseDto
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-08-22T09:15:08.643330200-04:00[America/New_York]")
public class CustomersResponseDto   {
  @JsonProperty("pageInfo")
  private PageInfoDto pageInfo;

  @JsonProperty("customers")
  @Valid
  private List<CustomerDto> customers = null;

  public CustomersResponseDto pageInfo(PageInfoDto pageInfo) {
    this.pageInfo = pageInfo;
    return this;
  }

  /**
   * Get pageInfo
   * @return pageInfo
  */
  @ApiModelProperty(value = "")

  @Valid

  public PageInfoDto getPageInfo() {
    return pageInfo;
  }

  public void setPageInfo(PageInfoDto pageInfo) {
    this.pageInfo = pageInfo;
  }

  public CustomersResponseDto customers(List<CustomerDto> customers) {
    this.customers = customers;
    return this;
  }

  public CustomersResponseDto addCustomersItem(CustomerDto customersItem) {
    if (this.customers == null) {
      this.customers = new ArrayList<>();
    }
    this.customers.add(customersItem);
    return this;
  }

  /**
   * Get customers
   * @return customers
  */
  @ApiModelProperty(value = "")

  @Valid

  public List<CustomerDto> getCustomers() {
    return customers;
  }

  public void setCustomers(List<CustomerDto> customers) {
    this.customers = customers;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CustomersResponseDto customersResponse = (CustomersResponseDto) o;
    return Objects.equals(this.pageInfo, customersResponse.pageInfo) &&
        Objects.equals(this.customers, customersResponse.customers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pageInfo, customers);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CustomersResponseDto {\n");
    
    sb.append("    pageInfo: ").append(toIndentedString(pageInfo)).append("\n");
    sb.append("    customers: ").append(toIndentedString(customers)).append("\n");
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

