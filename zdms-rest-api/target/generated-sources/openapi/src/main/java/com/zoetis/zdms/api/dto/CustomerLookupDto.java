package com.zoetis.zdms.api.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.zoetis.zdms.api.dto.CustomerContactDetailsDto;
import com.zoetis.zdms.api.dto.CustomerTypeDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;


import java.util.*;

/**
 * CustomerLookupDto
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-08-22T09:15:08.643330200-04:00[America/New_York]")
public class CustomerLookupDto   {
  @JsonProperty("erpId")
  private String erpId;

  @JsonProperty("type")
  private CustomerTypeDto type;

  @JsonProperty("name1")
  private String name1;

  @JsonProperty("name2")
  private String name2;

  @JsonProperty("name3")
  private String name3;

  @JsonProperty("name4")
  private String name4;

  @JsonProperty("title")
  private String title;

  @JsonProperty("streetAddress")
  private String streetAddress;

  @JsonProperty("postalCode")
  private String postalCode;

  @JsonProperty("countryCode")
  private String countryCode;

  @JsonProperty("city")
  private String city;

  @JsonProperty("contactDetails")
  private CustomerContactDetailsDto contactDetails;

  public CustomerLookupDto erpId(String erpId) {
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

  public CustomerLookupDto type(CustomerTypeDto type) {
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

  public CustomerLookupDto name1(String name1) {
    this.name1 = name1;
    return this;
  }

  /**
   * Get name1
   * @return name1
  */
  @ApiModelProperty(value = "")


  public String getName1() {
    return name1;
  }

  public void setName1(String name1) {
    this.name1 = name1;
  }

  public CustomerLookupDto name2(String name2) {
    this.name2 = name2;
    return this;
  }

  /**
   * Get name2
   * @return name2
  */
  @ApiModelProperty(value = "")


  public String getName2() {
    return name2;
  }

  public void setName2(String name2) {
    this.name2 = name2;
  }

  public CustomerLookupDto name3(String name3) {
    this.name3 = name3;
    return this;
  }

  /**
   * Get name3
   * @return name3
  */
  @ApiModelProperty(value = "")


  public String getName3() {
    return name3;
  }

  public void setName3(String name3) {
    this.name3 = name3;
  }

  public CustomerLookupDto name4(String name4) {
    this.name4 = name4;
    return this;
  }

  /**
   * Get name4
   * @return name4
  */
  @ApiModelProperty(value = "")


  public String getName4() {
    return name4;
  }

  public void setName4(String name4) {
    this.name4 = name4;
  }

  public CustomerLookupDto title(String title) {
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

  public CustomerLookupDto streetAddress(String streetAddress) {
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

  public CustomerLookupDto postalCode(String postalCode) {
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

  public CustomerLookupDto countryCode(String countryCode) {
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

  public CustomerLookupDto city(String city) {
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

  public CustomerLookupDto contactDetails(CustomerContactDetailsDto contactDetails) {
    this.contactDetails = contactDetails;
    return this;
  }

  /**
   * Get contactDetails
   * @return contactDetails
  */
  @ApiModelProperty(value = "")

  @Valid

  public CustomerContactDetailsDto getContactDetails() {
    return contactDetails;
  }

  public void setContactDetails(CustomerContactDetailsDto contactDetails) {
    this.contactDetails = contactDetails;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CustomerLookupDto customerLookup = (CustomerLookupDto) o;
    return Objects.equals(this.erpId, customerLookup.erpId) &&
        Objects.equals(this.type, customerLookup.type) &&
        Objects.equals(this.name1, customerLookup.name1) &&
        Objects.equals(this.name2, customerLookup.name2) &&
        Objects.equals(this.name3, customerLookup.name3) &&
        Objects.equals(this.name4, customerLookup.name4) &&
        Objects.equals(this.title, customerLookup.title) &&
        Objects.equals(this.streetAddress, customerLookup.streetAddress) &&
        Objects.equals(this.postalCode, customerLookup.postalCode) &&
        Objects.equals(this.countryCode, customerLookup.countryCode) &&
        Objects.equals(this.city, customerLookup.city) &&
        Objects.equals(this.contactDetails, customerLookup.contactDetails);
  }

  @Override
  public int hashCode() {
    return Objects.hash(erpId, type, name1, name2, name3, name4, title, streetAddress, postalCode, countryCode, city, contactDetails);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CustomerLookupDto {\n");
    
    sb.append("    erpId: ").append(toIndentedString(erpId)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    name1: ").append(toIndentedString(name1)).append("\n");
    sb.append("    name2: ").append(toIndentedString(name2)).append("\n");
    sb.append("    name3: ").append(toIndentedString(name3)).append("\n");
    sb.append("    name4: ").append(toIndentedString(name4)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    streetAddress: ").append(toIndentedString(streetAddress)).append("\n");
    sb.append("    postalCode: ").append(toIndentedString(postalCode)).append("\n");
    sb.append("    countryCode: ").append(toIndentedString(countryCode)).append("\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    contactDetails: ").append(toIndentedString(contactDetails)).append("\n");
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

