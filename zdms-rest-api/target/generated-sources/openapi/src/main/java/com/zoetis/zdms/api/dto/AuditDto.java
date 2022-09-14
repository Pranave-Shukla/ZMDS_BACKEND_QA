package com.zoetis.zdms.api.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.zoetis.zdms.api.dto.AuditDataSetDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;


import java.util.*;

/**
 * AuditDto
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-08-22T09:15:08.643330200-04:00[America/New_York]")
public class AuditDto   {
  @JsonProperty("dataSet")
  private AuditDataSetDto dataSet;

  @JsonProperty("header")
  private String header;

  @JsonProperty("message")
  private String message;

  @JsonProperty("initiator")
  private String initiator;

  @JsonProperty("date")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime date;

  public AuditDto dataSet(AuditDataSetDto dataSet) {
    this.dataSet = dataSet;
    return this;
  }

  /**
   * Get dataSet
   * @return dataSet
  */
  @ApiModelProperty(value = "")

  @Valid

  public AuditDataSetDto getDataSet() {
    return dataSet;
  }

  public void setDataSet(AuditDataSetDto dataSet) {
    this.dataSet = dataSet;
  }

  public AuditDto header(String header) {
    this.header = header;
    return this;
  }

  /**
   * Get header
   * @return header
  */
  @ApiModelProperty(value = "")


  public String getHeader() {
    return header;
  }

  public void setHeader(String header) {
    this.header = header;
  }

  public AuditDto message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Get message
   * @return message
  */
  @ApiModelProperty(value = "")


  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public AuditDto initiator(String initiator) {
    this.initiator = initiator;
    return this;
  }

  /**
   * Get initiator
   * @return initiator
  */
  @ApiModelProperty(value = "")


  public String getInitiator() {
    return initiator;
  }

  public void setInitiator(String initiator) {
    this.initiator = initiator;
  }

  public AuditDto date(OffsetDateTime date) {
    this.date = date;
    return this;
  }

  /**
   * Get date
   * @return date
  */
  @ApiModelProperty(value = "")

  @Valid

  public OffsetDateTime getDate() {
    return date;
  }

  public void setDate(OffsetDateTime date) {
    this.date = date;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AuditDto audit = (AuditDto) o;
    return Objects.equals(this.dataSet, audit.dataSet) &&
        Objects.equals(this.header, audit.header) &&
        Objects.equals(this.message, audit.message) &&
        Objects.equals(this.initiator, audit.initiator) &&
        Objects.equals(this.date, audit.date);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dataSet, header, message, initiator, date);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AuditDto {\n");
    
    sb.append("    dataSet: ").append(toIndentedString(dataSet)).append("\n");
    sb.append("    header: ").append(toIndentedString(header)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    initiator: ").append(toIndentedString(initiator)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
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

