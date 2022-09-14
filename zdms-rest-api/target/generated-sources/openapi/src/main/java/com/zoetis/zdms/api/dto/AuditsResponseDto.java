package com.zoetis.zdms.api.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.zoetis.zdms.api.dto.AuditDto;
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
 * AuditsResponseDto
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-08-22T09:15:08.643330200-04:00[America/New_York]")
public class AuditsResponseDto   {
  @JsonProperty("pageInfo")
  private PageInfoDto pageInfo;

  @JsonProperty("audits")
  @Valid
  private List<AuditDto> audits = null;

  public AuditsResponseDto pageInfo(PageInfoDto pageInfo) {
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

  public AuditsResponseDto audits(List<AuditDto> audits) {
    this.audits = audits;
    return this;
  }

  public AuditsResponseDto addAuditsItem(AuditDto auditsItem) {
    if (this.audits == null) {
      this.audits = new ArrayList<>();
    }
    this.audits.add(auditsItem);
    return this;
  }

  /**
   * Get audits
   * @return audits
  */
  @ApiModelProperty(value = "")

  @Valid

  public List<AuditDto> getAudits() {
    return audits;
  }

  public void setAudits(List<AuditDto> audits) {
    this.audits = audits;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AuditsResponseDto auditsResponse = (AuditsResponseDto) o;
    return Objects.equals(this.pageInfo, auditsResponse.pageInfo) &&
        Objects.equals(this.audits, auditsResponse.audits);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pageInfo, audits);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AuditsResponseDto {\n");
    
    sb.append("    pageInfo: ").append(toIndentedString(pageInfo)).append("\n");
    sb.append("    audits: ").append(toIndentedString(audits)).append("\n");
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

