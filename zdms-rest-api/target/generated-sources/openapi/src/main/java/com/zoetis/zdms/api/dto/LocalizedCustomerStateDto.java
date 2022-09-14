package com.zoetis.zdms.api.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.zoetis.zdms.api.dto.CustomerStateDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;


import java.util.*;

/**
 * LocalizedCustomerStateDto
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-08-22T09:15:08.643330200-04:00[America/New_York]")
public class LocalizedCustomerStateDto   {
  @JsonProperty("state")
  private CustomerStateDto state;

  @JsonProperty("localizedState")
  private String localizedState;

  public LocalizedCustomerStateDto state(CustomerStateDto state) {
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

  public LocalizedCustomerStateDto localizedState(String localizedState) {
    this.localizedState = localizedState;
    return this;
  }

  /**
   * Get localizedState
   * @return localizedState
  */
  @ApiModelProperty(value = "")


  public String getLocalizedState() {
    return localizedState;
  }

  public void setLocalizedState(String localizedState) {
    this.localizedState = localizedState;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LocalizedCustomerStateDto localizedCustomerState = (LocalizedCustomerStateDto) o;
    return Objects.equals(this.state, localizedCustomerState.state) &&
        Objects.equals(this.localizedState, localizedCustomerState.localizedState);
  }

  @Override
  public int hashCode() {
    return Objects.hash(state, localizedState);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LocalizedCustomerStateDto {\n");
    
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    localizedState: ").append(toIndentedString(localizedState)).append("\n");
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

