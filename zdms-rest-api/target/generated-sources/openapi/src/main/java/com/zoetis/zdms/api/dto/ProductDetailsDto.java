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
import java.time.OffsetDateTime;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;


import java.util.*;

/**
 * ProductDetailsDto
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-08-22T09:15:08.643330200-04:00[America/New_York]")
public class ProductDetailsDto   {
  @JsonProperty("id")
  private String id;

  @JsonProperty("isVisible")
  private BooleanValueDto isVisible;

  @JsonProperty("availability")
  private ProductAvailabilityDto availability;

  @JsonProperty("statusId")
  private String statusId;

  @JsonProperty("name")
  private String name;

  @JsonProperty("description")
  private String description;

  @JsonProperty("price")
  private Double price;

  @JsonProperty("minimumOrderQuantity")
  private Integer minimumOrderQuantity;

  @JsonProperty("maximumOrderQuantity")
  private Integer maximumOrderQuantity;

  @JsonProperty("associatedProducts")
  private String associatedProducts;

  @JsonProperty("imageFilename")
  private String imageFilename;

  @JsonProperty("imageFilepath")
  private String imageFilepath;

  @JsonProperty("imageUploadDate")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime imageUploadDate;

  @JsonProperty("sourceSystem")
  private SourceSystemDto sourceSystem;

  public ProductDetailsDto id(String id) {
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

  public ProductDetailsDto isVisible(BooleanValueDto isVisible) {
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

  public ProductDetailsDto availability(ProductAvailabilityDto availability) {
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

  public ProductDetailsDto statusId(String statusId) {
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

  public ProductDetailsDto name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  @ApiModelProperty(value = "")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ProductDetailsDto description(String description) {
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

  public ProductDetailsDto price(Double price) {
    this.price = price;
    return this;
  }

  /**
   * Get price
   * @return price
  */
  @ApiModelProperty(value = "")


  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public ProductDetailsDto minimumOrderQuantity(Integer minimumOrderQuantity) {
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

  public ProductDetailsDto maximumOrderQuantity(Integer maximumOrderQuantity) {
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

  public ProductDetailsDto associatedProducts(String associatedProducts) {
    this.associatedProducts = associatedProducts;
    return this;
  }

  /**
   * Get associatedProducts
   * @return associatedProducts
  */
  @ApiModelProperty(value = "")


  public String getAssociatedProducts() {
    return associatedProducts;
  }

  public void setAssociatedProducts(String associatedProducts) {
    this.associatedProducts = associatedProducts;
  }

  public ProductDetailsDto imageFilename(String imageFilename) {
    this.imageFilename = imageFilename;
    return this;
  }

  /**
   * Get imageFilename
   * @return imageFilename
  */
  @ApiModelProperty(value = "")


  public String getImageFilename() {
    return imageFilename;
  }

  public void setImageFilename(String imageFilename) {
    this.imageFilename = imageFilename;
  }

  public ProductDetailsDto imageFilepath(String imageFilepath) {
    this.imageFilepath = imageFilepath;
    return this;
  }

  /**
   * Get imageFilepath
   * @return imageFilepath
  */
  @ApiModelProperty(value = "")


  public String getImageFilepath() {
    return imageFilepath;
  }

  public void setImageFilepath(String imageFilepath) {
    this.imageFilepath = imageFilepath;
  }

  public ProductDetailsDto imageUploadDate(OffsetDateTime imageUploadDate) {
    this.imageUploadDate = imageUploadDate;
    return this;
  }

  /**
   * Get imageUploadDate
   * @return imageUploadDate
  */
  @ApiModelProperty(value = "")

  @Valid

  public OffsetDateTime getImageUploadDate() {
    return imageUploadDate;
  }

  public void setImageUploadDate(OffsetDateTime imageUploadDate) {
    this.imageUploadDate = imageUploadDate;
  }

  public ProductDetailsDto sourceSystem(SourceSystemDto sourceSystem) {
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
    ProductDetailsDto productDetails = (ProductDetailsDto) o;
    return Objects.equals(this.id, productDetails.id) &&
        Objects.equals(this.isVisible, productDetails.isVisible) &&
        Objects.equals(this.availability, productDetails.availability) &&
        Objects.equals(this.statusId, productDetails.statusId) &&
        Objects.equals(this.name, productDetails.name) &&
        Objects.equals(this.description, productDetails.description) &&
        Objects.equals(this.price, productDetails.price) &&
        Objects.equals(this.minimumOrderQuantity, productDetails.minimumOrderQuantity) &&
        Objects.equals(this.maximumOrderQuantity, productDetails.maximumOrderQuantity) &&
        Objects.equals(this.associatedProducts, productDetails.associatedProducts) &&
        Objects.equals(this.imageFilename, productDetails.imageFilename) &&
        Objects.equals(this.imageFilepath, productDetails.imageFilepath) &&
        Objects.equals(this.imageUploadDate, productDetails.imageUploadDate) &&
        Objects.equals(this.sourceSystem, productDetails.sourceSystem);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, isVisible, availability, statusId, name, description, price, minimumOrderQuantity, maximumOrderQuantity, associatedProducts, imageFilename, imageFilepath, imageUploadDate, sourceSystem);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductDetailsDto {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    isVisible: ").append(toIndentedString(isVisible)).append("\n");
    sb.append("    availability: ").append(toIndentedString(availability)).append("\n");
    sb.append("    statusId: ").append(toIndentedString(statusId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    minimumOrderQuantity: ").append(toIndentedString(minimumOrderQuantity)).append("\n");
    sb.append("    maximumOrderQuantity: ").append(toIndentedString(maximumOrderQuantity)).append("\n");
    sb.append("    associatedProducts: ").append(toIndentedString(associatedProducts)).append("\n");
    sb.append("    imageFilename: ").append(toIndentedString(imageFilename)).append("\n");
    sb.append("    imageFilepath: ").append(toIndentedString(imageFilepath)).append("\n");
    sb.append("    imageUploadDate: ").append(toIndentedString(imageUploadDate)).append("\n");
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

