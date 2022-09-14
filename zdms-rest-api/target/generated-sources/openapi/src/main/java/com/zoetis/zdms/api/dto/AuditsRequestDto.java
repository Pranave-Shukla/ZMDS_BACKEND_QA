package com.zoetis.zdms.api.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.zoetis.zdms.api.dto.SearchAuditsByDto;
import com.zoetis.zdms.api.dto.SortAuditsByDto;
import com.zoetis.zdms.api.dto.SortDirectionDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;


import java.util.*;

/**
 * AuditsRequestDto
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-08-22T09:15:08.643330200-04:00[America/New_York]")
public class AuditsRequestDto   {
  @JsonProperty("pageSize")
  private Integer pageSize = 10;

  @JsonProperty("pageNumber")
  private Integer pageNumber = 0;

  @JsonProperty("sortBy")
  private SortAuditsByDto sortBy;

  @JsonProperty("sortDirection")
  private SortDirectionDto sortDirection;

  @JsonProperty("filters")
  @Valid
  private Set<SearchAuditsByDto> filters = null;

  public AuditsRequestDto pageSize(Integer pageSize) {
    this.pageSize = pageSize;
    return this;
  }

  /**
   * Get pageSize
   * minimum: 0
   * @return pageSize
  */
  @ApiModelProperty(value = "")

@Min(0) 
  public Integer getPageSize() {
    return pageSize;
  }

  public void setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
  }

  public AuditsRequestDto pageNumber(Integer pageNumber) {
    this.pageNumber = pageNumber;
    return this;
  }

  /**
   * Get pageNumber
   * minimum: 0
   * @return pageNumber
  */
  @ApiModelProperty(value = "")

@Min(0) 
  public Integer getPageNumber() {
    return pageNumber;
  }

  public void setPageNumber(Integer pageNumber) {
    this.pageNumber = pageNumber;
  }

  public AuditsRequestDto sortBy(SortAuditsByDto sortBy) {
    this.sortBy = sortBy;
    return this;
  }

  /**
   * Get sortBy
   * @return sortBy
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public SortAuditsByDto getSortBy() {
    return sortBy;
  }

  public void setSortBy(SortAuditsByDto sortBy) {
    this.sortBy = sortBy;
  }

  public AuditsRequestDto sortDirection(SortDirectionDto sortDirection) {
    this.sortDirection = sortDirection;
    return this;
  }

  /**
   * Get sortDirection
   * @return sortDirection
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public SortDirectionDto getSortDirection() {
    return sortDirection;
  }

  public void setSortDirection(SortDirectionDto sortDirection) {
    this.sortDirection = sortDirection;
  }

  public AuditsRequestDto filters(Set<SearchAuditsByDto> filters) {
    this.filters = filters;
    return this;
  }

  public AuditsRequestDto addFiltersItem(SearchAuditsByDto filtersItem) {
    if (this.filters == null) {
      this.filters = new LinkedHashSet<>();
    }
    this.filters.add(filtersItem);
    return this;
  }

  /**
   * Get filters
   * @return filters
  */
  @ApiModelProperty(value = "")

  @Valid

  public Set<SearchAuditsByDto> getFilters() {
    return filters;
  }

  @JsonDeserialize(as = LinkedHashSet.class)
  public void setFilters(Set<SearchAuditsByDto> filters) {
    this.filters = filters;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AuditsRequestDto auditsRequest = (AuditsRequestDto) o;
    return Objects.equals(this.pageSize, auditsRequest.pageSize) &&
        Objects.equals(this.pageNumber, auditsRequest.pageNumber) &&
        Objects.equals(this.sortBy, auditsRequest.sortBy) &&
        Objects.equals(this.sortDirection, auditsRequest.sortDirection) &&
        Objects.equals(this.filters, auditsRequest.filters);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pageSize, pageNumber, sortBy, sortDirection, filters);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AuditsRequestDto {\n");
    
    sb.append("    pageSize: ").append(toIndentedString(pageSize)).append("\n");
    sb.append("    pageNumber: ").append(toIndentedString(pageNumber)).append("\n");
    sb.append("    sortBy: ").append(toIndentedString(sortBy)).append("\n");
    sb.append("    sortDirection: ").append(toIndentedString(sortDirection)).append("\n");
    sb.append("    filters: ").append(toIndentedString(filters)).append("\n");
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

