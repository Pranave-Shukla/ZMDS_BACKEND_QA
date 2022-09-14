package com.zoetis.zdms.api.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.zoetis.zdms.api.dto.ProductPartialDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;


import java.util.*;

/**
 * ProductPartialRequestDto
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-08-22T09:15:08.643330200-04:00[America/New_York]")
public class ProductPartialRequestDto   {
  @JsonProperty("productPartial")
  private ProductPartialDto productPartial;

  public ProductPartialRequestDto productPartial(ProductPartialDto productPartial) {
    this.productPartial = productPartial;
    return this;
  }

  /**
   * Get productPartial
   * @return productPartial
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public ProductPartialDto getProductPartial() {
    return productPartial;
  }

  public void setProductPartial(ProductPartialDto productPartial) {
    this.productPartial = productPartial;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProductPartialRequestDto productPartialRequest = (ProductPartialRequestDto) o;
    return Objects.equals(this.productPartial, productPartialRequest.productPartial);
  }

  @Override
  public int hashCode() {
    return Objects.hash(productPartial);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductPartialRequestDto {\n");
    
    sb.append("    productPartial: ").append(toIndentedString(productPartial)).append("\n");
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

