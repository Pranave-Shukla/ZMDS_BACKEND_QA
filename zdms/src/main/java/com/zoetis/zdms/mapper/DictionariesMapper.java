package com.zoetis.zdms.mapper;

import com.zoetis.zdms.api.dto.*;
import com.zoetis.zdms.model.dictionary.AccountType;
import com.zoetis.zdms.model.dictionary.CustomerStatus;
import com.zoetis.zdms.model.dictionary.localized.booleanvalue.LocalizedBooleanValue;
import com.zoetis.zdms.model.dictionary.localized.customerstate.LocalizedCustomerState;
import com.zoetis.zdms.model.dictionary.localized.customerstatus.LocalizedCustomerStatus;
import com.zoetis.zdms.model.dictionary.localized.customertype.LocalizedCustomerType;
import com.zoetis.zdms.model.dictionary.localized.errorcode.LocalizedErrorCode;
import com.zoetis.zdms.model.dictionary.localized.productavailability.LocalizedProductAvailability;
import com.zoetis.zdms.model.dictionary.localized.rejectionreason.LocalizedRejectionReason;
import org.apache.commons.lang3.ObjectUtils;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ValueMapping;

import java.util.List;
import java.util.Objects;

@Mapper(componentModel = "spring")
public interface DictionariesMapper {

    @ValueMapping(source = "VET_PRACTICE", target = "VET_PRACTICE")
    @ValueMapping(source = MappingConstants.ANY_UNMAPPED, target = "OTHER")
    CustomerTypeDto accountTypeToCustomerTypeDto(AccountType accountType);

    @Mapping(target = "value", source = "id.value")
    @Mapping(target = "localizedValue", source = "localizedValue")
    LocalizedBooleanValueDto mapLocalizedBooleanValueToDto(LocalizedBooleanValue localizedBooleanValue);

    List<LocalizedBooleanValueDto> mapLocalizedBooleanValuesToDto(List<LocalizedBooleanValue> localizedBooleanValues);

    @Mapping(target = "errorCode", source = "id.errorCode")
    @Mapping(target = "localizedErrorCode", source = "localizedErrorCode")
    LocalizedErrorCodeDto mapLocalizedErrorCodeToDto(LocalizedErrorCode localizedErrorCode);

    List<LocalizedErrorCodeDto> mapLocalizedErrorCodesToDto(List<LocalizedErrorCode> localizedErrorCodes);

    @Mapping(target = "state", source = "id.state")
    @Mapping(target = "localizedState", source = "localizedState")
    LocalizedCustomerStateDto mapLocalizedCustomerStateToDto(LocalizedCustomerState localizedCustomerState);

    List<LocalizedCustomerStateDto> mapLocalizedCustomerStatesToDto(List<LocalizedCustomerState> localizedCustomerStates);

    @Mapping(target = "nativeStatus", source = "id.status")
    @Mapping(target = "localizedNativeStatus", source = "localizedStatus")
    LocalizedCustomerNativeStatusDto mapLocalizedCustomerStatusToDto(LocalizedCustomerStatus localizedCustomerStatus);

    List<LocalizedCustomerNativeStatusDto> mapLocalizedCustomerStatusesToDto(List<LocalizedCustomerStatus> localizedCustomerStatuses);

    @Mapping(target = "type", source = "id.type")
    @Mapping(target = "localizedType", source = "localizedType")
    LocalizedCustomerTypeDto mapLocalizedCustomerTypeToDto(LocalizedCustomerType localizedCustomerType);

    List<LocalizedCustomerTypeDto> mapLocalizedCustomerTypesToDto(List<LocalizedCustomerType> localizedCustomerTypes);

    @Mapping(target = "availability", source = "id.availability")
    @Mapping(target = "localizedAvailability", source = "localizedAvailability")
    LocalizedProductAvailabilityDto mapLocalizedProductAvailabilityToDto(LocalizedProductAvailability localizedProductAvailability);

    List<LocalizedProductAvailabilityDto> mapLocalizedProductAvailabilitiesToDto(List<LocalizedProductAvailability> localizedProductAvailabilities);

    @Mapping(target = "rejectionReason", source = "id.rejectionReason")
    @Mapping(target = "localizedRejectionReason", source = "localizedRejectionReason")
    LocalizedRejectionReasonDto mapLocalizedRejectionReasonToDto(LocalizedRejectionReason rejectionReason);

    List<LocalizedRejectionReasonDto> mapLocalizedRejectionReasonsToDto(List<LocalizedRejectionReason> rejectionReasons);

    default DictionariesResponseDto mapDictionariesToDto(
            List<LocalizedCustomerState> localizedCustomerStates,
            List<LocalizedCustomerStatus> localizedCustomerStatuses,
            List<LocalizedCustomerType> localizedCustomerTypes,
            List<LocalizedRejectionReason> localizedRejectionReasons,
            List<LocalizedProductAvailability> localizedProductAvailabilities,
            List<LocalizedBooleanValue> localizedBooleanValues,
            List<LocalizedErrorCode> localizedErrorCodes) {
        return new DictionariesResponseDto()
                .localizedCustomerStates(mapLocalizedCustomerStatesToDto(localizedCustomerStates))
                .localizedCustomerNativeStatuses(mapLocalizedCustomerStatusesToDto(localizedCustomerStatuses))
                .localizedCustomerTypes(mapLocalizedCustomerTypesToDto(localizedCustomerTypes))
                .localizedRejectionReasons(mapLocalizedRejectionReasonsToDto(localizedRejectionReasons))
                .localizedProductAvailabilities(mapLocalizedProductAvailabilitiesToDto(localizedProductAvailabilities))
                .localizedBooleanValues(mapLocalizedBooleanValuesToDto(localizedBooleanValues))
                .localizedErrorCodes(mapLocalizedErrorCodesToDto(localizedErrorCodes));
    }

    default CustomerNativeStatusDto statusListToCustomerNativeStatusDto(com.zoetis.zdms.model.dictionary.CustomerStatus[] customerStatuses) {
        CustomerStatus nativeStatus = ObjectUtils.firstNonNull(customerStatuses);
        return Objects.nonNull(nativeStatus) ? CustomerNativeStatusDto.valueOf(nativeStatus.getValue()) : null;
    }
}
