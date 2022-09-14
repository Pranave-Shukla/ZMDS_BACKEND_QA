package com.zoetis.zdms.api.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.zoetis.zdms.api.dto.ProductAvailabilityDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;


import java.util.*;

/**
 * LocalizedProductAvailabilityDto
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-08-22T09:15:08.643330200-04:00[America/New_York]")
public class LocalizedProductAvailabilityDto   {
  @JsonProperty("availability")
  private ProductAvailabilityDto availability;

  @JsonProperty("localizedAvailability")
  private String localizedAvailability;

  public LocalizedProductAvailabilityDto availability(ProductAvailabilityDto availability) {
    this.availability = availability;
    return this;
  }

  /**
   * Get availability
   * @return availability
  */
  @ApiModelProperty(value = "")

  @Valid

  public ProductAvailabilityDto getAvailability() {
    return availability;
  }

  public void setAvailability(ProductAvailabilityDto availability) {
    this.availability = availability;
  }

  public LocalizedProductAvailabilityDto localizedAvailability(String localizedAvailability) {
    this.localizedAvailability = localizedAvailability;
    return this;
  }

  /**
   * Get localizedAvailability
   * @return localizedAvailability
  */
  @ApiModelProperty(value = "")


  public String getLocalizedAvailability() {
    return localizedAvailability;
  }

  public void setLocalizedAvailability(String localizedAvailability) {
    this.localizedAvailability = localizedAvailability;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LocalizedProductAvailabilityDto localizedProductAvailability = (LocalizedProductAvailabilityDto) o;
    return Objects.equals(this.availability, localizedProductAvailability.availability) &&
        Objects.equals(this.localizedAvailability, localizedProductAvailability.localizedAvailability);
  }

  @Override
  public int hashCode() {
    return Objects.hash(availability, localizedAvailability);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LocalizedProductAvailabilityDto {\n");
    
    sb.append("    availability: ").append(toIndentedString(availability)).append("\n");
    sb.append("    localizedAvailability: ").append(toIndentedString(localizedAvailability)).append("\n");
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

