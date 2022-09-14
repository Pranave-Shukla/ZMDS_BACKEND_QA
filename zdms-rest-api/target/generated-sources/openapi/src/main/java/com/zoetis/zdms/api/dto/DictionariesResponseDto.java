package com.zoetis.zdms.api.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.zoetis.zdms.api.dto.LocalizedBooleanValueDto;
import com.zoetis.zdms.api.dto.LocalizedCustomerNativeStatusDto;
import com.zoetis.zdms.api.dto.LocalizedCustomerStateDto;
import com.zoetis.zdms.api.dto.LocalizedCustomerTypeDto;
import com.zoetis.zdms.api.dto.LocalizedErrorCodeDto;
import com.zoetis.zdms.api.dto.LocalizedProductAvailabilityDto;
import com.zoetis.zdms.api.dto.LocalizedRejectionReasonDto;
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
 * DictionariesResponseDto
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-08-22T09:15:08.643330200-04:00[America/New_York]")
public class DictionariesResponseDto   {
  @JsonProperty("localizedCustomerStates")
  @Valid
  private List<LocalizedCustomerStateDto> localizedCustomerStates = null;

  @JsonProperty("localizedCustomerNativeStatuses")
  @Valid
  private List<LocalizedCustomerNativeStatusDto> localizedCustomerNativeStatuses = null;

  @JsonProperty("localizedCustomerTypes")
  @Valid
  private List<LocalizedCustomerTypeDto> localizedCustomerTypes = null;

  @JsonProperty("localizedRejectionReasons")
  @Valid
  private List<LocalizedRejectionReasonDto> localizedRejectionReasons = null;

  @JsonProperty("localizedProductAvailabilities")
  @Valid
  private List<LocalizedProductAvailabilityDto> localizedProductAvailabilities = null;

  @JsonProperty("localizedBooleanValues")
  @Valid
  private List<LocalizedBooleanValueDto> localizedBooleanValues = null;

  @JsonProperty("localizedErrorCodes")
  @Valid
  private List<LocalizedErrorCodeDto> localizedErrorCodes = null;

  public DictionariesResponseDto localizedCustomerStates(List<LocalizedCustomerStateDto> localizedCustomerStates) {
    this.localizedCustomerStates = localizedCustomerStates;
    return this;
  }

  public DictionariesResponseDto addLocalizedCustomerStatesItem(LocalizedCustomerStateDto localizedCustomerStatesItem) {
    if (this.localizedCustomerStates == null) {
      this.localizedCustomerStates = new ArrayList<>();
    }
    this.localizedCustomerStates.add(localizedCustomerStatesItem);
    return this;
  }

  /**
   * Get localizedCustomerStates
   * @return localizedCustomerStates
  */
  @ApiModelProperty(value = "")

  @Valid

  public List<LocalizedCustomerStateDto> getLocalizedCustomerStates() {
    return localizedCustomerStates;
  }

  public void setLocalizedCustomerStates(List<LocalizedCustomerStateDto> localizedCustomerStates) {
    this.localizedCustomerStates = localizedCustomerStates;
  }

  public DictionariesResponseDto localizedCustomerNativeStatuses(List<LocalizedCustomerNativeStatusDto> localizedCustomerNativeStatuses) {
    this.localizedCustomerNativeStatuses = localizedCustomerNativeStatuses;
    return this;
  }

  public DictionariesResponseDto addLocalizedCustomerNativeStatusesItem(LocalizedCustomerNativeStatusDto localizedCustomerNativeStatusesItem) {
    if (this.localizedCustomerNativeStatuses == null) {
      this.localizedCustomerNativeStatuses = new ArrayList<>();
    }
    this.localizedCustomerNativeStatuses.add(localizedCustomerNativeStatusesItem);
    return this;
  }

  /**
   * Get localizedCustomerNativeStatuses
   * @return localizedCustomerNativeStatuses
  */
  @ApiModelProperty(value = "")

  @Valid

  public List<LocalizedCustomerNativeStatusDto> getLocalizedCustomerNativeStatuses() {
    return localizedCustomerNativeStatuses;
  }

  public void setLocalizedCustomerNativeStatuses(List<LocalizedCustomerNativeStatusDto> localizedCustomerNativeStatuses) {
    this.localizedCustomerNativeStatuses = localizedCustomerNativeStatuses;
  }

  public DictionariesResponseDto localizedCustomerTypes(List<LocalizedCustomerTypeDto> localizedCustomerTypes) {
    this.localizedCustomerTypes = localizedCustomerTypes;
    return this;
  }

  public DictionariesResponseDto addLocalizedCustomerTypesItem(LocalizedCustomerTypeDto localizedCustomerTypesItem) {
    if (this.localizedCustomerTypes == null) {
      this.localizedCustomerTypes = new ArrayList<>();
    }
    this.localizedCustomerTypes.add(localizedCustomerTypesItem);
    return this;
  }

  /**
   * Get localizedCustomerTypes
   * @return localizedCustomerTypes
  */
  @ApiModelProperty(value = "")

  @Valid

  public List<LocalizedCustomerTypeDto> getLocalizedCustomerTypes() {
    return localizedCustomerTypes;
  }

  public void setLocalizedCustomerTypes(List<LocalizedCustomerTypeDto> localizedCustomerTypes) {
    this.localizedCustomerTypes = localizedCustomerTypes;
  }

  public DictionariesResponseDto localizedRejectionReasons(List<LocalizedRejectionReasonDto> localizedRejectionReasons) {
    this.localizedRejectionReasons = localizedRejectionReasons;
    return this;
  }

