package com.zoetis.zdms.api.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.zoetis.zdms.api.dto.LanguageDto;
import com.zoetis.zdms.api.dto.SearchProductsByDto;
import com.zoetis.zdms.api.dto.SortDirectionDto;
import com.zoetis.zdms.api.dto.SortProductsByDto;
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
 * ProductsRequestDto
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-08-22T09:15:08.643330200-04:00[America/New_York]")
public class ProductsRequestDto   {
  @JsonProperty("pageSize")
  private Integer pageSize = 10;

  @JsonProperty("pageNumber")
  private Integer pageNumber = 0;

  @JsonProperty("sortBy")
  private SortProductsByDto sortBy;

  @JsonProperty("sortDirection")
  private SortDirectionDto sortDirection;

  @JsonProperty("filters")
  @Valid
  private Set<SearchProductsByDto> filters = null;

  @JsonProperty("language")
  private LanguageDto language;

  public ProductsRequestDto pageSize(Integer pageSize) {
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

  public ProductsRequestDto pageNumber(Integer pageNumber) {
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

  public ProductsRequestDto sortBy(SortProductsByDto sortBy) {
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

  public SortProductsByDto getSortBy() {
    return sortBy;
  }

  public void setSortBy(SortProductsByDto sortBy) {
    this.sortBy = sortBy;
  }

  public ProductsRequestDto sortDirection(SortDirectionDto sortDirection) {
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

  public ProductsRequestDto filters(Set<SearchProductsByDto> filters) {
    this.filters = filters;
    return this;
  }

  public ProductsRequestDto addFiltersItem(SearchProductsByDto filtersItem) {
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

  public Set<SearchProductsByDto> getFilters() {
    return filters;
  }

  @JsonDeserialize(as = LinkedHashSet.class)
  public void setFilters(Set<SearchProductsByDto> filters) {
    this.filters = filters;
  }

  public ProductsRequestDto language(LanguageDto language) {
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
    ProductsRequestDto productsRequest = (ProductsRequestDto) o;
    return Objects.equals(this.pageSize, productsRequest.pageSize) &&
        Objects.equals(this.pageNumber, productsRequest.pageNumber) &&
        Objects.equals(this.sortBy, productsRequest.sortBy) &&
        Objects.equals(this.sortDirection, productsRequest.sortDirection) &&
        Objects.equals(this.filters, productsRequest.filters) &&
        Objects.equals(this.language, productsRequest.language);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pageSize, pageNumber, sortBy, sortDirection, filters, language);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductsRequestDto {\n");
    
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

