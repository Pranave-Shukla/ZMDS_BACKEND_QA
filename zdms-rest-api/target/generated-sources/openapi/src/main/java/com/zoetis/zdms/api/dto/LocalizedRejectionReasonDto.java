package com.zoetis.zdms.api.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.zoetis.zdms.api.dto.RejectionReasonDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;


import java.util.*;

/**
 * LocalizedRejectionReasonDto
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-08-22T09:15:08.643330200-04:00[America/New_York]")
public class LocalizedRejectionReasonDto   {
  @JsonProperty("rejectionReason")
  private RejectionReasonDto rejectionReason;

  @JsonProperty("localizedRejectionReason")
  private String localizedRejectionReason;

  public LocalizedRejectionReasonDto rejectionReason(RejectionReasonDto rejectionReason) {
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

  public LocalizedRejectionReasonDto localizedRejectionReason(String localizedRejectionReason) {
    this.localizedRejectionReason = localizedRejectionReason;
    return this;
  }

  /**
   * Get localizedRejectionReason
   * @return localizedRejectionReason
  */
  @ApiModelProperty(value = "")


  public String getLocalizedRejectionReason() {
    return localizedRejectionReason;
  }

  public void setLocalizedRejectionReason(String localizedRejectionReason) {
    this.localizedRejectionReason = localizedRejectionReason;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LocalizedRejectionReasonDto localizedRejectionReason = (LocalizedRejectionReasonDto) o;
    return Objects.equals(this.rejectionReason, localizedRejectionReason.rejectionReason) &&
        Objects.equals(this.localizedRejectionReason, localizedRejectionReason.localizedRejectionReason);
  }

  @Override
  public int hashCode() {
    return Objects.hash(rejectionReason, localizedRejectionReason);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LocalizedRejectionReasonDto {\n");
    
    sb.append("    rejectionReason: ").append(toIndentedString(rejectionReason)).append("\n");
    sb.append("    localizedRejectionReason: ").append(toIndentedString(localizedRejectionReason)).append("\n");
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

