package com.zoetis.zdms.api.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.zoetis.zdms.api.dto.BooleanValueDto;
import com.zoetis.zdms.api.dto.ProductAvailabilityDto;
import com.zoetis.zdms.api.dto.SourceSystemDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;


import java.util.*;

/**
 * ProductDto
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-08-22T09:15:08.643330200-04:00[America/New_York]")
public class ProductDto   {
  @JsonProperty("id")
  private String id;

  @JsonProperty("statusId")
  private String statusId;

  @JsonProperty("isVisible")
  private BooleanValueDto isVisible;

  @JsonProperty("availability")
  private ProductAvailabilityDto availability;

  @JsonProperty("description")
  private String description;

  @JsonProperty("minimumOrderQuantity")
  private Integer minimumOrderQuantity;

  @JsonProperty("maximumOrderQuantity")
  private Integer maximumOrderQuantity;

  @JsonProperty("hasMedia")
  private BooleanValueDto hasMedia;

  @JsonProperty("sourceSystem")
  private SourceSystemDto sourceSystem;

  public ProductDto id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  @ApiModelProperty(value = "")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ProductDto statusId(String statusId) {
    this.statusId = statusId;
    return this;
  }

  /**
   * Get statusId
   * @return statusId
  */
  @ApiModelProperty(value = "")


  public String getStatusId() {
    return statusId;
  }

  public void setStatusId(String statusId) {
    this.statusId = statusId;
  }

  public ProductDto isVisible(BooleanValueDto isVisible) {
    this.isVisible = isVisible;
    return this;
  }

  /**
   * Get isVisible
   * @return isVisible
  */
  @ApiModelProperty(value = "")

  @Valid

  public BooleanValueDto getIsVisible() {
    return isVisible;
  }

  public void setIsVisible(BooleanValueDto isVisible) {
    this.isVisible = isVisible;
  }

  public ProductDto availability(ProductAvailabilityDto availability) {
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

  public ProductDto description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
  */
  @ApiModelProperty(value = "")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ProductDto minimumOrderQuantity(Integer minimumOrderQuantity) {
    this.minimumOrderQuantity = minimumOrderQuantity;
    return this;
  }

  /**
   * Get minimumOrderQuantity
   * @return minimumOrderQuantity
  */
  @ApiModelProperty(value = "")


  public Integer getMinimumOrderQuantity() {
    return minimumOrderQuantity;
  }

  public void setMinimumOrderQuantity(Integer minimumOrderQuantity) {
    this.minimumOrderQuantity = minimumOrderQuantity;
  }

  public ProductDto maximumOrderQuantity(Integer maximumOrderQuantity) {
    this.maximumOrderQuantity = maximumOrderQuantity;
    return this;
  }

  /**
   * Get maximumOrderQuantity
   * @return maximumOrderQuantity
  */
  @ApiModelProperty(value = "")


  public Integer getMaximumOrderQuantity() {
    return maximumOrderQuantity;
  }

  public void setMaximumOrderQuantity(Integer maximumOrderQuantity) {
    this.maximumOrderQuantity = maximumOrderQuantity;
  }

  public ProductDto hasMedia(BooleanValueDto hasMedia) {
    this.hasMedia = hasMedia;
    return this;
  }

  /**
   * Get hasMedia
   * @return hasMedia
  */
  @ApiModelProperty(value = "")

  @Valid

  public BooleanValueDto getHasMedia() {
    return hasMedia;
  }

  public void setHasMedia(BooleanValueDto hasMedia) {
    this.hasMedia = hasMedia;
  }

  public ProductDto sourceSystem(SourceSystemDto sourceSystem) {
    this.sourceSystem = sourceSystem;
    return this;
  }

  /**
   * Get sourceSystem
   * @return sourceSystem
  */
  @ApiModelProperty(value = "")

  @Valid

  public SourceSystemDto getSourceSystem() {
    return sourceSystem;
  }

  public void setSourceSystem(SourceSystemDto sourceSystem) {
    this.sourceSystem = sourceSystem;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProductDto product = (ProductDto) o;
    return Objects.equals(this.id, product.id) &&
        Objects.equals(this.statusId, product.statusId) &&
        Objects.equals(this.isVisible, product.isVisible) &&
        Objects.equals(this.availability, product.availability) &&
        Objects.equals(this.description, product.description) &&
        Objects.equals(this.minimumOrderQuantity, product.minimumOrderQuantity) &&
        Objects.equals(this.maximumOrderQuantity, product.maximumOrderQuantity) &&
        Objects.equals(this.hasMedia, product.hasMedia) &&
        Objects.equals(this.sourceSystem, product.sourceSystem);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, statusId, isVisible, availability, description, minimumOrderQuantity, maximumOrderQuantity, hasMedia, sourceSystem);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductDto {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    statusId: ").append(toIndentedString(statusId)).append("\n");
    sb.append("    isVisible: ").append(toIndentedString(isVisible)).append("\n");
    sb.append("    availability: ").append(toIndentedString(availability)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    minimumOrderQuantity: ").append(toIndentedString(minimumOrderQuantity)).append("\n");
    sb.append("    maximumOrderQuantity: ").append(toIndentedString(maximumOrderQuantity)).append("\n");
    sb.append("    hasMedia: ").append(toIndentedString(hasMedia)).append("\n");
    sb.append("    sourceSystem: ").append(toIndentedString(sourceSystem)).append("\n");
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

