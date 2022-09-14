package com.zoetis.zdms.api.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.zoetis.zdms.api.dto.ErrorCodeDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;


import java.util.*;

/**
 * LocalizedErrorCodeDto
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-08-22T09:15:08.643330200-04:00[America/New_York]")
public class LocalizedErrorCodeDto   {
  @JsonProperty("errorCode")
  private ErrorCodeDto errorCode;

  @JsonProperty("localizedErrorCode")
  private String localizedErrorCode;

  public LocalizedErrorCodeDto errorCode(ErrorCodeDto errorCode) {
    this.errorCode = errorCode;
    return this;
  }

  /**
   * Get errorCode
   * @return errorCode
  */
  @ApiModelProperty(value = "")

  @Valid

  public ErrorCodeDto getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(ErrorCodeDto errorCode) {
    this.errorCode = errorCode;
  }

  public LocalizedErrorCodeDto localizedErrorCode(String localizedErrorCode) {
    this.localizedErrorCode = localizedErrorCode;
    return this;
  }

  /**
   * Get localizedErrorCode
   * @return localizedErrorCode
  */
  @ApiModelProperty(value = "")


  public String getLocalizedErrorCode() {
    return localizedErrorCode;
  }

  public void setLocalizedErrorCode(String localizedErrorCode) {
    this.localizedErrorCode = localizedErrorCode;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LocalizedErrorCodeDto localizedErrorCode = (LocalizedErrorCodeDto) o;
    return Objects.equals(this.errorCode, localizedErrorCode.errorCode) &&
        Objects.equals(this.localizedErrorCode, localizedErrorCode.localizedErrorCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(errorCode, localizedErrorCode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LocalizedErrorCodeDto {\n");
    
    sb.append("    errorCode: ").append(toIndentedString(errorCode)).append("\n");
    sb.append("    localizedErrorCode: ").append(toIndentedString(localizedErrorCode)).append("\n");
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

