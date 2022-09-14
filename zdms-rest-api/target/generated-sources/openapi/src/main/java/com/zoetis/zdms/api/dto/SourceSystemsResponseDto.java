package com.zoetis.zdms.api.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.zoetis.zdms.api.dto.SourceSystemDto;
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
 * SourceSystemsResponseDto
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-08-22T09:15:08.643330200-04:00[America/New_York]")
public class SourceSystemsResponseDto   {
  @JsonProperty("sourceSystems")
  @Valid
  private List<SourceSystemDto> sourceSystems = null;

  public SourceSystemsResponseDto sourceSystems(List<SourceSystemDto> sourceSystems) {
    this.sourceSystems = sourceSystems;
    return this;
  }

  public SourceSystemsResponseDto addSourceSystemsItem(SourceSystemDto sourceSystemsItem) {
    if (this.sourceSystems == null) {
      this.sourceSystems = new ArrayList<>();
    }
    this.sourceSystems.add(sourceSystemsItem);
    return this;
  }

  /**
   * Get sourceSystems
   * @return sourceSystems
  */
  @ApiModelProperty(value = "")

  @Valid

  public List<SourceSystemDto> getSourceSystems() {
    return sourceSystems;
  }

  public void setSourceSystems(List<SourceSystemDto> sourceSystems) {
    this.sourceSystems = sourceSystems;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SourceSystemsResponseDto sourceSystemsResponse = (SourceSystemsResponseDto) o;
    return Objects.equals(this.sourceSystems, sourceSystemsResponse.sourceSystems);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sourceSystems);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SourceSystemsResponseDto {\n");
    
    sb.append("    sourceSystems: ").append(toIndentedString(sourceSystems)).append("\n");
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