  public DictionariesResponseDto addLocalizedRejectionReasonsItem(LocalizedRejectionReasonDto localizedRejectionReasonsItem) {
    if (this.localizedRejectionReasons == null) {
      this.localizedRejectionReasons = new ArrayList<>();
    }
    this.localizedRejectionReasons.add(localizedRejectionReasonsItem);
    return this;
  }

  /**
   * Get localizedRejectionReasons
   * @return localizedRejectionReasons
  */
  @ApiModelProperty(value = "")

  @Valid

  public List<LocalizedRejectionReasonDto> getLocalizedRejectionReasons() {
    return localizedRejectionReasons;
  }

  public void setLocalizedRejectionReasons(List<LocalizedRejectionReasonDto> localizedRejectionReasons) {
    this.localizedRejectionReasons = localizedRejectionReasons;
  }

  public DictionariesResponseDto localizedProductAvailabilities(List<LocalizedProductAvailabilityDto> localizedProductAvailabilities) {
    this.localizedProductAvailabilities = localizedProductAvailabilities;
    return this;
  }

  public DictionariesResponseDto addLocalizedProductAvailabilitiesItem(LocalizedProductAvailabilityDto localizedProductAvailabilitiesItem) {
    if (this.localizedProductAvailabilities == null) {
      this.localizedProductAvailabilities = new ArrayList<>();
    }
    this.localizedProductAvailabilities.add(localizedProductAvailabilitiesItem);
    return this;
  }

  /**
   * Get localizedProductAvailabilities
   * @return localizedProductAvailabilities
  */
  @ApiModelProperty(value = "")

  @Valid

  public List<LocalizedProductAvailabilityDto> getLocalizedProductAvailabilities() {
    return localizedProductAvailabilities;
  }

  public void setLocalizedProductAvailabilities(List<LocalizedProductAvailabilityDto> localizedProductAvailabilities) {
    this.localizedProductAvailabilities = localizedProductAvailabilities;
  }

  public DictionariesResponseDto localizedBooleanValues(List<LocalizedBooleanValueDto> localizedBooleanValues) {
    this.localizedBooleanValues = localizedBooleanValues;
    return this;
  }

  public DictionariesResponseDto addLocalizedBooleanValuesItem(LocalizedBooleanValueDto localizedBooleanValuesItem) {
    if (this.localizedBooleanValues == null) {
      this.localizedBooleanValues = new ArrayList<>();
    }
    this.localizedBooleanValues.add(localizedBooleanValuesItem);
    return this;
  }

  /**
   * Get localizedBooleanValues
   * @return localizedBooleanValues
  */
  @ApiModelProperty(value = "")

  @Valid

  public List<LocalizedBooleanValueDto> getLocalizedBooleanValues() {
    return localizedBooleanValues;
  }

  public void setLocalizedBooleanValues(List<LocalizedBooleanValueDto> localizedBooleanValues) {
    this.localizedBooleanValues = localizedBooleanValues;
  }

  public DictionariesResponseDto localizedErrorCodes(List<LocalizedErrorCodeDto> localizedErrorCodes) {
    this.localizedErrorCodes = localizedErrorCodes;
    return this;
  }

  public DictionariesResponseDto addLocalizedErrorCodesItem(LocalizedErrorCodeDto localizedErrorCodesItem) {
    if (this.localizedErrorCodes == null) {
      this.localizedErrorCodes = new ArrayList<>();
    }
    this.localizedErrorCodes.add(localizedErrorCodesItem);
    return this;
  }

  /**
   * Get localizedErrorCodes
   * @return localizedErrorCodes
  */
  @ApiModelProperty(value = "")

  @Valid

  public List<LocalizedErrorCodeDto> getLocalizedErrorCodes() {
    return localizedErrorCodes;
  }

  public void setLocalizedErrorCodes(List<LocalizedErrorCodeDto> localizedErrorCodes) {
    this.localizedErrorCodes = localizedErrorCodes;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DictionariesResponseDto dictionariesResponse = (DictionariesResponseDto) o;
    return Objects.equals(this.localizedCustomerStates, dictionariesResponse.localizedCustomerStates) &&
        Objects.equals(this.localizedCustomerNativeStatuses, dictionariesResponse.localizedCustomerNativeStatuses) &&
        Objects.equals(this.localizedCustomerTypes, dictionariesResponse.localizedCustomerTypes) &&
        Objects.equals(this.localizedRejectionReasons, dictionariesResponse.localizedRejectionReasons) &&
        Objects.equals(this.localizedProductAvailabilities, dictionariesResponse.localizedProductAvailabilities) &&
        Objects.equals(this.localizedBooleanValues, dictionariesResponse.localizedBooleanValues) &&
        Objects.equals(this.localizedErrorCodes, dictionariesResponse.localizedErrorCodes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(localizedCustomerStates, localizedCustomerNativeStatuses, localizedCustomerTypes, localizedRejectionReasons, localizedProductAvailabilities, localizedBooleanValues, localizedErrorCodes);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DictionariesResponseDto {\n");
    
    sb.append("    localizedCustomerStates: ").append(toIndentedString(localizedCustomerStates)).append("\n");
    sb.append("    localizedCustomerNativeStatuses: ").append(toIndentedString(localizedCustomerNativeStatuses)).append("\n");
    sb.append("    localizedCustomerTypes: ").append(toIndentedString(localizedCustomerTypes)).append("\n");
    sb.append("    localizedRejectionReasons: ").append(toIndentedString(localizedRejectionReasons)).append("\n");
    sb.append("    localizedProductAvailabilities: ").append(toIndentedString(localizedProductAvailabilities)).append("\n");
    sb.append("    localizedBooleanValues: ").append(toIndentedString(localizedBooleanValues)).append("\n");
    sb.append("    localizedErrorCodes: ").append(toIndentedString(localizedErrorCodes)).append("\n");
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

