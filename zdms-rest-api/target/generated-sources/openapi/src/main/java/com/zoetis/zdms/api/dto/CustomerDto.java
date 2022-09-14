package com.zoetis.zdms.api.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.zoetis.zdms.api.dto.CustomerNativeStatusDto;
import com.zoetis.zdms.api.dto.CustomerStateDto;
import com.zoetis.zdms.api.dto.CustomerTypeDto;
import com.zoetis.zdms.api.dto.RejectionReasonDto;
import com.zoetis.zdms.api.dto.SourceSystemDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;


import java.util.*;

/**
 * CustomerDto
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-08-22T09:15:08.643330200-04:00[America/New_York]")
public class CustomerDto   {
  @JsonProperty("id")
  private String id;

  @JsonProperty("erpId")
  private String erpId;

  @JsonProperty("type")
  private CustomerTypeDto type;

  @JsonProperty("nativeStatus")
  private CustomerNativeStatusDto nativeStatus;

  @JsonProperty("companyName")
  private String companyName;

  @JsonProperty("address")
  private String address;

  @JsonProperty("state")
  private CustomerStateDto state;

  @JsonProperty("nativeCreatedDate")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime nativeCreatedDate;

  @JsonProperty("sourceSystem")
  private SourceSystemDto sourceSystem;

  @JsonProperty("rejectionReason")
  private RejectionReasonDto rejectionReason;

  public CustomerDto id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  @ApiModelProperty(value = "")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public CustomerDto erpId(String erpId) {
    this.erpId = erpId;
    return this;
  }

  /**
   * Get erpId
   * @return erpId
  */
  @ApiModelProperty(value = "")


  public String getErpId() {
    return erpId;
  }

  public void setErpId(String erpId) {
    this.erpId = erpId;
  }

  public CustomerDto type(CustomerTypeDto type) {
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

  public CustomerDto nativeStatus(CustomerNativeStatusDto nativeStatus) {
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

  public CustomerDto companyName(String companyName) {
    this.companyName = companyName;
    return this;
  }

  /**
   * Get companyName
   * @return companyName
  */
  @ApiModelProperty(value = "")


  public String getCompanyName() {
    return companyName;
  }

  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }

  public CustomerDto address(String address) {
    this.address = address;
    return this;
  }

  /**
   * Get address
   * @return address
  */
  @ApiModelProperty(value = "")


  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public CustomerDto state(CustomerStateDto state) {
    this.state = state;
    return this;
  }

  /**
   * Get state
   * @return state
  */
  @ApiModelProperty(value = "")

  @Valid

  public CustomerStateDto getState() {
    return state;
  }

  public void setState(CustomerStateDto state) {
    this.state = state;
  }

  public CustomerDto nativeCreatedDate(OffsetDateTime nativeCreatedDate) {
    this.nativeCreatedDate = nativeCreatedDate;
    return this;
  }

  /**
   * Get nativeCreatedDate
   * @return nativeCreatedDate
  */
  @ApiModelProperty(value = "")

  @Valid

  public OffsetDateTime getNativeCreatedDate() {
    return nativeCreatedDate;
  }

  public void setNativeCreatedDate(OffsetDateTime nativeCreatedDate) {
    this.nativeCreatedDate = nativeCreatedDate;
  }

  public CustomerDto sourceSystem(SourceSystemDto sourceSystem) {
    this.sourceSystem = sourceSystem;
    return this;
  }

  /**
   * Get sourceSystem
   * @return sourceSystem
  */
  @ApiModelProperty(value = "")

  @Valid

  public SourceSystemDto getSourceSystem() {
    return sourceSystem;
  }

  public void setSourceSystem(SourceSystemDto sourceSystem) {
    this.sourceSystem = sourceSystem;
  }

  public CustomerDto rejectionReason(RejectionReasonDto rejectionReason) {
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


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CustomerDto customer = (CustomerDto) o;
    return Objects.equals(this.id, customer.id) &&
        Objects.equals(this.erpId, customer.erpId) &&
        Objects.equals(this.type, customer.type) &&
        Objects.equals(this.nativeStatus, customer.nativeStatus) &&
        Objects.equals(this.companyName, customer.companyName) &&
        Objects.equals(this.address, customer.address) &&
        Objects.equals(this.state, customer.state) &&
        Objects.equals(this.nativeCreatedDate, customer.nativeCreatedDate) &&
        Objects.equals(this.sourceSystem, customer.sourceSystem) &&
        Objects.equals(this.rejectionReason, customer.rejectionReason);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, erpId, type, nativeStatus, companyName, address, state, nativeCreatedDate, sourceSystem, rejectionReason);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CustomerDto {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    erpId: ").append(toIndentedString(erpId)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    nativeStatus: ").append(toIndentedString(nativeStatus)).append("\n");
    sb.append("    companyName: ").append(toIndentedString(companyName)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    nativeCreatedDate: ").append(toIndentedString(nativeCreatedDate)).append("\n");
    sb.append("    sourceSystem: ").append(toIndentedString(sourceSystem)).append("\n");
    sb.append("    rejectionReason: ").append(toIndentedString(rejectionReason)).append("\n");
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

