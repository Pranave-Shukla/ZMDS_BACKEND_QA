package com.zoetis.zdms.api.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.zoetis.zdms.api.dto.LanguageDto;
import com.zoetis.zdms.api.dto.SearchCustomersByDto;
import com.zoetis.zdms.api.dto.SortCustomersByDto;
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
 * CustomersRequestDto
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-08-22T09:15:08.643330200-04:00[America/New_York]")
public class CustomersRequestDto   {
  @JsonProperty("pageSize")
  private Integer pageSize = 10;

  @JsonProperty("pageNumber")
  private Integer pageNumber = 0;

  @JsonProperty("sortBy")
  private SortCustomersByDto sortBy;

  @JsonProperty("sortDirection")
  private SortDirectionDto sortDirection;

  @JsonProperty("filters")
  @Valid
  private Set<SearchCustomersByDto> filters = null;

  @JsonProperty("language")
  private LanguageDto language;

  public CustomersRequestDto pageSize(Integer pageSize) {
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

  public CustomersRequestDto pageNumber(Integer pageNumber) {
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

  public CustomersRequestDto sortBy(SortCustomersByDto sortBy) {
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

  public SortCustomersByDto getSortBy() {
    return sortBy;
  }

  public void setSortBy(SortCustomersByDto sortBy) {
    this.sortBy = sortBy;
  }

  public CustomersRequestDto sortDirection(SortDirectionDto sortDirection) {
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

  public CustomersRequestDto filters(Set<SearchCustomersByDto> filters) {
    this.filters = filters;
    return this;
  }

  public CustomersRequestDto addFiltersItem(SearchCustomersByDto filtersItem) {
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

  public Set<SearchCustomersByDto> getFilters() {
    return filters;
  }

  @JsonDeserialize(as = LinkedHashSet.class)
  public void setFilters(Set<SearchCustomersByDto> filters) {
    this.filters = filters;
  }

  public CustomersRequestDto language(LanguageDto language) {
    this.language = language;
    return this;
  }

  /**
   * Get language
   * @return language
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public LanguageDto getLanguage() {
    return language;
  }

  public void setLanguage(LanguageDto language) {
    this.language = language;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CustomersRequestDto customersRequest = (CustomersRequestDto) o;
    return Objects.equals(this.pageSize, customersRequest.pageSize) &&
        Objects.equals(this.pageNumber, customersRequest.pageNumber) &&
        Objects.equals(this.sortBy, customersRequest.sortBy) &&
        Objects.equals(this.sortDirection, customersRequest.sortDirection) &&
        Objects.equals(this.filters, customersRequest.filters) &&
        Objects.equals(this.language, customersRequest.language);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pageSize, pageNumber, sortBy, sortDirection, filters, language);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CustomersRequestDto {\n");
    
    sb.append("    pageSize: ").append(toIndentedString(pageSize)).append("\n");
    sb.append("    pageNumber: ").append(toIndentedString(pageNumber)).append("\n");
    sb.append("    sortBy: ").append(toIndentedString(sortBy)).append("\n");
    sb.append("    sortDirection: ").append(toIndentedString(sortDirection)).append("\n");
    sb.append("    filters: ").append(toIndentedString(filters)).append("\n");
    sb.append("    language: ").append(toIndentedString(language)).append("\n");
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

