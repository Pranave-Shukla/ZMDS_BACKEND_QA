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
 * CustomerDetailsDto
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-08-22T09:15:08.643330200-04:00[America/New_York]")
public class CustomerDetailsDto   {
  @JsonProperty("id")
  private String id;

  @JsonProperty("erpId")
  private String erpId;

  @JsonProperty("firstName")
  private String firstName;

  @JsonProperty("lastName")
  private String lastName;

  @JsonProperty("nativeId")
  private String nativeId;

  @JsonProperty("title")
  private String title;

  @JsonProperty("companyName")
  private String companyName;

  @JsonProperty("streetAddress")
  private String streetAddress;

  @JsonProperty("postalCode")
  private String postalCode;

  @JsonProperty("countryCode")
  private String countryCode;

  @JsonProperty("city")
  private String city;

  @JsonProperty("type")
  private CustomerTypeDto type;

  @JsonProperty("nativeStatus")
  private CustomerNativeStatusDto nativeStatus;

  @JsonProperty("state")
  private CustomerStateDto state;

  @JsonProperty("nativeCreatedDate")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime nativeCreatedDate;

  @JsonProperty("sourceSystem")
  private SourceSystemDto sourceSystem;

  @JsonProperty("rejectionReason")
  private RejectionReasonDto rejectionReason;

  @JsonProperty("freeText")
  private String freeText;

  public CustomerDetailsDto id(String id) {
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

  public CustomerDetailsDto erpId(String erpId) {
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

  public CustomerDetailsDto firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * Get firstName
   * @return firstName
  */
  @ApiModelProperty(value = "")


  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public CustomerDetailsDto lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  /**
   * Get lastName
   * @return lastName
  */
  @ApiModelProperty(value = "")


  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public CustomerDetailsDto nativeId(String nativeId) {
    this.nativeId = nativeId;
    return this;
  }

  /**
   * Get nativeId
   * @return nativeId
  */
  @ApiModelProperty(value = "")


  public String getNativeId() {
    return nativeId;
  }

  public void setNativeId(String nativeId) {
    this.nativeId = nativeId;
  }

  public CustomerDetailsDto title(String title) {
    this.title = title;
    return this;
  }

  /**
   * Get title
   * @return title
  */
  @ApiModelProperty(value = "")


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public CustomerDetailsDto companyName(String companyName) {
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

  public CustomerDetailsDto streetAddress(String streetAddress) {
    this.streetAddress = streetAddress;
    return this;
  }

  /**
   * Get streetAddress
   * @return streetAddress
  */
  @ApiModelProperty(value = "")


  public String getStreetAddress() {
    return streetAddress;
  }

  public void setStreetAddress(String streetAddress) {
    this.streetAddress = streetAddress;
  }

  public CustomerDetailsDto postalCode(String postalCode) {
    this.postalCode = postalCode;
    return this;
  }

  /**
   * Get postalCode
   * @return postalCode
  */
  @ApiModelProperty(value = "")


  public String getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }

  public CustomerDetailsDto countryCode(String countryCode) {
    this.countryCode = countryCode;
    return this;
  }

  /**
   * Get countryCode
   * @return countryCode
  */
  @ApiModelProperty(value = "")


  public String getCountryCode() {
    return countryCode;
  }

  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
  }

  public CustomerDetailsDto city(String city) {
    this.city = city;
    return this;
  }

  /**
   * Get city
   * @return city
  */
  @ApiModelProperty(value = "")


  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public CustomerDetailsDto type(CustomerTypeDto type) {
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

  public CustomerDetailsDto nativeStatus(CustomerNativeStatusDto nativeStatus) {
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

  public CustomerDetailsDto state(CustomerStateDto state) {
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

  public CustomerDetailsDto nativeCreatedDate(OffsetDateTime nativeCreatedDate) {
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

  public CustomerDetailsDto sourceSystem(SourceSystemDto sourceSystem) {
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

  public CustomerDetailsDto rejectionReason(RejectionReasonDto rejectionReason) {
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

  public CustomerDetailsDto freeText(String freeText) {
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
    CustomerDetailsDto customerDetails = (CustomerDetailsDto) o;
    return Objects.equals(this.id, customerDetails.id) &&
        Objects.equals(this.erpId, customerDetails.erpId) &&
        Objects.equals(this.firstName, customerDetails.firstName) &&
        Objects.equals(this.lastName, customerDetails.lastName) &&
        Objects.equals(this.nativeId, customerDetails.nativeId) &&
        Objects.equals(this.title, customerDetails.title) &&
        Objects.equals(this.companyName, customerDetails.companyName) &&
        Objects.equals(this.streetAddress, customerDetails.streetAddress) &&
        Objects.equals(this.postalCode, customerDetails.postalCode) &&
        Objects.equals(this.countryCode, customerDetails.countryCode) &&
        Objects.equals(this.city, customerDetails.city) &&
        Objects.equals(this.type, customerDetails.type) &&
        Objects.equals(this.nativeStatus, customerDetails.nativeStatus) &&
        Objects.equals(this.state, customerDetails.state) &&
        Objects.equals(this.nativeCreatedDate, customerDetails.nativeCreatedDate) &&
        Objects.equals(this.sourceSystem, customerDetails.sourceSystem) &&
        Objects.equals(this.rejectionReason, customerDetails.rejectionReason) &&
        Objects.equals(this.freeText, customerDetails.freeText);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, erpId, firstName, lastName, nativeId, title, companyName, streetAddress, postalCode, countryCode, city, type, nativeStatus, state, nativeCreatedDate, sourceSystem, rejectionReason, freeText);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CustomerDetailsDto {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    erpId: ").append(toIndentedString(erpId)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    nativeId: ").append(toIndentedString(nativeId)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    companyName: ").append(toIndentedString(companyName)).append("\n");
    sb.append("    streetAddress: ").append(toIndentedString(streetAddress)).append("\n");
    sb.append("    postalCode: ").append(toIndentedString(postalCode)).append("\n");
    sb.append("    countryCode: ").append(toIndentedString(countryCode)).append("\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    nativeStatus: ").append(toIndentedString(nativeStatus)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    nativeCreatedDate: ").append(toIndentedString(nativeCreatedDate)).append("\n");
    sb.append("    sourceSystem: ").append(toIndentedString(sourceSystem)).append("\n");
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

