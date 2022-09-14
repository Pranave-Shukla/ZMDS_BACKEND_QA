package com.zoetis.zdms.api.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.zoetis.zdms.api.dto.NullableBooleanValueDto;
import com.zoetis.zdms.api.dto.NullableProductAvailabilityDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Arrays;
import org.openapitools.jackson.nullable.JsonNullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;


import java.util.*;

/**
 * ProductPartialDto
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-08-22T09:15:08.643330200-04:00[America/New_York]")
public class ProductPartialDto   {
  @JsonProperty("isVisible")
  private JsonNullable<NullableBooleanValueDto> isVisible = JsonNullable.undefined();

  @JsonProperty("availability")
  private JsonNullable<NullableProductAvailabilityDto> availability = JsonNullable.undefined();

  @JsonProperty("minimumOrderQuantity")
  private JsonNullable<Integer> minimumOrderQuantity = JsonNullable.undefined();

  @JsonProperty("maximumOrderQuantity")
  private JsonNullable<Integer> maximumOrderQuantity = JsonNullable.undefined();

  @JsonProperty("associatedProducts")
  private JsonNullable<String> associatedProducts = JsonNullable.undefined();

  @JsonProperty("image")
  private JsonNullable<String> image = JsonNullable.undefined();

  @JsonProperty("imageFilename")
  private JsonNullable<String> imageFilename = JsonNullable.undefined();

  public ProductPartialDto isVisible(NullableBooleanValueDto isVisible) {
    this.isVisible = JsonNullable.of(isVisible);
    return this;
  }

  /**
   * Get isVisible
   * @return isVisible
  */
  @ApiModelProperty(value = "")

  @Valid

  public JsonNullable<NullableBooleanValueDto> getIsVisible() {
    return isVisible;
  }

  public void setIsVisible(JsonNullable<NullableBooleanValueDto> isVisible) {
    this.isVisible = isVisible;
  }

  public ProductPartialDto availability(NullableProductAvailabilityDto availability) {
    this.availability = JsonNullable.of(availability);
    return this;
  }

  /**
   * Get availability
   * @return availability
  */
  @ApiModelProperty(value = "")

  @Valid

  public JsonNullable<NullableProductAvailabilityDto> getAvailability() {
    return availability;
  }

  public void setAvailability(JsonNullable<NullableProductAvailabilityDto> availability) {
    this.availability = availability;
  }

  public ProductPartialDto minimumOrderQuantity(Integer minimumOrderQuantity) {
    this.minimumOrderQuantity = JsonNullable.of(minimumOrderQuantity);
    return this;
  }

  /**
   * Get minimumOrderQuantity
   * @return minimumOrderQuantity
  */
  @ApiModelProperty(value = "")


  public JsonNullable<Integer> getMinimumOrderQuantity() {
    return minimumOrderQuantity;
  }

  public void setMinimumOrderQuantity(JsonNullable<Integer> minimumOrderQuantity) {
    this.minimumOrderQuantity = minimumOrderQuantity;
  }

  public ProductPartialDto maximumOrderQuantity(Integer maximumOrderQuantity) {
    this.maximumOrderQuantity = JsonNullable.of(maximumOrderQuantity);
    return this;
  }

  /**
   * Get maximumOrderQuantity
   * @return maximumOrderQuantity
  */
  @ApiModelProperty(value = "")


  public JsonNullable<Integer> getMaximumOrderQuantity() {
    return maximumOrderQuantity;
  }

  public void setMaximumOrderQuantity(JsonNullable<Integer> maximumOrderQuantity) {
    this.maximumOrderQuantity = maximumOrderQuantity;
  }

  public ProductPartialDto associatedProducts(String associatedProducts) {
    this.associatedProducts = JsonNullable.of(associatedProducts);
    return this;
  }

  /**
   * Get associatedProducts
   * @return associatedProducts
  */
  @ApiModelProperty(value = "")


  public JsonNullable<String> getAssociatedProducts() {
    return associatedProducts;
  }

  public void setAssociatedProducts(JsonNullable<String> associatedProducts) {
    this.associatedProducts = associatedProducts;
  }

  public ProductPartialDto image(String image) {
    this.image = JsonNullable.of(image);
    return this;
  }

  /**
   * Get image
   * @return image
  */
  @ApiModelProperty(value = "")


  public JsonNullable<String> getImage() {
    return image;
  }

  public void setImage(JsonNullable<String> image) {
    this.image = image;
  }

  public ProductPartialDto imageFilename(String imageFilename) {
    this.imageFilename = JsonNullable.of(imageFilename);
    return this;
  }

  /**
   * Get imageFilename
   * @return imageFilename
  */
  @ApiModelProperty(value = "")


  public JsonNullable<String> getImageFilename() {
    return imageFilename;
  }

  public void setImageFilename(JsonNullable<String> imageFilename) {
    this.imageFilename = imageFilename;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProductPartialDto productPartial = (ProductPartialDto) o;
    return Objects.equals(this.isVisible, productPartial.isVisible) &&
        Objects.equals(this.availability, productPartial.availability) &&
        Objects.equals(this.minimumOrderQuantity, productPartial.minimumOrderQuantity) &&
        Objects.equals(this.maximumOrderQuantity, productPartial.maximumOrderQuantity) &&
        Objects.equals(this.associatedProducts, productPartial.associatedProducts) &&
        Objects.equals(this.image, productPartial.image) &&
        Objects.equals(this.imageFilename, productPartial.imageFilename);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(isVisible, availability, minimumOrderQuantity, maximumOrderQuantity, associatedProducts, image, imageFilename);
  }

  private static <T> int hashCodeNullable(JsonNullable<T> a) {
    if (a == null) {
      return 1;
    }
    return a.isPresent() ? Arrays.deepHashCode(new Object[]{a.get()}) : 31;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductPartialDto {\n");
    
    sb.append("    isVisible: ").append(toIndentedString(isVisible)).append("\n");
    sb.append("    availability: ").append(toIndentedString(availability)).append("\n");
    sb.append("    minimumOrderQuantity: ").append(toIndentedString(minimumOrderQuantity)).append("\n");
    sb.append("    maximumOrderQuantity: ").append(toIndentedString(maximumOrderQuantity)).append("\n");
    sb.append("    associatedProducts: ").append(toIndentedString(associatedProducts)).append("\n");
    sb.append("    image: ").append(toIndentedString(image)).append("\n");
    sb.append("    imageFilename: ").append(toIndentedString(imageFilename)).append("\n");
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

